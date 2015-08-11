base.checkAndCreate("wObj")
  
wObj.handleChannge = (jsx,e) ->
  change = {}
  change[e.target.name] = e.target.value
  jsx.setState(change)
wObj.handleClick = (jsx,e) ->
  name=e.target.name
  if name=="btnSearch"
    wObj.flux.actions.loadBuzz();
    
wObj.constants =
  LOAD_BUZZ: "LOAD_BUZZ"
  LOAD_BUZZ_SUCCESS: "LOAD_BUZZ_SUCCESS"
  LOAD_BUZZ_FAIL: "LOAD_BUZZ_FAIL"
  ADD_BUZZ: "ADD_BUZZ"
  ADD_BUZZ_SUCCESS: "ADD_BUZZ_SUCCESS"
  ADD_BUZZ_FAIL: "ADD_BUZZ_FAIL"
  
wObj.actions =
  loadBuzz: ->
    this.dispatch(wObj.constants.LOAD_BUZZ)
    BuzzwordClient.load ((words) ->
      this.dispatch(wObj.constants.LOAD_BUZZ_SUCCESS,
        words: words
      )
      return
    ).bind(this), ((error) ->
      this.dispatch(wObj.constants.LOAD_BUZZ_FAIL,
        error: error
      )
      return
    ).bind(this)
    return
BuzzwordClient =
  load: (success, failure) ->
    setTimeout (->
      success(["AA",""])
      return
    ), 1000
    return

  submit: (word, success, failure) ->
    setTimeout (->
      if Math.random() > 0.5
        success word
      else
        failure "Failed to " 
      return
    ), Math.random() * 1000 + 500
    return    
wObj.RecordStore = Fluxxor.createStore(
  initialize: ->
    @loading = false
    @error = null
    @words = {}
    @bindActions wObj.constants.LOAD_BUZZ, @onLoadBuzz, 
                 wObj.constants.LOAD_BUZZ_SUCCESS, @onLoadBuzzSuccess, 
                 wObj.constants.LOAD_BUZZ_FAIL, @onLoadBuzzFail

    return

  onLoadBuzz: ->
    @loading = true
    @emit "change"
    return

  onLoadBuzzSuccess: (payload) ->
    @loading = false
    @words=payload.words
    @emit "change"
    return

  onLoadBuzzFail: (payload) ->
    @loading = false
    @error = payload.error
    @emit "change"
    return

)

wObj.stores = RecordStore: new wObj.RecordStore()
wObj.flux = new Fluxxor.Flux()
wObj.flux.addStores(wObj.stores)
wObj.flux.addActions(wObj.actions)
wObj.flux.on "dispatch", (type, payload) ->
  console.log "[Dispatch]", type, payload  if console and console.log
  return

wObj.FluxMixin = Fluxxor.FluxMixin(React)
wObj.StoreWatchMixin = Fluxxor.StoreWatchMixin