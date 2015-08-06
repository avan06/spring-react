//var b = ReactBootstrap;


$w.LoginModal = React.createClass({displayName: "LoginModal",
  mixins: [ReactBootstrap.OverlayMixin],
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
        React.createElement(ReactBootstrap.Modal, {title: "Login Form", 
          onRequestHide: this.props.onClick.bind(this,{target:{name:"loginForm#CancelBtn"}}), 
         className: "form-login"}, 
          React.createElement("div", {className: "modal-body"}, 
            React.createElement(ReactBootstrap.Row, {style: {height:26}}, 
              React.createElement(ReactBootstrap.Col, {xs: 3, xsOffset: 1, style: {textAlign: "right"}}, "Login ID"
              ), 
              React.createElement(ReactBootstrap.Col, {xs: 3}, 
              React.createElement(ReactBootstrap.Input, {type: "text", value: this.props.loginId, onKeyPress: this.props.onKeyPress, 
                name: "loginForm#loginId", onChange: this.props.onChange, style: {height:24,fontSize:12,width:150}})
              )
            ), 
            React.createElement(ReactBootstrap.Row, {style: {height:26}}, 
              React.createElement(ReactBootstrap.Col, {xs: 3, xsOffset: 1, style: {textAlign: "right"}}, "Password"
              ), 
              React.createElement(ReactBootstrap.Col, {xs: 3}, 
              React.createElement(ReactBootstrap.Input, {type: "password", value: this.props.password, onKeyPress: this.props.onKeyPress, 
                name: "loginForm#password", onChange: this.props.onChange, style: {height:24,fontSize:12,width:150}})
              )
            )
          ), 
          React.createElement("div", {className: "modal-footer"}, 
            React.createElement(ReactBootstrap.Button, {onClick: this.props.onClick, name: "loginForm#LoginBtn"}, "Login"), 
            React.createElement(ReactBootstrap.Button, {onClick: this.props.onClick, name: "loginForm#CancelBtn"}, "Cancel")
          )
        )
      );
  }
});

$w.Application = React.createClass({displayName: "Application",
  mixins: [$w.FluxMixin, $w.StoreWatchMixin("PAGE","COMMON")],
  getInitialState: function() {
  $w.app = this
      return {
                loginForm:
                  {
                    loginId:"",
                    password:""
                  } , 
                loginForm_isShow:false,
              };
  },
  getStateFromFlux: function() {
    //this.props.flux=$w.flux;
    var pageStore = $w.flux.store("PAGE");
    var commonStore = $w.flux.store("COMMON");
    return {
      page: _.cloneDeep(pageStore.data),
      common:_.cloneDeep(commonStore.data)
      };
  },
  render: function() {
    var btnWidth=120;
    return (
      React.createElement("div", {className: "container-fixed", style: {fontSize:12,border:1,borderStyle:"solid",width:800,height:600}}, 

      React.createElement(ReactBootstrap.Row, {className: "darkBgLarge", style: {margin:0,height:40,lineHeight:"40px",verticalAlign: "middle"}}, 
        React.createElement(ReactBootstrap.Col, {xs: 5, style: {textAlign: "center"}}, "Test System"
        ), 
        React.createElement(ReactBootstrap.Col, {xs: 5, className: "darkBgMid", style: {textAlign: "center"}}, this.state.page.name
        ), 
        React.createElement(ReactBootstrap.Col, {xs: 1, className: "darkBgMid"}, 
        React.createElement(ReactBootstrap.Button, {bsSize: "small", bsStyle: "primary", onClick: $w.handleClick, name: "btnLogin", style: {marginTop:5}}, 
        this.state.page.logbtn)
        ), 
         React.createElement(ReactBootstrap.Col, {xs: 1}, 
        React.createElement(base.Loader, {src: "./img/ajax-loader.gif", isLoading: this.state.common.loading})
        )
      ), 
      React.createElement(ReactBootstrap.Row, {　style: {height:20}}

      ), 
      React.createElement(ReactBootstrap.Row, null, 
        React.createElement(ReactBootstrap.Col, {xs: 1, xsOffset: 1}, 
        React.createElement(ReactBootstrap.Button, {bsSize: "small", bsStyle: "primary", onClick: $w.handleClick, 
        	style: {width:btnWidth}, name: "btnUser"}, 
        "USER管理")
        )
      ), 
      React.createElement(ReactBootstrap.Row, null, 
        React.createElement(ReactBootstrap.Col, {xs: 1, xsOffset: 1}, 
        React.createElement(ReactBootstrap.Button, {bsSize: "small", bsStyle: "primary", onClick: $w.handleClick, 
        	style: {width:btnWidth}, name: "btnUserin"}, 
        "USER INLINE")
        )
      ), 
      React.createElement(ReactBootstrap.Row, null, 
        React.createElement(ReactBootstrap.Col, {xs: 1, xsOffset: 1}, 
        React.createElement(ReactBootstrap.Button, {bsSize: "small", bsStyle: "primary", onClick: $w.handleClick, 
        	style: {width:btnWidth}, name: "btnUsertab"}, 
        "USERタブ")
        )
      ), 
      React.createElement(ReactBootstrap.Row, null, 
        React.createElement(ReactBootstrap.Col, {xs: 1, xsOffset: 1}, 
        React.createElement(ReactBootstrap.Button, {bsSize: "small", bsStyle: "primary", onClick: $w.handleClick, 
        	style: {width:btnWidth}, name: "btnUsertbl"}, 
        "ユーザーテーブル")
        )
      ), 
      React.createElement(ReactBootstrap.Row, null, 
        React.createElement(ReactBootstrap.Col, {xs: 1, xsOffset: 1}, 
        React.createElement(ReactBootstrap.Button, {bsSize: "small", bsStyle: "primary", onClick: $w.handleClick, 
        	style: {width:btnWidth}, name: "btnSystbl"}, 
        "システムテーブル")
        )
      ), 
      React.createElement($w.LoginModal, {isShow: this.state.loginForm_isShow, loginId: this.state.loginForm.loginId, 
       password: this.state.loginForm.password, 
        onClick: $w.handleClick, onChange: $w.handleChange, onKeyPress: $w.handleLoginKeyPress}), 
      React.createElement(base.Alert, {isShow: this.state.common.alert.isShow, message: this.state.common.alert.message, onClick: $w.handleClick}
        )
      )
    );
  },
  componentDidMount: function() {
  }

});

React.render(React.createElement($w.Application, {flux: $w.flux}), document.getElementById('content'));