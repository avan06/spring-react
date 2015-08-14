base.checkAndCreate("wObj")
 
wObj.handleChange = (jsx,e) ->
	base.handleChange(jsx,e.target.name,e.target.value);

wObj.handleClick = (jsx,e) ->
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
	if (ids[0] == "row")
		temp={systbl:jsx.state.systbl}
		selRow = Number(ids[2])
		temp.systbl.selRow=selRow
		temp.form=_.cloneDeep(temp.systbl.rcds[selRow])
		temp.form.password=""
		temp.form.passwordcfm=""
		jsx.setState(temp)
wObj.formSearch = (jsx) ->
	criteria=base.createCriteria(jsx.state.search,["tableName","key1"])
	wObj.flux.actions.base_rcd_fetch(jsx.state.systbl,jsx.state.form,"systbl",criteria)
wObj.formUpdate = (jsx) ->
	form = jsx.state.form
	res = ""
	if form.id==""
		rules = []

	if res.length > 0
		wObj.flux.actions.base_alertShow(res)
		return
	wObj.flux.actions.base_rcd_update(jsx.state.systbl,jsx.state.form,"systbl")
wObj.formDelete = (jsx) ->
	if jsx.state.form.id == ""
		wObj.flux.actions.base_rcd_delete_id_blank()
		return
	wObj.flux.actions.base_deleteCfmShow()
wObj.formDeleteCfm = (jsx) ->
	wObj.flux.actions.base_rcd_delete(jsx.state.systbl,jsx.state.form,"systbl")
wObj.formUpdateCheck = (form) ->
	if form.password>"" || form.passwordcfm>""
		if form.password != form.passwordcfm
			return [["", "パスワードとパスワード（確認）が一致しません"]]
	return ""
 
wObj.formClear = (jsx) ->
	formtemp={
		form:_.cloneDeep(jsx.state.systbl.blank)
	}
	jsx.setState(formtemp)
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
rcdStore.addTable("systbl")
wObj.FluxMixin = Fluxxor.FluxMixin(React)
wObj.StoreWatchMixin = Fluxxor.StoreWatchMixin
wObj.fix = ->
	$('#tablesystbl').tablefix({width:900,height:300,fixRows:1})
wObj.rcdStore.on("rcdComplete_systbl", ->
	rcdTemp=_.cloneDeep(wObj.application.state.rcd.systbl)
	temp={
		systbl:wObj.application.state.systbl
	}
	temp.systbl.rcds=rcdTemp.rcds
	temp.form=rcdTemp.rcd
	temp.systbl.selRow=rcdTemp.selRow
	wObj.application.setState(temp) 
)
wObj.getDom = (refname) ->
	return wObj.application.refs[refname].getDOMNode()
	
wObj.scroll = ->
	wObj.getDom("tableHead").scrollLeft=wObj.getDom("tableBody").scrollLeft
wObj.onscroll = ->
	wObj.getDom("tableBody").onscroll=wObj.scroll