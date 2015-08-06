base.checkAndCreate("$w")
 
$w.handleChange = (e) ->
  jsx=$w.app
  names = e.target.name.split("#");
  if (names[0] == "loginrow")
    logintemp={login:jsx.state.login}
    logintemp.login.rcds[names[2]][names[1]]=e.target.value
    jsx.setState(logintemp)
    return
  base.handleChange(jsx,e.target.name,e.target.value);
$w.setFocus = (ref,def) ->
  refnode=$w.loginRows.refs[ref]
  if typeof(refnode)=="undefined"
    refnode=$w.loginRows.refs[def]
  refnode.getInputDOMNode().focus()
$w.handleClick = (e) ->
  jsx=$w.app
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
    jsx.setState(logintemp,$w.setFocus.bind(this,ref,def))
  if name=="alert#CloseBtn"
     $w.flux.actions.base_alertHide()
  if name=="deleteCfm#CloseBtn"
     $w.flux.actions.base_deleteCfmHide()
  if name=="deleteCfm#YesBtn"
     $w.flux.actions.base_deleteCfmHide()
     $w.formDeleteCfm(jsx)
  if name == "btnCancel"
    $w.formCancel(jsx)
  if name == "btnSearch"
    $w.formSearch(jsx)
  if name == "btnUpdate"
    $w.formUpdate(jsx)
  if name == "btnDelete"
    $w.formDelete(jsx)
$w.handleRowKeyDown = (e) ->
  jsx=$w.app
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
  jsx.setState(logintemp,$w.setFocus.bind(this,ref,def))
$w.formSearch = (jsx) ->
  criteria=base.createCriteria(jsx.state.search,["loginId","name"])
  $w.flux.actions.base_rcd_fetch(jsx.state.login,jsx.state.form,"login",criteria)
$w.formUpdate = (jsx) ->
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
      $w.flux.actions.base_alertShow(res) 
      logintemp={login:jsx.state.login}
      logintemp.login.i
      ref="loginrow#loginId#"+i
      def=ref
      jsx.setState(logintemp,$w.setFocus.bind(this,ref,def))
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
    $w.flux.actions.base_rcd_transaction(jsx.state.login,params,"login")
$w.formDelete = (jsx) ->
  if jsx.state.form.id == ""
    $w.flux.actions.base_rcd_delete_id_blank()
    return
  $w.flux.actions.base_deleteCfmShow()
$w.formCancel = (jsx) ->
  $w.rcdSet()
$w.formDeleteCfm = (jsx) ->
  $w.flux.actions.base_rcd_delete(jsx.state.login,jsx.state.login.rcds[jsx.state.login.selRow],"login")
$w.formUpdateCheck = (form) ->
  if form.password>"" || form.passwordcfm>""
    if form.password != form.passwordcfm
      return [["", "パスワードとパスワード（確認）が一致しません"]]
  return ""
 
$w.formClear = (jsx) ->
  formtemp={
      form:_.cloneDeep(jsx.state.login.blank)
  }
  jsx.setState(formtemp)
$w.drop = (jsx,from,to) ->
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
$w.constants =
  $W_LOGIN_SUCCESS: "$W_LOGIN_SUCCESS"


$w.actions = {
  logoffClick: ->
    this.dispatch(base.constants.base_LOADING)
    base.ajaxPostJson("/ajax/logout","","application/json",
      base.ajaxCallback.bind(this,"",$w.constants.$W_LOGOFF_SUCCESS))
} 

$w.PageStore = Fluxxor.createStore(
  initialize: ->
    @data = 
      {
      }
    #@bindActions $w.constants.$W_LOGIN_SUCCESS, @onLoginSuccess,

    return
) 

$w.flux = new Fluxxor.Flux()
$w.pageStore=new $w.PageStore;
$w.flux.addStore("PAGE",$w.pageStore)
$w.flux.addActions($w.actions)
$w.commonStore=new base.CommonStore;
$w.flux.addStore("COMMON",$w.commonStore)
$w.flux.addActions(base.actions)
$w.rcdStore=new base.RcdStore;
$w.flux.addStore("RCD",$w.rcdStore)
$w.flux.addActions(base.rcdActions)
rcdStore = $w.flux.store("RCD")
rcdStore.addTable("login")
$w.FluxMixin = Fluxxor.FluxMixin(React)
$w.StoreWatchMixin = Fluxxor.StoreWatchMixin
$w.rcdSet = ->
  rcdLogin=_.cloneDeep($w.app.state.rcd.login)
  loginTemp={
    login:$w.app.state.login
  }
  loginTemp.login.rcds=rcdLogin.rcds
  loginTemp.form=rcdLogin.rcd
  loginTemp.login.selRow=rcdLogin.selRow
  $w.app.setState(loginTemp)
$w.rcdStore.on("rcdComplete_login", ->
  $w.rcdSet()
)

