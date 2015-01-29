var b = ReactBootstrap;
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
      React.createElement(b.Modal, {onRequestHide: function(){}}, 
        React.createElement("div", {className: "modal-body"}, React.createElement(b.Input, {type: "textarea", readOnly: true, className: "alert-message", value: this.props.message})
 
          ), 
          React.createElement("div", {className: "modal-footer"}, 
          React.createElement(b.Button, {onClick: this.props.onClick, name: "loginForm#CloseBtn"}, "了解")
          )
        )
      );
  }
});  