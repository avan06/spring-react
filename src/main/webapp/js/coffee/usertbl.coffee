base.checkAndCreate("$w")
 
$w.handleChange = (jsx,e) ->
  base.handleChange(jsx,e.target.name,e.target.value);

$w.handleClick = (jsx,e) ->
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
  if typeof(e.target.id)=="undefined"
    return
  ids = e.target.id.split("#");
  if (ids[0] == "row")
    temp={usertbl:jsx.state.usertbl}
    selRow = Number(ids[2])
    temp.usertbl.selRow=selRow
    temp.form=_.cloneDeep(temp.usertbl.rcds[selRow])
    temp.form.password=""
    temp.form.passwordcfm=""
    jsx.setState(temp)
$w.formSearch = (jsx) ->
  criteria=base.createCriteria(jsx.state.search,["tableName","key1"])
  $w.flux.actions.base_rcd_fetch(jsx.state.usertbl,jsx.state.form,"usertbl",criteria)
$w.formUpdate = (jsx) ->
  form = jsx.state.form
  res = ""
  if form.id==""
    rules = []

  if res.length > 0
    $w.flux.actions.base_alertShow(res)
    return
  $w.flux.actions.base_rcd_update(jsx.state.usertbl,jsx.state.form,"usertbl")
$w.formDelete = (jsx) ->
  if jsx.state.form.id == ""
    $w.flux.actions.base_rcd_delete_id_blank()
    return
  $w.flux.actions.base_deleteCfmShow()
$w.formDeleteCfm = (jsx) ->
  $w.flux.actions.base_rcd_delete(jsx.state.usertbl,jsx.state.form,"usertbl")
$w.formUpdateCheck = (form) ->
  if form.password>"" || form.passwordcfm>""
    if form.password != form.passwordcfm
      return [["", "パスワードとパスワード（確認）が一致しません"]]
  return ""
 
$w.formClear = (jsx) ->
  formtemp={
    form:_.cloneDeep(jsx.state.usertbl.blank)
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
rcdStore.addTable("usertbl")
$w.FluxMixin = Fluxxor.FluxMixin(React)
$w.StoreWatchMixin = Fluxxor.StoreWatchMixin
$w.fix = ->
  $('#tableusertbl').tablefix({width:900,height:300,fixRows:1})
$w.rcdStore.on("rcdComplete_usertbl", ->
  rcdTemp=_.cloneDeep($w.app.state.rcd.usertbl)
  temp={
    usertbl:$w.app.state.usertbl
  }
  temp.usertbl.rcds=rcdTemp.rcds
  temp.form=rcdTemp.rcd
  temp.usertbl.selRow=rcdTemp.selRow
  $w.app.setState(temp) 
)
$w.getDom = (refname) ->
  return $w.app.refs[refname].getDOMNode()
  
$w.scroll = ->
  $w.getDom("tableHead").scrollLeft=$w.getDom("tableBody").scrollLeft
$w.onscroll = ->
  $w.getDom("tableBody").onscroll=$w.scroll