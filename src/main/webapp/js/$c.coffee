checkAndCreate = (v)->
  window[v] = {} if not window[v]?  

checkAndCreate("$c")
$c.checkAndCreate = checkAndCreate
$c.handleChange = (jsx,name,value) ->
  change = {}
  names = name.split("#")
  if names.length == 1
    change[name] = value
  if names.length == 2
    temp = jsx.state[names[0]]
    temp[names[1]]=value
    change[names[0]]=temp
  jsx.setState(change)

$c.constants =
  $C_ALERT_SHOW: "$C_ALERT_SHOW"
  $C_ALERT_HIDE: "$C_ALERT_HIDE"
  $C_DELETE_CFM_SHOW: "$C_DELETE_CFM_SHOW"
  $C_DELETE_CFM_HIDE: "$C_DELETE_CFM_HIDE"
  $C_LOADING: "$C_LOADING"
  $C_LOADED: "$C_LOADED"
$c.actions =
  $c_alertShow:(message) ->
    this.dispatch($c.constants.$C_ALERT_SHOW,message)
  $c_alertHide:() ->
    this.dispatch($c.constants.$C_ALERT_HIDE)
  $c_deleteCfmShow:() ->
    this.dispatch($c.constants.$C_DELETE_CFM_SHOW)
  $c_deleteCfmHide:() ->
    this.dispatch($c.constants.$C_DELETE_CFM_HIDE)
LoginClient =
  login:(logbtn_value,success,failure) ->
    $.post
$c.CommonStore = Fluxxor.createStore(
  initialize: ->
    @data =
      {
        alert:
          {
            message:""
            isShow:false
          }
        deleteCfm:
          {
            isShow:false
          }
        loading:false
      }
    @bindActions $c.constants.$C_ALERT_SHOW, @onAlertShow, 
                 $c.constants.$C_ALERT_HIDE, @onAlertHide, 
                 $c.constants.$C_DELETE_CFM_SHOW, @onDeleteCfmShow, 
                 $c.constants.$C_DELETE_CFM_HIDE, @onDeleteCfmHide,
                 $c.constants.$C_LOADING, @onLoading, 
                 $c.constants.$C_LOADED, @onLoaded, 
    return
  onAlertShow: (message)->
    @data.alert.message = message
    @data.alert.isShow = true
    @emit "change"
    return
  onAlertHide: () ->
    @data.alert.isShow = false
    @emit "change"
    return
  onDeleteCfmShow: ()->
    @data.deleteCfm.isShow = true
    @emit "change"
    return
  onDeleteCfmHide: () ->
    @data.deleteCfm.isShow = false
    @emit "change"
    return
  onLoading: ->
    @data.loading = true
    @emit "change"
    return
  onLoaded: ->
    @data.loading = false
    @emit "change"
    return
)
$c.ajaxPost = (url,data,contentype,callback) ->
  $.ajax(
    {
      type: "POST",
      url: $c_contextpath+url
      data: data,
      contentType: contentype
    }
  ).always(callback)
$c.ajaxPostJson = (url,param,contentype,callback) ->
  data=JSON.stringify(param)
  $c.ajaxPost(url,data,contentype,callback) 
$c.getXhr = (response, payload) ->
  if typeof(payload)=="string"
    return response
  return payload
$c.getServerError = (xhr) ->
    if xhr.status==200
      return ""
    if  xhr.status==0
      return "Internet or Server error"
    return "Server error status="+xhr.status+" "+xhr.statusText
$c.getResponse = (xhr) ->
    if typeof(xhr.responseJSON)=="object"
      return xhr.responseJSON.response
    res=$.parseJSON(xhr.responseText)
    return res.response
$c.getAppError = (xhr) ->
  response=$c.getResponse(xhr)
  if response?
    if response.status < 0
      return response.data
  return ""
$c.getServerOrAppError = (xhr) ->
  error = $c.getServerError (xhr)
  if error > ""
    return error
  return $c.getAppError(xhr)
$c.ajaxCallback= (context,successDispatch,ajaxresponse, textStatus, payload) ->
  this.dispatch($c.constants.$C_LOADED)
  xhr= $c.getXhr(ajaxresponse, payload)
  error = $c.getServerOrAppError(xhr)
  if error > ""
    this.dispatch($c.constants.$C_ALERT_SHOW,error)
    return
  response=$c.getResponse(xhr)
  res={
    context:context
    response:response
  }
  this.dispatch(successDispatch,res)
