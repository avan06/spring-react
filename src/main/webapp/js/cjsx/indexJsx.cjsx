wObj.LoginModal = React.createClass
	render: ->
		<ReactBootstrap.Modal
			bsSize="small"
			aria-labelledby='loginModal'
			show={@props.isShow}
			onHide={@props.onClick.bind(this,{target:{name:"loginForm#CancelBtn"}})}
			dialogClassName="form-login">
			<ReactBootstrap.Modal.Header closeButton>
				<ReactBootstrap.Modal.Title id='loginModal'>Login Form</ReactBootstrap.Modal.Title>
			</ReactBootstrap.Modal.Header>
			<ReactBootstrap.Modal.Body>
				<ReactBootstrap.Row style={{height:26}}>
					<ReactBootstrap.Col xs={3} xsOffset={1} style={{textAlign: "right"}}>Login ID
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={3}>
					<ReactBootstrap.Input type="text" value={@props.loginId} onKeyPress={@props.onKeyPress}
						name="loginForm#loginId" onChange={@props.onChange} style={{height:24,fontSize:12,width:150}}/>
					</ReactBootstrap.Col>
				</ReactBootstrap.Row>
				<ReactBootstrap.Row style={{height:26}}>
					<ReactBootstrap.Col xs={3} xsOffset={1} style={{textAlign: "right"}}>Password
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={3}>
					<ReactBootstrap.Input type="password" value={@props.password} onKeyPress={@props.onKeyPress}
						name="loginForm#password" onChange={@props.onChange} style={{height:24,fontSize:12,width:150}}/>
					</ReactBootstrap.Col>
				</ReactBootstrap.Row>
			</ReactBootstrap.Modal.Body>
			<ReactBootstrap.Modal.Footer>
				<ReactBootstrap.Button onClick={@props.onClick} name="loginForm#LoginBtn">Login</ReactBootstrap.Button>
				<ReactBootstrap.Button onClick={@props.onClick} name="loginForm#CancelBtn">Cancel</ReactBootstrap.Button>
			</ReactBootstrap.Modal.Footer>
		</ReactBootstrap.Modal>

wObj.Application = React.createClass
	mixins: [wObj.FluxMixin, wObj.StoreWatchMixin("PAGE","COMMON")]
	getInitialState: ->
		wObj.application = this;
		loginForm:
			loginId:"",
			password:""
		loginForm_isShow:false;

	getStateFromFlux: ->
		### @props.flux=wObj.flux; ###
		pageStore = wObj.flux.store "PAGE";
		commonStore = wObj.flux.store "COMMON";
		page: _.cloneDeep(pageStore.data),
		common:_.cloneDeep(commonStore.data)

	render: ->
		btnWidth=120;

		<div className="container-fixed" style={fontSize:12,border:1,borderStyle:"solid",width:800,height:600}>

			<ReactBootstrap.Row className="darkBgLarge" style={{margin:0,height:40,lineHeight:"40px",verticalAlign: "middle"}}>
				<ReactBootstrap.Col xs={5} style={{textAlign: "center"}}>Test System
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={5} className="darkBgMid" style={{textAlign: "center"}}>{@state.page.name}
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1} className="darkBgMid" >
					<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={wObj.handleClick} name="btnLogin" 
						style={{marginTop:5}}>{@state.page.logbtn}</ReactBootstrap.Button>
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1} >
					<base.Loader src="./img/ajax-loader.gif" isLoading={@state.common.loading} />
				</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<ReactBootstrap.Row　style={{height:20}}>

			</ReactBootstrap.Row>
			<ReactBootstrap.Row>
				<ReactBootstrap.Col xs={1} xsOffset={1} >
					<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={wObj.handleClick}
						style={{width:btnWidth}} name="btnUser">USER管理</ReactBootstrap.Button>
				</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<ReactBootstrap.Row>
				<ReactBootstrap.Col xs={1} xsOffset={1} >
				<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={wObj.handleClick}
					style={{width:btnWidth}} name="btnUserin">USER INLINE</ReactBootstrap.Button>
				</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<ReactBootstrap.Row>
				<ReactBootstrap.Col xs={1} xsOffset={1} >
					<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={wObj.handleClick}
						style={{width:btnWidth}} name="btnUsertab">USERタブ</ReactBootstrap.Button>
				</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<ReactBootstrap.Row>
				<ReactBootstrap.Col xs={1} xsOffset={1} >
					<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={wObj.handleClick}
						style={{width:btnWidth}} name="btnUsertbl">ユーザーテーブル</ReactBootstrap.Button>
				</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<ReactBootstrap.Row>
				<ReactBootstrap.Col xs={1} xsOffset={1} >
					<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={wObj.handleClick}
						style={{width:btnWidth}} name="btnSystbl">システムテーブル</ReactBootstrap.Button>
				</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<wObj.LoginModal isShow={@state.loginForm_isShow} loginId={@state.loginForm.loginId}
				password={@state.loginForm.password}
				onClick={wObj.handleClick} onChange={wObj.handleChange} onKeyPress={wObj.handleLoginKeyPress}/>
			<base.Alert isShow={@state.common.alert.isShow} message={@state.common.alert.message} onClick={wObj.handleClick}
				/>
		</div>

	componentDidMount: ->

React.render <wObj.Application flux={wObj.flux}/>, document.getElementById('content');