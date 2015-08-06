checkAndCreate = (v)->
  window[v] = {} if not window[v]?  

checkAndCreate("base")
base.checkAndCreate = checkAndCreate
base.handleChange = (jsx,name,value) ->
  change = {}
  names = name.split("#")
  if names.length == 1
    change[name] = value
  if names.length == 2
    temp = jsx.state[names[0]]
    temp[names[1]]=value
    change[names[0]]=temp
  jsx.setState(change)

base.constants =
  base_ALERT_SHOW: "base_ALERT_SHOW"
  base_ALERT_HIDE: "base_ALERT_HIDE"
  base_DELETE_CFM_SHOW: "base_DELETE_CFM_SHOW"
  base_DELETE_CFM_HIDE: "base_DELETE_CFM_HIDE"
  base_LOADING: "base_LOADING"
  base_LOADED: "base_LOADED"
base.actions =
  base_alertShow:(message) ->
    this.dispatch(base.constants.base_ALERT_SHOW,message)
  base_alertHide:() ->
    this.dispatch(base.constants.base_ALERT_HIDE)
  base_deleteCfmShow:() ->
    this.dispatch(base.constants.base_DELETE_CFM_SHOW)
  base_deleteCfmHide:() ->
    this.dispatch(base.constants.base_DELETE_CFM_HIDE)
LoginClient =
  login:(logbtn_value,success,failure) ->
    $.post
base.CommonStore = Fluxxor.createStore(
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
    @bindActions base.constants.base_ALERT_SHOW, @onAlertShow, 
                 base.constants.base_ALERT_HIDE, @onAlertHide, 
                 base.constants.base_DELETE_CFM_SHOW, @onDeleteCfmShow, 
                 base.constants.base_DELETE_CFM_HIDE, @onDeleteCfmHide,
                 base.constants.base_LOADING, @onLoading, 
                 base.constants.base_LOADED, @onLoaded, 
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
base.ajaxPost = (url,data,contentype,callback) ->
  $.ajax(
    {
      type: "POST",
      url: base_contextpath+url
      data: data,
      contentType: contentype
    }
  ).always(callback)
base.ajaxPostJson = (url,param,contentype,callback) ->
  data=JSON.stringify(param)
  base.ajaxPost(url,data,contentype,callback) 
base.getXhr = (response, payload) ->
  if typeof(payload)=="string"
    return response
  return payload
base.getServerError = (xhr) ->
    if xhr.status==200
      return ""
    if  xhr.status==0
      return "Internet or Server error"
    return "Server error status="+xhr.status+" "+xhr.statusText
base.getResponse = (xhr) ->
    if typeof(xhr.responseJSON)=="object"
      return xhr.responseJSON.response
    res=$.parseJSON(xhr.responseText)
    return res.response
base.getAppError = (xhr) ->
  response=base.getResponse(xhr)
  if response?
    if response.status < 0
      return response.data
  return ""
base.getServerOrAppError = (xhr) ->
  error = base.getServerError (xhr)
  if error > ""
    return error
  return base.getAppError(xhr)
base.ajaxCallback= (context,successDispatch,ajaxresponse, textStatus, payload) ->
  this.dispatch(base.constants.base_LOADED)
  xhr= base.getXhr(ajaxresponse, payload)
  error = base.getServerOrAppError(xhr)
  if error > ""
    this.dispatch(base.constants.base_ALERT_SHOW,error)
    return
  response=base.getResponse(xhr)
  res={
    context:context
    response:response
  }
  this.dispatch(successDispatch,res)
base.createCriteria = (form,fields) ->
  criteria= [] 
  for field in fields
    criteria.push
        fieldName: field
        operator:form[field]
        start: form[field+"_s"]
        end:form[field+"_e"] 
  return criteria 
base.rcdConstants =
  base_RCD_FETCH_SUCCESS: "base_RCD_FETCH_SUCCESS"
  base_RCD_ADD_SUCCESS: "base_RCD_ADD_SUCCESS"
  base_RCD_UPDATE_SUCCESS: "base_RCD_UPDATE_SUCCESS"
  base_RCD_DELETE_SUCCESS: "base_RCD_DELETE_SUCCESS"
  base_RCD_TRANSACTIONS_SUCCESS: "base_RCD_TRANSACTIONS_SUCCESS"
base.rcdActions = {
  base_rcd_fetch: (rcdData,form,table,criteria)->
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
    this.dispatch(base.constants.base_LOADING)
    base.ajaxPostJson(rcdData.url ,params,"application/json",
      base.ajaxCallback.bind(this,context,base.rcdConstants.base_RCD_FETCH_SUCCESS))
  base_rcd_update: (rcdData,form,table)->
    if form.id==""
      dispachAction = base.rcdConstants.base_RCD_ADD_SUCCESS
      operationType= "add"
    else
      dispachAction = base.rcdConstants.base_RCD_UPDATE_SUCCESS
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
    this.dispatch(base.constants.base_LOADING)
    base.ajaxPostJson(rcdData.url ,params,"application/json",
      base.ajaxCallback.bind(this,context,dispachAction))
  base_rcd_delete: (rcdData,form,table)->
    params = {
      operationType: "remove"
      data:form.id
    }
    context={
      rcdData:rcdData
      table:table
      action:"remove"
    }
    this.dispatch(base.constants.base_LOADING)
    base.ajaxPostJson(rcdData.url ,params,"application/json",
      base.ajaxCallback.bind(this,context,base.rcdConstants.base_RCD_DELETE_SUCCESS))
  base_rcd_delete_id_blank: ->
    this.dispatch(base.constants.base_ALERT_SHOW,"レコードが選択されていません")
  base_rcd_transaction: (rcdData,params,table)->
    context={
      rcdData:rcdData
      table:table
      action:"remove"
    }
    this.dispatch(base.constants.base_LOADING)
    base.ajaxPostJson(rcdData.url ,params,"application/json",
      base.ajaxCallback.bind(this,context,base.rcdConstants.base_RCD_TRANSACTIONS_SUCCESS))
} 

base.RcdStore = Fluxxor.createStore(
  initialize: ->
    @data = 
      {
      }
    @bindActions base.rcdConstants.base_RCD_FETCH_SUCCESS, @onRcdFetchSuccess,
      base.rcdConstants.base_RCD_ADD_SUCCESS, @onRcdAddSuccess,
      base.rcdConstants.base_RCD_UPDATE_SUCCESS, @onRcdUpdateSuccess,
      base.rcdConstants.base_RCD_DELETE_SUCCESS, @onRcdDeleteSuccess,
      base.rcdConstants.base_RCD_TRANSACTIONS_SUCCESS, @onRcdTransactionsSuccess,
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
      old=base.getRecordNoById(@data[table].rcds,id)
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
base.isNull = (value) ->
  if typeof value == "undefined" || value == null
    return true
  if value.length == 0
    return true 
base.dirtyCheck = (record, oldRecord) ->
  dirty = false
  for prop of record
    if base.isNull(oldRecord[prop])
      if !base.isNull(record[prop])
        dirty = true
    else
      if (record[prop] != oldRecord[prop])
        dirty = true
  return dirty 
base.getRecordById = (records, id) ->
  for rcd in records
    if rcd.id == id
      return rcd
  return null
base.getRecordNoById = (records, id) ->
  for rcd,i in records
    if rcd.id == id
      return i
  return -1 
base.totalW= (cw)->
  length = 0
  for v of cw
    length = length + cw[v]
  return length
base.stringOption=[
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
base.numberOption=[
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
base.timestampOption=[
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