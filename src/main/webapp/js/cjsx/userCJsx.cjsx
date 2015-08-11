wObj.LoginRows = React.createClass
	render: ->
		rows = this.props.rcds.map((rcd, i) ->
			bgcolor="";
			if (i==this.props.selRow)
				bgcolor="#d9edf7";
			else
				if (i%2 == 1)
					bgcolor="#F8F8F8";
				else
					bgcolor="#FFFFFF";
			<tr key={i} >
				<td id={"loginrow#loginId#"+i} style={{width:this.props.cw.c1,backgroundColor:bgcolor}}>{rcd.loginId}</td>
				<td id={"loginrow#name#"+i} style={{width:this.props.cw.c2,backgroundColor:bgcolor}}>{rcd.name}</td>
				<td id={"loginrow#role#"+i} style={{width:this.props.cw.c3,backgroundColor:bgcolor}}>{rcd.role}</td>
				<td id={"loginrow#lid#"+i} style={{width:this.props.cw.c4,backgroundColor:bgcolor,textAlign:"right"}}>{rcd.id}</td>
				<td id={"loginrow#versionNo#"+i} style={{width:this.props.cw.c5,backgroundColor:bgcolor,textAlign:"right"}}>{rcd.versionNo}</td>
			</tr>
		, this);
		<tbody style={{overflowY:"auto",height:92}}>
			{rows}
		</tbody>

