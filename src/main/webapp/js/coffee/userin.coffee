base.checkAndCreate("wObj")
 
wObj.handleChange = (e) ->
  jsx=wObj.application
  names = e.target.name.split("#");
  if (names[0] == "loginrow")
    logintemp={login:jsx.state.login}
    logintemp.login.rcds[names[2]][names[1]]=e.target.value
    jsx.setState(logintemp)
    return
  base.handleChange(jsx,e.target.name,e.target.value);
wObj.setFocus = (ref,def) ->
  refnode=wObj.loginRows.refs[ref]
  if typeof(refnode)=="undefined"
    refnode=wObj.loginRows.refs[def]
  refnode.getInputDOMNode().focus()
wObj.handleClick = (e) ->
  jsx=wObj.application
  name=e.target.name 
  ids = e.target.id.split("#");  
  if (ids[0] == "loginrow")
    logintemp={login:jsx.state.login}
    selRow = Number(ids[2]) 
    logintemp.login.selRow=selRow
    logintemp.form=_.cloneDeep(logintemp.login.rcds[selRow])
    logintemp.form.password=""
    logintemp.form.passwordcfm=""
    ref="loginrow#"+ids[1]+"#"+selRow
    def="loginrow#loginId#"+selRow
    jsx.setState(logintemp,wObj.setFocus.bind(this,ref,def))
  if name=="alert#CloseBtn"
     wObj.flux.actions.base_alertHide()
  if name=="deleteCfm#CloseBtn"
     wObj.flux.actions.base_deleteCfmHide()
  if name=="deleteCfm#YesBtn"
     wObj.flux.actions.base_deleteCfmHide()
     wObj.formDeleteCfm(jsx)
  if name == "btnCancel"
    wObj.formCancel(jsx)
  if name == "btnSearch"
    wObj.formSearch(jsx)
  if name == "btnUpdate"
    wObj.formUpdate(jsx)
  if name == "btnDelete"
    wObj.formDelete(jsx)
wObj.handleRowKeyDown = (e) ->
  jsx=wObj.application
  name=e.target.name
  names=name.split("#")
  logintemp={login:jsx.state.login}
  curRow = logintemp.login.selRow
  done = false
  if e.key =="ArrowDown"
    curRow++
    done = true
  if e.key =="ArrowUp"
    curRow--
    done = true
  if e.key =="Enter"
    done = true
  if done == false
    return
  if curRow < 0
    curRow =0
  if curRow > (logintemp.login.rcds.length - 1)
    logintemp.login.rcds.push(logintemp.login.blank)
  if e.key =="Enter"
    logintemp.login.selRow = -1
    jsx.setState(logintemp)
    return
  logintemp.login.selRow = curRow
  ref="loginrow#"+names[1]+"#"+curRow
  def="loginrow#loginId#"+curRow
  jsx.setState(logintemp,wObj.setFocus.bind(this,ref,def))
wObj.formSearch = (jsx) ->
  criteria=base.createCriteria(jsx.state.search,["loginId","name"])
  wObj.flux.actions.base_rcd_fetch(jsx.state.login,jsx.state.form,"login",criteria)
wObj.formUpdate = (jsx) ->
  oldrcds=jsx.state.rcd.login.rcds
  rcds=jsx.state.login.rcds
  rules = []
  rules.push("required,loginId,Login IDは必須項目です"); 
  rules.push("required,name,氏名は必須項目です"); 
  params = {
    transactions:[]
  }
  for rcd,i in rcds
    res = rsv.validate(rcd,rules)
    if res.length > 0
      wObj.flux.actions.base_alertShow(res) 
      logintemp={login:jsx.state.login}
      logintemp.login.i
      ref="loginrow#loginId#"+i
      def=ref
      jsx.setState(logintemp,wObj.setFocus.bind(this,ref,def))
      return 
    if rcd.id == ""
      rcd.password="kam" 
      rcd.passwordcfm="kam"  
      tran={
        operationType:"add"
        data:rcd
      } 
      params.transactions.push(tran)
    else
      oldrecord= base.getRecordById(oldrcds,rcd.id)
      dirty=base.dirtyCheck(oldrecord,rcd)
      if dirty
        rcd.password="" 
        rcd.passwordcfm="" 
        tran={
        operationType:"update"
        data:rcd
        } 
        params.transactions.push(tran)
  if params.transactions.length > 0
    wObj.flux.actions.base_rcd_transaction(jsx.state.login,params,"login")
