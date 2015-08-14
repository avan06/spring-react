base.checkAndCreate("wObj")
wObj.windowArray = []
wObj.maxWindow = -1

wObj.windowOpen = (jspath) ->
	w = window.open(base_contextpath + jspath, '_blank',"");
	window.focus();
	wObj.maxWindow = wObj.maxWindow + 1
	wObj.windowArray[wObj.maxWindow] = w

wObj.windowClose  = ->
	for i in [0..wObj.maxWindow]
		if (typeof wObj.windowArray[i] != "undefined")
			if typeof wObj.windowArray[i].window == "object" && wObj.windowArray[i].window != null
			 wObj.windowArray[i].window.close()
	wObj.maxWindow = -1

wObj.handleChange = (e) ->
	jsx=wObj.application
	base.handleChange(jsx,e.target.name,e.target.value);

wObj.handleClick = (e) ->
	jsx=wObj.application
	name=e.target.name
	if name=="loginForm#CancelBtn"
		jsx.setState
			loginForm_isShow:false
			loginForm:
				loginId:""
				password:""
		return
	if name=="loginForm#LoginBtn"
		wObj.flux.actions.loginClick(jsx.state.loginForm)
		return
	if name=="alert#CloseBtn"
		wObj.flux.actions.base_alertHide()
		return
	if name=="btnLogin"
		if jsx.state.page.logbtn == "LOGIN"
			jsx.setState
				loginForm_isShow:true
			return
		wObj.windowClose()
		wObj.flux.actions.logoffClick()
		return
	if jsx.state.page.name == ""
		wObj.flux.actions.base_alertShow("Login していません")
		return
#これ以下はLOGIN状態のみ有効
	if name=="btnUser"
		wObj.windowOpen("/user")
	if name=="btnUserin"
		wObj.windowOpen("/userin")
	if name=="btnUsertab"
		wObj.windowOpen("/usertab")
	if name=="btnUsertbl"
		wObj.windowOpen("/usertbl")
	if name=="btnSystbl"
		wObj.windowOpen("/systbl")

wObj.handleLoginKeyPress = (e) ->
	jsx=wObj.application
	key=e.key
	if e.key=="Enter"
		wObj.flux.actions.loginClick(jsx.state.loginForm)

wObj.constants =
	WObj_LOGIN_SUCCESS: "WObj_LOGIN_SUCCESS"
	WObj_LOGOFF_SUCCESS: "WObj_LOGOFF_SUCCESS"

rules = []
rules.push("required,loginId,loginIdは必須項目です");
rules.push("required,password,psswordは必須項目です");

wObj.actions =
	loginClick:(loginForm) ->
		res = rsv.validate(loginForm,rules)
		if res.toString().length > 0
			this.dispatch(base.constants.base_ALERT_SHOW, res.toString())
			return
		this.dispatch(base.constants.base_LOADING)
		base.ajaxPostJson("/ajax/loginauth", loginForm, "application/json",
			base.ajaxCallback.bind(this, loginForm, wObj.constants.WObj_LOGIN_SUCCESS))
	logoffClick: ->
		this.dispatch(base.constants.base_LOADING)
		base.ajaxPostJson("/ajax/logout", "", "application/json",
			base.ajaxCallback.bind(this, "", wObj.constants.WObj_LOGOFF_SUCCESS))

wObj.PageStore = Fluxxor.createStore
	initialize: ->
		@data =
			logbtn:"LOGIN"
			uid:""
			name:""
		@bindActions wObj.constants.WObj_LOGIN_SUCCESS, @onLoginSuccess,
					wObj.constants.WObj_LOGOFF_SUCCESS, @onLogoffSuccess
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

wObj.flux = new Fluxxor.Flux()
wObj.pageStore = new wObj.PageStore;
wObj.flux.addStore("PAGE", wObj.pageStore)
wObj.flux.addActions(wObj.actions)

wObj.commonStore = new base.CommonStore;
wObj.flux.addStore("COMMON",wObj.commonStore)
wObj.flux.addActions(base.actions)

wObj.FluxMixin = Fluxxor.FluxMixin(React)
wObj.StoreWatchMixin = Fluxxor.StoreWatchMixin
wObj.pageStore.on "loginComplete", ->
	wObj.application.setState
		loginForm_isShow:false
		loginForm:
			loginId:""
			password:""