wObj.Application = React.createClass
	mixins: [wObj.FluxMixin, wObj.StoreWatchMixin("COMMON","RCD")]
	getInitialState: ->
		wObj.application = this;
		blank={
			loginId:""
			name:""
			role:""
			id:""
			versionNo:""
			password:""
			passwordcfm:""
		};
		user:base.login.name
		search:{
			loginId:"starts with"
			loginId_s:""
			loginId_e:""
			name:"starts with"
			name_s:""
			name_e:""
		},
		login:{
			url:"/ajax/login"
			cw:{c1:100,c2:150,c3:60,c4:60,c5:60}
			rcds:[]
			blank:_.cloneDeep(blank)
			selRow:-1
		},
		form:_.cloneDeep(blank)

	getStateFromFlux: ->
		common:_.cloneDeep(wObj.common.data)
		rcd:_.cloneDeep(wObj.rcd.data)

	render: ->
		<div className="container-fixed" 
			style={{fontSize:12,border:1,borderStyle:"solid",width:800,height:600,backgroundColor: "#F0F0F0"}}>
			<ReactBootstrap.Row className="darkBgLarge" 
					style={{margin:0,height:40,lineHeight:"40px",verticalAlign: "middle"}}>
				<ReactBootstrap.Col xs={5} style={{textAlign: "center"}}>USER管理
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={5} className="darkBgMid" style={{textAlign: "center"}}>
				{this.state.user}
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1} className="darkBgMid" >
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1} >
				<base.Loader src="./img/ajax-loader.gif" isLoading={this.state.common.loading}/>
				</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<ReactBootstrap.Row style={{margin:5}}>
			<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={wObj.handleClick} 
				name="btnSearch" style={{width:60,marginLeft:10}}>検索</ReactBootstrap.Button>
			</ReactBootstrap.Row>
			<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
				<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>Login ID
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={2} >
					<base.SelectOption options={base.stringOption} style={{height:24,  fontSize:12}}
							name={"search#loginId"}
							defaultValue={this.state.search.loginId} onChange= {wObj.handleChange} />
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={3}>
					<ReactBootstrap.Input type="text" value={this.state.search.loginId_s} 
						name="search#loginId_s" onChange={wObj.handleChange} 
						style={{height:24,fontSize:12,width:"100%"}}/>
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={3}>
					<ReactBootstrap.Input type="text" value={this.state.search.loginId_e} 
						name="search#loginId_e" onChange={wObj.handleChange} 
						style={{height:24,fontSize:12,width:"100%"}}/>
					</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
				<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>氏名
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={2} >
					<base.SelectOption options={base.stringOption} 
							style={{height:24,  fontSize:12}} name={"search#name"}
							defaultValue={this.state.search.name} onChange={wObj.handleChange} />
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={3}>
					<ReactBootstrap.Input type="text" value={this.state.search.name_s}
						name="search#name_s" onChange={wObj.handleChange} 
						style={{height:24,fontSize:12,width:"100%"}}/>
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={3}>
					<ReactBootstrap.Input type="text" value={this.state.search.name_e} 
						name="search#name_e" onChange={wObj.handleChange} 
						style={{height:24,fontSize:12,width:"100%"}}/>
					</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<div style={{width:460,border:1,borderStyle:"solid", borderColor:"black",height:120,backgroundColor: "#FFFFFF"}}>
				<ReactBootstrap.Table bordered condensed className="wscrolltable" style={{width:"100%",height:"100%"}}
				onClick={wObj.handleClick}>
				<thead>
					<tr >
						<th　style={{width:this.state.login.cw.c1}}>Login Id</th>
						<th style={{width:this.state.login.cw.c2}}>氏名</th>
						<th style={{width:this.state.login.cw.c3}}>Role</th>
						<th　style={{width:this.state.login.cw.c4}}>id</th>
						<th style={{width:this.state.login.cw.c5}}>versionNo</th>
					</tr>
				</thead>
				<wObj.LoginRows rcds={this.state.login.rcds} cw={this.state.login.cw}
						selRow={this.state.login.selRow}/>
				</ReactBootstrap.Table>
			</div>
			<ReactBootstrap.Row style={{margin:5}}>
				<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={wObj.handleClick}
						name="btnNew" style={{width:60,marginLeft:10}}>新規</ReactBootstrap.Button>
				<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={wObj.handleClick} 
						name="btnUpdate" style={{width:60,marginLeft:10}}>更新</ReactBootstrap.Button>
				<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={wObj.handleClick} 
						name="btnDelete" style={{width:60,marginLeft:10}}>削除</ReactBootstrap.Button>

			</ReactBootstrap.Row>
			<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
				<ReactBootstrap.Col xs={2} style={{textAlign: "right"}}>Login ID
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={2}>
					<ReactBootstrap.Input type="text" value={this.state.form.loginId} 
						name="form#loginId" onChange={wObj.handleChange} 
						style={{height:24,fontSize:12,width:"100%"}}/> 
					</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
				<ReactBootstrap.Col xs={2} style={{textAlign: "right"}}>氏名
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={2}>
					<ReactBootstrap.Input type="text" value={this.state.form.name} 
						name="form#name" onChange={wObj.handleChange} 
						style={{height:24,fontSize:12,width:"100%"}}/>
					</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
				<ReactBootstrap.Col xs={2} style={{textAlign: "right"}}>Role
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={2}>
					<ReactBootstrap.Input type="text" value={this.state.form.role} 
						name="form#role" onChange={wObj.handleChange} 
						style={{height:24,fontSize:12,width:"100%"}}/>
					</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
				<ReactBootstrap.Col xs={2} style={{textAlign: "right"}}>パスワード
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={2}>
					<ReactBootstrap.Input type="password" value={this.state.form.password} 
						name="form#password" onChange={wObj.handleChange} 
						style={{height:24,fontSize:12,width:"100%"}}/>
					</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
				<ReactBootstrap.Col xs={2} style={{textAlign: "right"}}>パスワード(確認）
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={2}>
					<ReactBootstrap.Input type="password" value={this.state.form.passwordcfm} 
						name="form#passwordcfm" onChange={wObj.handleChange} 
						style={{height:24,fontSize:12,width:"100%"}}/>
					</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
				<ReactBootstrap.Col xs={2} style={{textAlign: "right"}}>id
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={1}>
					<ReactBootstrap.Input type="text" value={this.state.form.id} 
						name="form#id" onChange={wObj.handleChange} 
						disabled
						style={{height:24,fontSize:12,width:"100%"}}/>
					</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1} xsOffset={1} style={{textAlign: "right"}}>ver. No
					</ReactBootstrap.Col>
					<ReactBootstrap.Col xs={1}>
					<ReactBootstrap.Input type="text" value={this.state.form.versionNo} 
						name="form#versionNo" onChange={wObj.handleChange} 
						disabled
						style={{height:24,fontSize:12,width:"100%"}}/>
					</ReactBootstrap.Col>
			</ReactBootstrap.Row>
			<base.Alert isShow={this.state.common.alert.isShow} 
					message={this.state.common.alert.message} onClick={wObj.handleClick} />
			<base.DeleteConfirm isShow={this.state.common.deleteCfm.isShow}
					onClick={wObj.handleClick}/>
		</div>

	componentDidMount: ->

React.render <wObj.Application flux={wObj.flux}/>, document.getElementById('content');