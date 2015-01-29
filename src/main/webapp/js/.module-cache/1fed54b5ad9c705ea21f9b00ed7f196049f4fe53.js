var b = ReactBootstrap;

var Application = React.createClass({displayName: 'Application',
  mixins: [$w.FluxMixin, $w.StoreWatchMixin(["PAGE","COMMON"])],
  getInitialState: function() {
      return {
      
              };
  },
  getStateFromFlux: function() {
    this.props.flux=$w.flux;
    var pageStore = $w.flux.store("PAGE");
    var commonStore = $w.flux.store("COMMON");
    return {
      page: pageStore.data,
      common:commonStore.data
      };
  },
  render: function() {
    return (
      React.createElement("div", {className: "container-fixed", style: {fontSize:12}}
      
      )
    );
  },
  componentDidMount: function() {
  
  },
  handleChange: function (e) {
    $w.handleChange(this,e);
  },
  handleClick: function (e) {
    $w.handleClick(this,e);
  }

});