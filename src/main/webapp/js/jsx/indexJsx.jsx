//var b = ReactBootstrap;


$w.LoginModal = React.createClass({
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
        <ReactBootstrap.Modal title="Login Form"  
          onRequestHide={this.props.onClick.bind(this,{target:{name:"loginForm#CancelBtn"}})} 
         className="form-login">
          <div className="modal-body">
            <ReactBootstrap.Row style={{height:26}}>
              <ReactBootstrap.Col xs={3} xsOffset={1}style={{textAlign: "right"}}>Login ID
              </ReactBootstrap.Col>
              <ReactBootstrap.Col xs={3}>
              <ReactBootstrap.Input type="text" value={this.props.loginId} onKeyPress={this.props.onKeyPress}
                name="loginForm#loginId" onChange={this.props.onChange} style={{height:24,fontSize:12,width:150}}/>
              </ReactBootstrap.Col>
            </ReactBootstrap.Row> 
            <ReactBootstrap.Row style={{height:26}}>
              <ReactBootstrap.Col xs={3} xsOffset={1}style={{textAlign: "right"}}>Password
              </ReactBootstrap.Col>
              <ReactBootstrap.Col xs={3}>
              <ReactBootstrap.Input type="password" value={this.props.password} onKeyPress={this.props.onKeyPress}
                name="loginForm#password" onChange={this.props.onChange} style={{height:24,fontSize:12,width:150}}/>
              </ReactBootstrap.Col>
            </ReactBootstrap.Row> 
          </div>
          <div className="modal-footer">
            <ReactBootstrap.Button onClick={this.props.onClick} name="loginForm#LoginBtn">Login</ReactBootstrap.Button>
            <ReactBootstrap.Button onClick={this.props.onClick} name="loginForm#CancelBtn">Cancel</ReactBootstrap.Button>
          </div>
        </ReactBootstrap.Modal>
      );
  }
});

$w.Application = React.createClass({
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
      <div className="container-fixed" style={{fontSize:12,border:1,borderStyle:"solid",width:800,height:600}}>

      <ReactBootstrap.Row className="darkBgLarge" style={{margin:0,height:40,lineHeight:"40px",verticalAlign: "middle"}}>
        <ReactBootstrap.Col xs={5} style={{textAlign: "center"}}>Test System
        </ReactBootstrap.Col>
        <ReactBootstrap.Col xs={5} className="darkBgMid" style={{textAlign: "center"}}>{this.state.page.name}
        </ReactBootstrap.Col>
        <ReactBootstrap.Col xs={1} className="darkBgMid" >
        <ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={$w.handleClick} name="btnLogin" style={{marginTop:5}}>
        {this.state.page.logbtn}</ReactBootstrap.Button>
        </ReactBootstrap.Col>
         <ReactBootstrap.Col xs={1} >
        <base.Loader src="./img/ajax-loader.gif" isLoading={this.state.common.loading}/>
        </ReactBootstrap.Col>
      </ReactBootstrap.Row>
      <ReactBootstrap.Row　style={{height:20}}>

      </ReactBootstrap.Row>
      <ReactBootstrap.Row>
        <ReactBootstrap.Col xs={1} xsOffset={1} >
        <ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={$w.handleClick} 
        	style={{width:btnWidth}} name="btnUser">
        USER管理</ReactBootstrap.Button>
        </ReactBootstrap.Col>  
      </ReactBootstrap.Row>
      <ReactBootstrap.Row>
        <ReactBootstrap.Col xs={1} xsOffset={1} >
        <ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={$w.handleClick} 
        	style={{width:btnWidth}} name="btnUserin">
        USER INLINE</ReactBootstrap.Button>
        </ReactBootstrap.Col>      
      </ReactBootstrap.Row>
      <ReactBootstrap.Row>
        <ReactBootstrap.Col xs={1} xsOffset={1} >
        <ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={$w.handleClick} 
        	style={{width:btnWidth}} name="btnUsertab">
        USERタブ</ReactBootstrap.Button>
        </ReactBootstrap.Col>      
      </ReactBootstrap.Row>
      <ReactBootstrap.Row>
        <ReactBootstrap.Col xs={1} xsOffset={1} >
        <ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={$w.handleClick} 
        	style={{width:btnWidth}} name="btnUsertbl">
        ユーザーテーブル</ReactBootstrap.Button>
        </ReactBootstrap.Col>      
      </ReactBootstrap.Row>
      <ReactBootstrap.Row>
        <ReactBootstrap.Col xs={1} xsOffset={1} >
        <ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={$w.handleClick} 
        	style={{width:btnWidth}} name="btnSystbl">
        システムテーブル</ReactBootstrap.Button>
        </ReactBootstrap.Col>      
      </ReactBootstrap.Row>
      <$w.LoginModal isShow={this.state.loginForm_isShow} loginId={this.state.loginForm.loginId}
       password={this.state.loginForm.password} 
        onClick={$w.handleClick} onChange={$w.handleChange} onKeyPress={$w.handleLoginKeyPress}/>
      <base.Alert isShow={this.state.common.alert.isShow} message={this.state.common.alert.message} onClick={$w.handleClick}
        />
      </div>
    );
  },
  componentDidMount: function() {
  }

});

React.render(<$w.Application flux={$w.flux}/>, document.getElementById('content'));