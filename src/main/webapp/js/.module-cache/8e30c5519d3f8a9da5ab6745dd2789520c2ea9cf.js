var b = ReactBootstrap;

$c.MulitLine = React.createClass({displayName: 'MulitLine',
  render: function () {
    var sarray = this.props.value.split("\n");
    var lines = sarray.map(function(line,i){
        if (i===0){
          return React.createElement("span", {key: i}, line);
        } else {
          return React.createElement("span", {key: i}, React.createElement("br", null), line);
        }
      },this);
    
    return (
        React.createElement("div", null, 
        lines
        )
      );
  }
});


$c.Alert = React.createClass({displayName: 'Alert',
mixins: [b.OverlayMixin],


render: function () {
  return (
    React.createElement("span", null)
  );
},
renderOverlay: function () {
  if (!this.props.isShow) {
    return React.createElement("span", null);
  }

  return (
      React.createElement(b.Modal, {onRequestHide: function(){}, className: "alert"}, 
        React.createElement("div", {className: "modal-body"}, React.createElement($c.MulitLine, {value: this.props.message})
 
          ), 
          React.createElement("div", {className: "modal-footer"}, 
          React.createElement(b.Button, {bsStyle: "primary", onClick: this.props.onClick, name: "alert#CloseBtn"}, "了解")
          )
        )
      );
  }
});  
$c.DeleteConfirm = React.createClass({displayName: 'DeleteConfirm',
mixins: [b.OverlayMixin],
render: function () {
  return (
    React.createElement("span", null)
  );
},
renderOverlay: function () {
  if (!this.props.isShow) {
    return React.createElement("span", null);
  }

  return (
      React.createElement(b.Modal, {onRequestHide: function(){}, className: "deleteCfm"}, 
        React.createElement("div", {className: "modal-body"}, "削除してよいですね"
           ), 
          React.createElement("div", {className: "modal-footer"}, 
          React.createElement(b.Button, {bsStyle: "primary", onClick: this.props.onClick, name: "deleteCfm#YesBtn"}, "YES"), 
          React.createElement(b.Button, {bsStyle: "primary", onClick: this.props.onClick, name: "deleteCfm#CloseBtn"}, "NO")
          )
        )
      );
  }
});
$c.Loader = React.createClass({displayName: 'Loader',
  render: function () {
    if (this.props.isLoading==false){
      return React.createElement("span", null);
    }
    else
    return (
         React.createElement("img", {src: this.props.src, style: {margin:10}})
      )
  },
});
$c.SelectOption = React.createClass({displayName: 'SelectOption',
    handleChange: function (e) {
        this.props.onChange(e);
      },
    render: function() {
         var options = this.props.options.map(function(opt, i){
          return React.createElement("option", {key: i, value: opt.value, label: opt.label}, opt.label);
        }, this);
          return ( 
            React.createElement(b.Input, {type: "select", label: "", 
                defaultValue: this.props.defaultValue, 
                multiple: this.props.multiple, 
                name: this.props.name, style: this.props.style, 
                onChange: this.handleChange
                }, 
                options
            )
          );
    }
  });