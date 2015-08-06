base.checkAndCreate("$w")
 
$w.handleChange = (e) ->
  base.handleChange($w.app,e.target.name,e.target.value);
$w.tabClick= (tab) ->
  tabkey={
      tabkey:tab
    }
  $w.app.setState(tabkey)  
$w.handleClick = (e) ->
  jsx=$w.app
  name=e.target.name
  if name=="alert#CloseBtn"
     $w.flux.actions.base_alertHide()
  if name=="deleteCfm#CloseBtn"
     $w.flux.actions.base_deleteCfmHide()
  if name=="deleteCfm#YesBtn"
     $w.flux.actions.base_deleteCfmHide()
     $w.formDeleteCfm(jsx)
  if name == "btnNew"
    $w.formClear(jsx)
  if name == "btnSearch"
    $w.formSearch(jsx)
  if name == "btnUpdate"
    $w.formUpdate(jsx)
  if name == "btnDelete"
    $w.formDelete(jsx)
    ids=[]
  if typeof(e.target.id)=="undefined"
    return
  ids=e.target.id.split("#")
  if (ids[0] == "loginrow")
    logintemp={login:jsx.state.login}
    selRow = Number(ids[2])
    logintemp.login.selRow=selRow
    logintemp.form=_.cloneDeep(logintemp.login.rcds[selRow])
    logintemp.form.password=""
    logintemp.form.passwordcfm=""
    jsx.setState(logintemp)
$w.formSearch = (jsx) ->
  criteria=base.createCriteria(jsx.state.search,["loginId","name"])
  $w.flux.actions.base_rcd_fetch(jsx.state.login,jsx.state.form,"login",criteria)
$w.formUpdate = (jsx) ->
  form = jsx.state.form
  res = ""
  if form.id==""
    rules = []
    rules.push("required,loginId,Login IDは必須項目です"); 
    rules.push("required,name,氏名は必須項目です"); 
    rules.push("required,password,パスワードは必須項目です");  
    rules.push("required,passwordcfm,パスワード（確認）は必須項目です");  
    rules.push("same_as,password,passwordcfm,パスワードとパスワード（確認）が一致しません");  
    res = rsv.validate(form,rules)
  else
    rules = []
    rules.push("required,loginId,Login IDは必須項目です"); 
    rules.push("required,name,氏名は必須項目です"); 
    rules.push("function,$w.formUpdateCheck")
    res = rsv.validate(form,rules)
  if res.length > 0
    $w.flux.actions.base_alertShow(res)
    return
  $w.flux.actions.base_rcd_update(jsx.state.login,jsx.state.form,"login")
$w.formDelete = (jsx) ->
  if jsx.state.form.id == ""
    $w.flux.actions.base_rcd_delete_id_blank()
    return
  $w.flux.actions.base_deleteCfmShow()
$w.formDeleteCfm = (jsx) ->
  $w.flux.actions.base_rcd_delete(jsx.state.login,jsx.state.form,"login")
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
$w.rcdStore.on("rcdComplete_login", ->
  rcdLogin=_.cloneDeep($w.app.state.rcd.login)
  loginTemp={
    login:$w.app.state.login
  }
  loginTemp.login.rcds=rcdLogin.rcds
  loginTemp.form=rcdLogin.rcd
  loginTemp.login.selRow=rcdLogin.selRow
  $w.app.setState(loginTemp) 
)