$c.createCriteria = (form,fields) ->
  criteria= [] 
  for field in fields
    criteria.push
        fieldName: field
        operator:form[field]
        start: form[field+"_s"]
        end:form[field+"_e"] 
  return criteria 
$c.rcdConstants =
  $C_RCD_FETCH_SUCCESS: "$C_RCD_FETCH_SUCCESS"
  $C_RCD_ADD_SUCCESS: "$C_RCD_ADD_SUCCESS"
  $C_RCD_UPDATE_SUCCESS: "$C_RCD_UPDATE_SUCCESS"
  $C_RCD_DELETE_SUCCESS: "$C_RCD_DELETE_SUCCESS"
  $C_RCD_TRANSACTIONS_SUCCESS: "$C_RCD_TRANSACTIONS_SUCCESS"
$c.rcdActions = {
  $c_rcd_fetch: (rcdData,form,table,criteria)->
    params = {
      operationType: "fetch"
      data:{
        criteria:criteria
      }
    }
    context={
      rcdData:rcdData
      table:table
      action:"fetch"
    }
    this.dispatch($c.constants.$C_LOADING)
    $c.ajaxPostJson(rcdData.url ,params,"application/json",
      $c.ajaxCallback.bind(this,context,$c.rcdConstants.$C_RCD_FETCH_SUCCESS))
  $c_rcd_update: (rcdData,form,table)->
    if form.id==""
      dispachAction = $c.rcdConstants.$C_RCD_ADD_SUCCESS
      operationType= "add"
    else
      dispachAction = $c.rcdConstants.$C_RCD_UPDATE_SUCCESS
      operationType= "update"
    params = {
      operationType: operationType
      data:form
    }
    context={
      rcdData:rcdData
      table:table
      action:"update"
    }
    this.dispatch($c.constants.$C_LOADING)
    $c.ajaxPostJson(rcdData.url ,params,"application/json",
      $c.ajaxCallback.bind(this,context,dispachAction))
  $c_rcd_delete: (rcdData,form,table)->
    params = {
      operationType: "remove"
      data:form.id
    }
    context={
      rcdData:rcdData
      table:table
      action:"remove"
    }
    this.dispatch($c.constants.$C_LOADING)
    $c.ajaxPostJson(rcdData.url ,params,"application/json",
      $c.ajaxCallback.bind(this,context,$c.rcdConstants.$C_RCD_DELETE_SUCCESS))
  $c_rcd_delete_id_blank: ->
    this.dispatch($c.constants.$C_ALERT_SHOW,"レコードが選択されていません")
  $c_rcd_transaction: (rcdData,params,table)->
    context={
      rcdData:rcdData
      table:table
      action:"remove"
    }
    this.dispatch($c.constants.$C_LOADING)
    $c.ajaxPostJson(rcdData.url ,params,"application/json",
      $c.ajaxCallback.bind(this,context,$c.rcdConstants.$C_RCD_TRANSACTIONS_SUCCESS))
} 

