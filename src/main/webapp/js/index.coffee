$c.checkAndCreate("$w")
$w.windowArray = []
$w.maxWindow = -1

$w.windowOpen = (jspath) -> 
  w = window.open($c_contextpath + jspath, '_blank',"");
  window.focus();
  $w.maxWindow = $w.maxWindow + 1
  $w.windowArray[$w.maxWindow] = w

$w.windowClose  = -> 
  for i in [0..$w.maxWindow]
    if (typeof $w.windowArray[i] != "undefined")
      if typeof $w.windowArray[i].window == "object" && $w.windowArray[i].window != null
       $w.windowArray[i].window.close() 
  $w.maxWindow = -1    
$w.handleChange = (e) ->
  jsx=$w.app
  $c.handleChange(jsx,e.target.name,e.target.value);
$w.handleClick = (e) ->
  jsx=$w.app
  name=e.target.name
  if name=="loginForm#CancelBtn"
    jsx.setState({
      loginForm_isShow:false
      loginForm:{
        loginId:""
        password:""
      }
    })
    return
  if name=="loginForm#LoginBtn"
    $w.flux.actions.loginClick(jsx.state.loginForm)
    return
  if name=="alert#CloseBtn"
    $w.flux.actions.$c_alertHide()
    return
  if name=="btnLogin"
    if jsx.state.page.logbtn == "LOGIN"
      jsx.setState({
        loginForm_isShow:true
      })
      return
    $w.windowClose()
    $w.flux.actions.logoffClick()
    return
  if jsx.state.page.name == "" 
    $w.flux.actions.$c_alertShow("Login していません")
    return
#これ以下はLOGIN状態のみ有効
  if name=="btnUser"
    $w.windowOpen("/user")
  if name=="btnUserin"
    $w.windowOpen("/userin")
  if name=="btnUsertab"
    $w.windowOpen("/usertab")
  if name=="btnUsertbl"
    $w.windowOpen("/usertbl")
  if name=="btnSystbl"
    $w.windowOpen("/systbl")
$w.handleLoginKeyPress = (e) ->
  jsx=$w.app
  key=e.key
  if e.key=="Enter"
    $w.flux.actions.loginClick(jsx.state.loginForm)
$w.constants =
  $W_LOGIN_SUCCESS: "$W_LOGIN_SUCCESS"
  $W_LOGOFF_SUCCESS: "$W_LOGOFF_SUCCESS" 
rules = []
rules.push("required,loginId,loginIdは必須項目です");  
rules.push("required,password,psswordは必須項目です");  
$w.actions = {
  loginClick:(loginForm) ->
    res = $v.validate(loginForm,rules)
    if res.length > 0
      this.dispatch($c.constants.$C_ALERT_SHOW,res)
      return
    this.dispatch($c.constants.$C_LOADING)
    $c.ajaxPostJson("/ajax/loginauth",loginForm,"application/json",
      $c.ajaxCallback.bind(this,loginForm,$w.constants.$W_LOGIN_SUCCESS))
  logoffClick: ->
    this.dispatch($c.constants.$C_LOADING)
    $c.ajaxPostJson("/ajax/logout","","application/json",
      $c.ajaxCallback.bind(this,"",$w.constants.$W_LOGOFF_SUCCESS))
} 

$w.PageStore = Fluxxor.createStore(
  initialize: ->
    @data = 
      {
        logbtn:"LOGIN"
        uid:""
        name:""
      }
    @bindActions $w.constants.$W_LOGIN_SUCCESS, @onLoginSuccess,
                  $w.constants.$W_LOGOFF_SUCCESS, @onLogoffSuccess
    return
  onLoginSuccess: (res) -> 
    @data.logbtn="LOGOFF"
    @data.uid=res.response.data.uid
    @data.name=res.response.data.name
    @emit "change"
    @emit "loginComplete"
    return
  onLogoffSuccess: (res) -> 
    @data.logbtn="LOGIN"
    @data.uid=""
    @data.name=""
    @emit "change"
    return
) 

$w.flux = new Fluxxor.Flux()
$w.pageStore=new $w.PageStore;
$w.flux.addStore("PAGE",$w.pageStore)
$w.flux.addActions($w.actions)
$w.commonStore=new $c.CommonStore;
$w.flux.addStore("COMMON",$w.commonStore)
$w.flux.addActions($c.actions)
$w.FluxMixin = Fluxxor.FluxMixin(React)
$w.StoreWatchMixin = Fluxxor.StoreWatchMixin
$w.pageStore.on("loginComplete", -> 
  $w.app.setState(
    {
      loginForm_isShow:false
      loginForm:{
        loginId:""
        password:"" 
      }
    }
  )
)
