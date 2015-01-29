$c.checkAndCreate("$w")
  
$w.handleChannge = (jsx,e) ->
  change = {}
  change[e.target.name] = e.target.value
  jsx.setState(change)
$w.handleClick = (jsx,e) ->
  name=e.target.name
  if name=="btnSearch"
    $w.flux.actions.loadBuzz();
    
$w.constants =
  LOAD_BUZZ: "LOAD_BUZZ"
  LOAD_BUZZ_SUCCESS: "LOAD_BUZZ_SUCCESS"
  LOAD_BUZZ_FAIL: "LOAD_BUZZ_FAIL"
  ADD_BUZZ: "ADD_BUZZ"
  ADD_BUZZ_SUCCESS: "ADD_BUZZ_SUCCESS"
  ADD_BUZZ_FAIL: "ADD_BUZZ_FAIL"
  
$w.actions =
  loadBuzz: ->
    this.dispatch($w.constants.LOAD_BUZZ)
    BuzzwordClient.load ((words) ->
      this.dispatch($w.constants.LOAD_BUZZ_SUCCESS,
        words: words
      )
      return
    ).bind(this), ((error) ->
      this.dispatch($w.constants.LOAD_BUZZ_FAIL,
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
$w.RecordStore = Fluxxor.createStore(
  initialize: ->
    @loading = false
    @error = null
    @words = {}
    @bindActions $w.constants.LOAD_BUZZ, @onLoadBuzz, 
                 $w.constants.LOAD_BUZZ_SUCCESS, @onLoadBuzzSuccess, 
                 $w.constants.LOAD_BUZZ_FAIL, @onLoadBuzzFail

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

$w.stores = RecordStore: new $w.RecordStore()
$w.flux = new Fluxxor.Flux()
$w.flux.addStores($w.stores)
$w.flux.addActions($w.actions)
$w.flux.on "dispatch", (type, payload) ->
  console.log "[Dispatch]", type, payload  if console and console.log
  return

$w.FluxMixin = Fluxxor.FluxMixin(React)
$w.StoreWatchMixin = Fluxxor.StoreWatchMixin