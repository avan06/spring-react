var b = ReactBootstrap;

var Application = React.createClass({displayName: 'Application',
  mixins: [$w.FluxMixin, $w.StoreWatchMixin("RecordStore")],
  getInitialState: function() {
      return {input1:0, 
              input2:0,
              isModalOpen: false
              };
  },
  getStateFromFlux: function() {
  this.props.flux=$w.flux;
  var store = $w.flux.store("RecordStore");
  return {
    loading: store.loading,
    error: store.error,
    words:store.words
    };
  }

});