$c.RcdStore = Fluxxor.createStore(
  initialize: ->
    @data = 
      {
      }
    @bindActions $c.rcdConstants.$C_RCD_FETCH_SUCCESS, @onRcdFetchSuccess,
      $c.rcdConstants.$C_RCD_ADD_SUCCESS, @onRcdAddSuccess,
      $c.rcdConstants.$C_RCD_UPDATE_SUCCESS, @onRcdUpdateSuccess,
      $c.rcdConstants.$C_RCD_DELETE_SUCCESS, @onRcdDeleteSuccess,
      $c.rcdConstants.$C_RCD_TRANSACTIONS_SUCCESS, @onRcdTransactionsSuccess,
    return
  onRcdFetchSuccess: (res) ->
    context=res.context
    response=res.response
    table=context.table
    rcdData=context.rcdData
    @data[table].rcds=response.data
    @data[table].rcd=rcdData.blank
    @data[table].selRow=-1
    @emit "change"
    @emit "rcdComplete_"+table
    return
  onRcdAddSuccess: (res) ->
    context=res.context
    response=res.response
    table=context.table
    rcdData=context.rcdData
    @data[table].rcds=_.cloneDeep(rcdData.rcds)
    @data[table].rcd=response.data
    @data[table].selRow=@data[table].rcds.length
    @data[table].rcds.push(response.data)
    @emit "change"
    @emit "rcdComplete_"+table
    return
  onRcdUpdateSuccess: (res) ->
    context=res.context
    response=res.response
    table=context.table
    rcdData=context.rcdData
    @data[table].rcds=_.cloneDeep(rcdData.rcds)
    @data[table].selRow=rcdData.selRow
    @data[table].rcd=response.data
    for rcd,i in @data[table].rcds
      if Number(rcd.id) == Number(response.data.id)
        @data[table].rcds[i] = response.data
    @emit "change"
    @emit "rcdComplete_"+table
    return
  onRcdDeleteSuccess: (res) ->
    context=res.context
    response=res.response
    table=context.table
    rcdData=context.rcdData
    @data[table].rcds=_.cloneDeep(rcdData.rcds)
    newData = []
    for rcd,i in @data[table].rcds
      if Number(rcd.id) != Number(response.data.id)
        newData.push(rcd)
    @data[table].rcds=newData
    @data[table].rcd=rcdData.blank
    @data[table].selRow=-1
    @emit "change"
    @emit "rcdComplete_"+table
    return
  onRcdTransactionsSuccess: (res) ->
    context=res.context
    response=res.response
    table=context.table
    rcdData=context.rcdData
    @data[table].rcds=_.cloneDeep(rcdData.rcds)
    _.remove(@data[table].rcds, (rcd) ->
      rcd.id == ""
    )
    for rcd,i in response.data
      newrcd=rcd.response.data
      id = newrcd.id
      old=$c.getRecordNoById(@data[table].rcds,id)
      if old == -1
        @data[table].rcds.push(newrcd)
      else
        @data[table].rcds[old]=newrcd
    @data[table].rcd=rcdData.blank
    @data[table].selRow=-1
    @emit "change"
    @emit "rcdComplete_"+table
    return
  addTable: (table) ->
    template={
      rcds:[]
      rcd:{}
      selRow:-1
    }
    @data[table]=template
) 
$c.isNull = (value) ->
  if typeof value == "undefined" || value == null
    return true
  if value.length == 0
    return true 
$c.dirtyCheck = (record, oldRecord) ->
  dirty = false
  for prop of record
    if $c.isNull(oldRecord[prop])
      if !$c.isNull(record[prop])
        dirty = true
    else
      if (record[prop] != oldRecord[prop])
        dirty = true
  return dirty 
$c.getRecordById = (records, id) ->
  for rcd in records
    if rcd.id == id
      return rcd
  return null
$c.getRecordNoById = (records, id) ->
  for rcd,i in records
    if rcd.id == id
      return i
  return -1 
$c.totalW= (cw)->
  length = 0
  for v of cw
    length = length + cw[v]
  return length
$c.stringOption=[
  {
    value: ""
    label: ""
  },
  {
    value: "="
    label: "="
  },
  {
    value: "between"
    label: "間"
  },
  {
    value: "starts with"
    label: "先頭"
  },
  {
    value: "contains"
    label: "含む"
  },
  {
    value: ">"
    label: ">"
  },
  {
    value: ">="
    label: ">="
  },
  {
    value: "<"
    label: "<"
  },
  {
    value: "<="
    label: "<="
  },
  {
    value: "<>"
    label: "<>"
  },
  {
    value: "like"
    label: "%?指定"
  },
]
$c.numberOption=[
  {
    value: ""
    label: ""
  },
  {
    value: "="
    label: "="
  },
  {
    value: "between"
    label: "間"
  },
  {
    value: ">"
    label: ">"
  },
  {
    value: ">="
    label: ">="
  },
  {
    value: "<"
    label: "<"
  },
  {
    value: "<="
    label: "<="
  },
  {
    value: "<>"
    label: "<>"
  },
]
$c.timestampOption=[
  {
    value: ""
    label: ""
  },
  {
    value: "="
    label: "="
  },
  {
    value: "between"
    label: "間"
  },
  {
    value: ">"
    label: ">"
  },
  {
    value: ">="
    label: ">="
  },
  {
    value: "<"
    label: "<"
  },
  {
    value: "<="
    label: "<="
  },
]