wObj.formDelete = (jsx) ->
  if jsx.state.form.id == ""
    wObj.flux.actions.base_rcd_delete_id_blank()
    return
  wObj.flux.actions.base_deleteCfmShow()
wObj.formCancel = (jsx) ->
  wObj.rcdSet()
wObj.formDeleteCfm = (jsx) ->
  wObj.flux.actions.base_rcd_delete(jsx.state.login,jsx.state.login.rcds[jsx.state.login.selRow],"login")
wObj.formUpdateCheck = (form) ->
  if form.password>"" || form.passwordcfm>""
    if form.password != form.passwordcfm
      return [["", "パスワードとパスワード（確認）が一致しません"]]
  return ""
 
wObj.formClear = (jsx) ->
  formtemp={
      form:_.cloneDeep(jsx.state.login.blank)
  }
  jsx.setState(formtemp)
wObj.drop = (jsx,from,to) ->
  froms=from.split("#")
  tos=to.split("#")
  fromno=Number(froms[froms.length-1])
  tono=Number(tos[tos.length-1])
  rcds=jsx.state.login.rcds
  newrcds=[]
  for rcd,i in rcds
    if i ==tono
       newrcds.push(rcds[fromno])
       newrcds.push(rcds[tono])
    else
      if i != fromno
        newrcds.push(rcds[i])
  temp=jsx.state.login
  temp.rcds=newrcds
  jsx.setState(temp)
wObj.constants =
  $W_LOGIN_SUCCESS: "$W_LOGIN_SUCCESS"


wObj.actions = {
  logoffClick: ->
    this.dispatch(base.constants.base_LOADING)
    base.ajaxPostJson("/ajax/logout","","application/json",
      base.ajaxCallback.bind(this,"",wObj.constants.$W_LOGOFF_SUCCESS))
} 

wObj.PageStore = Fluxxor.createStore(
  initialize: ->
    @data = 
      {
      }
    #@bindActions wObj.constants.$W_LOGIN_SUCCESS, @onLoginSuccess,

    return
) 

wObj.flux = new Fluxxor.Flux()
wObj.pageStore=new wObj.PageStore;
wObj.flux.addStore("PAGE",wObj.pageStore)
wObj.flux.addActions(wObj.actions)
wObj.commonStore=new base.CommonStore;
wObj.flux.addStore("COMMON",wObj.commonStore)
wObj.flux.addActions(base.actions)
wObj.rcdStore=new base.RcdStore;
wObj.flux.addStore("RCD",wObj.rcdStore)
wObj.flux.addActions(base.rcdActions)
rcdStore = wObj.flux.store("RCD")
rcdStore.addTable("login")
wObj.FluxMixin = Fluxxor.FluxMixin(React)
wObj.StoreWatchMixin = Fluxxor.StoreWatchMixin
wObj.rcdSet = ->
  rcdLogin=_.cloneDeep(wObj.application.state.rcd.login)
  loginTemp={
    login:wObj.application.state.login
  }
  loginTemp.login.rcds=rcdLogin.rcds
  loginTemp.form=rcdLogin.rcd
  loginTemp.login.selRow=rcdLogin.selRow
  wObj.application.setState(loginTemp)
wObj.rcdStore.on("rcdComplete_login", ->
  wObj.rcdSet()
)

