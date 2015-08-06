//var b = ReactBootstrap;

base.MulitLine = React.createClass({
  render: function () {
    var sarray = this.props.value.split("\n");
    var lines = sarray.map(function(line,i){
        if (i===0){
          return <span key={i}>{line}</span>;
        } else {
          return <span  key={i}><br/>{line}</span>;
        }
      },this);
    
    return (
        <div>
        {lines}
        </div>
      );
  }
});


base.Alert = React.createClass({
mixins: [ReactBootstrap.OverlayMixin],


render: function () {
  return (
    <span/>
  );
},
renderOverlay: function () {
  if (!this.props.isShow) {
    return <span/>;
  }

  return (
      <ReactBootstrap.Modal onRequestHide={function(){}} className="alert">
        <div className="modal-body"><base.MulitLine value={this.props.message} />
 
          </div>
          <div className="modal-footer">
          <ReactBootstrap.Button bsStyle="primary" onClick={this.props.onClick} name="alert#CloseBtn">了解</ReactBootstrap.Button>
          </div>
        </ReactBootstrap.Modal>
      );
  }
});  
base.DeleteConfirm = React.createClass({
mixins: [ReactBootstrap.OverlayMixin],
render: function () {
  return (
    <span/>
  );
},
renderOverlay: function () {
  if (!this.props.isShow) {
    return <span/>;
  }

  return (
      <ReactBootstrap.Modal onRequestHide={function(){}} className="deleteCfm">
        <div className="modal-body">削除してよいですね
           </div>
          <div className="modal-footer">
          <ReactBootstrap.Button bsStyle="primary" onClick={this.props.onClick} name="deleteCfm#YesBtn">YES</ReactBootstrap.Button>
          <ReactBootstrap.Button bsStyle="primary" onClick={this.props.onClick} name="deleteCfm#CloseBtn">NO</ReactBootstrap.Button>
          </div>
        </ReactBootstrap.Modal>
      );
  }
});
base.Loader = React.createClass({
  render: function () {
    if (this.props.isLoading==false){
      return <span/>;
    }
    else
    return (
         <img src={this.props.src} style={{margin:10}}/>
      )
  },
});
base.SelectOption = React.createClass({
    handleChange: function (e) {
        this.props.onChange(e);
      },
    render: function() {
         var options = this.props.options.map(function(opt, i){
          return <option key={i} value={opt.value} label={opt.label}>{opt.label}</option>;
        }, this);
          return ( 
            <ReactBootstrap.Input type="select" label='' 
                defaultValue={this.props.defaultValue} 
                multiple={this.props.multiple}
                name={this.props.name} style={this.props.style}
                onChange={this.handleChange}
                >
                {options}
            </ReactBootstrap.Input>
          );
    }
  });