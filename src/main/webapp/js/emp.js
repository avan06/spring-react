(function() {
  var BuzzwordClient;
  $c.checkAndCreate("$w");
  $w.handleChannge = function(jsx, e) {
    var change;
    change = {};
    change[e.target.name] = e.target.value;
    return jsx.setState(change);
  };
  $w.handleClick = function(jsx, e) {
    var name;
    name = e.target.name;
    if (name === "btnSearch") {
      return $w.flux.actions.loadBuzz();
    }
  };
  $w.constants = {
    LOAD_BUZZ: "LOAD_BUZZ",
    LOAD_BUZZ_SUCCESS: "LOAD_BUZZ_SUCCESS",
    LOAD_BUZZ_FAIL: "LOAD_BUZZ_FAIL",
    ADD_BUZZ: "ADD_BUZZ",
    ADD_BUZZ_SUCCESS: "ADD_BUZZ_SUCCESS",
    ADD_BUZZ_FAIL: "ADD_BUZZ_FAIL"
  };
  $w.actions = {
    loadBuzz: function() {
      this.dispatch($w.constants.LOAD_BUZZ);
      BuzzwordClient.load((function(words) {
        this.dispatch($w.constants.LOAD_BUZZ_SUCCESS, {
          words: words
        });
      }).bind(this), (function(error) {
        this.dispatch($w.constants.LOAD_BUZZ_FAIL, {
          error: error
        });
      }).bind(this));
    }
  };
  BuzzwordClient = {
    load: function(success, failure) {
      setTimeout((function() {
        success(["AA", ""]);
      }), 1000);
    },
    submit: function(word, success, failure) {
      setTimeout((function() {
        if (Math.random() > 0.5) {
          success(word);
        } else {
          failure("Failed to ");
        }
      }), Math.random() * 1000 + 500);
    }
  };
  $w.RecordStore = Fluxxor.createStore({
    initialize: function() {
      this.loading = false;
      this.error = null;
      this.words = {};
      this.bindActions($w.constants.LOAD_BUZZ, this.onLoadBuzz, $w.constants.LOAD_BUZZ_SUCCESS, this.onLoadBuzzSuccess, $w.constants.LOAD_BUZZ_FAIL, this.onLoadBuzzFail);
    },
    onLoadBuzz: function() {
      this.loading = true;
      this.emit("change");
    },
    onLoadBuzzSuccess: function(payload) {
      this.loading = false;
      this.words = payload.words;
      this.emit("change");
    },
    onLoadBuzzFail: function(payload) {
      this.loading = false;
      this.error = payload.error;
      this.emit("change");
    }
  });
  $w.stores = {
    RecordStore: new $w.RecordStore()
  };
  $w.flux = new Fluxxor.Flux();
  $w.flux.addStores($w.stores);
  $w.flux.addActions($w.actions);
  $w.flux.on("dispatch", function(type, payload) {
    if (console && console.log) {
      console.log("[Dispatch]", type, payload);
    }
  });
  $w.FluxMixin = Fluxxor.FluxMixin(React);
  $w.StoreWatchMixin = Fluxxor.StoreWatchMixin;
}).call(this);
