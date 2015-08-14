base.checkAndCreate("wObj")
 
wObj.handleChange = (e) ->
	base.handleChange(wObj.application,e.target.name,e.target.value);

wObj.handleClick = (e) ->
	jsx=wObj.application
	name=e.target.name
	if name=="alert#CloseBtn"
		 wObj.flux.actions.base_alertHide()
	if name=="deleteCfm#CloseBtn"
		 wObj.flux.actions.base_deleteCfmHide()
	if name=="deleteCfm#YesBtn"
		 wObj.flux.actions.base_deleteCfmHide()
		 wObj.formDeleteCfm(jsx)
	if name == "btnNew"
		wObj.formClear(jsx)
	if name == "btnSearch"
		wObj.formSearch(jsx)
	if name == "btnUpdate"
		wObj.formUpdate(jsx)
	if name == "btnDelete"
		wObj.formDelete(jsx)
	if typeof(e.target.id)=="undefined"
		return
	ids = e.target.id.split("#");
	if (ids[0] == "loginrow")
		logintemp={login:jsx.state.login}
		selRow = Number(ids[2])
		logintemp.login.selRow=selRow
		logintemp.form=_.cloneDeep(logintemp.login.rcds[selRow])
		logintemp.form.password=""
		logintemp.form.passwordcfm=""
		jsx.setState(logintemp)
wObj.formSearch = (jsx) ->
	criteria=base.createCriteria(jsx.state.search,["loginId","name"])
	wObj.flux.actions.base_rcd_fetch(jsx.state.login,jsx.state.form,"login",criteria)
wObj.formUpdate = (jsx) ->
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
		rules.push("function,wObj.formUpdateCheck")
		res = rsv.validate(form,rules)
	if res.length > 0
		wObj.flux.actions.base_alertShow(res)
		return
	wObj.flux.actions.base_rcd_update(jsx.state.login,jsx.state.form,"login")
wObj.formDelete = (jsx) ->
	if jsx.state.form.id == ""
		wObj.flux.actions.base_rcd_delete_id_blank()
		return
	wObj.flux.actions.base_deleteCfmShow()
wObj.formDeleteCfm = (jsx) ->
	wObj.flux.actions.base_rcd_delete(jsx.state.login,jsx.state.form,"login")
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
wObj.constants =
	$W_LOGIN_SUCCESS: "$W_LOGIN_SUCCESS"



wObj.flux = new Fluxxor.Flux()
wObj.commonStore=new base.CommonStore;
wObj.flux.addStore("COMMON",wObj.commonStore)
wObj.flux.addActions(base.actions)
wObj.rcdStore=new base.RcdStore;
wObj.flux.addStore("RCD",wObj.rcdStore)
wObj.flux.addActions(base.rcdActions)
#rcdStore = wObj.flux.store("RCD")
#rcdStore.addTable("login")
wObj.FluxMixin = Fluxxor.FluxMixin(React)
wObj.StoreWatchMixin = Fluxxor.StoreWatchMixin
wObj.common=wObj.flux.stores.COMMON
wObj.rcd=wObj.flux.stores.RCD
wObj.rcd.addTable("login")
wObj.rcdStore.on("rcdComplete_login", ->
	rcdLogin=_.cloneDeep(wObj.application.state.rcd.login)
	loginTemp={
		login:wObj.application.state.login
	}
	loginTemp.login.rcds=rcdLogin.rcds
	loginTemp.form=rcdLogin.rcd
	loginTemp.login.selRow=rcdLogin.selRow
	wObj.application.setState(loginTemp) 
)

