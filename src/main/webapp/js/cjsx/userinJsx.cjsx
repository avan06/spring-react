wObj.LoginRows = React.createClass
	render: ->
		wObj.loginRows = this;
		rows = @props.rcds.map((rcd, i) ->
			bgcolor="";
			if (i == @props.selRow)
				bgcolor="#d9edf7";
				return (
					<tr key={i} draggable="true" onDragOver={@props.onDragOver}
					onDragStart={@props.onDragStart} onDrop={@props.onDrop}
					id={"row#"+i}>
						<td style={{width:@props.cw.c1,backgroundColor:bgcolor,padding:0,margin:0}}>
						<ReactBootstrap.Input type="text" value={rcd.loginId}  name={"loginrow#loginId#"+i}
									ref={"loginrow#loginId#"+i}
									onChange={@props.onChange} onKeyDown={@props.onKeyDown}
									style={{height:20,fontSize:12,width:"100%",padding:0,margin:0}}/>
						</td>
						<td style={{width:@props.cw.c2,backgroundColor:bgcolor,padding:0,margin:0}}>
							<ReactBootstrap.Input type="text" value={rcd.name} name={"loginrow#name#"+i}
									ref={"loginrow#name#"+i}
									onChange={@props.onChange} onKeyDown={@props.onKeyDown}
									style={{height:20,fontSize:12,width:"100%",padding:0,margin:0}}/>
						</td>
						<td style={{width:@props.cw.c3,backgroundColor:bgcolor,padding:0,margin:0}}>
							<ReactBootstrap.Input type="text" value={rcd.role} name={"loginrow#role#"+i}
									ref={"loginrow#role#"+i}
									onChange={@props.onChange} onKeyDown={@props.onKeyDown}
									style={{height:20,fontSize:12,width:"100%",padding:0,margin:0}}/>
						</td>
						<td id={"loginrow#lid#"+i}
							style={{width:@props.cw.c4,backgroundColor:bgcolor,
							textAlign:"right"}}>{rcd.id}</td>
						<td id={"loginrow#versionNo#"+i}
							style={{width:@props.cw.c5,backgroundColor:bgcolor,
							textAlign:"right"}}>{rcd.versionNo}</td>
					</tr>)
			else
				if (i%2 == 1)
					bgcolor="#F8F8F8";
				else
					bgcolor="#FFFFFF";

			<tr key={i} draggable="true" onDragOver={@props.onDragOver}
				onDragStart={@props.onDragStart} onDrop={@props.onDrop}
				id={"row#"+i}>
				<td id={"loginrow#loginId#"+i} style={{width:@props.cw.c1,backgroundColor:bgcolor}}>{rcd.loginId}</td>
				<td id={"loginrow#name#"+i} style={{width:@props.cw.c2,backgroundColor:bgcolor}}>{rcd.name}</td>
				<td id={"loginrow#role#"+i} style={{width:@props.cw.c3,backgroundColor:bgcolor}}>{rcd.role}</td>
				<td id={"loginrow#lid#"+i} style={{width:@props.cw.c4,backgroundColor:bgcolor,textAlign:"right"}}>{rcd.id}</td>
				<td id={"loginrow#versionNo#"+i} style={{width:@props.cw.c5,backgroundColor:bgcolor,textAlign:"right"}}>{rcd.versionNo}</td>
			</tr>
		, this);

		<tbody style={{overflowY:"auto",height:92}}>
			{rows}
		</tbody>

wObj.Application = React.createClass
	mixins: [wObj.FluxMixin, wObj.StoreWatchMixin("PAGE","COMMON","RCD")]
	getInitialState: ->
		wObj.application = this;
		blank={
			loginId:"",
			name:"",
			role:"",
			id:"",
			versionNo:"",
			password:"",
			passwordcfm:""
		};
		user:base.login.name
		search:{
			loginId:"starts with",
			loginId_s:"",
			loginId_e:"",
			name:"starts with",
			name_s:"",
			name_e:""
		}
		login:{
			url:"/ajax/login",
			cw:{c1:100,c2:150,c3:60,c4:60,c5:60},
			rcds:[],
			blank:_.cloneDeep(blank),
			selRow:-1
		}
		form:_.cloneDeep(blank)

	getStateFromFlux: ->
		### @props.flux=wObj.flux; ###
		pageStore = wObj.flux.stores.PAGE;
		commonStore = wObj.flux.stores.COMMON;
		rcdStore = wObj.flux.stores.RCD;

		page: _.cloneDeep(pageStore.data)
		common:_.cloneDeep(commonStore.data)
		rcd:_.cloneDeep(rcdStore.data)

	render: ->
		<div className="container-fixed"
				style={{fontSize:12,border:1,borderStyle:"solid",width:800,height:600,backgroundColor: "#F0F0F0"}}>

		<ReactBootstrap.Row className="darkBgLarge"
				style={{margin:0,height:40,lineHeight:"40px",verticalAlign: "middle"}}>
			<ReactBootstrap.Col xs={5} style={{textAlign: "center"}}>USER管理
			</ReactBootstrap.Col>
			<ReactBootstrap.Col xs={5} className="darkBgMid" style={{textAlign: "center"}}>
			{@state.user}
			</ReactBootstrap.Col>
			<ReactBootstrap.Col xs={1} className="darkBgMid" >
			</ReactBootstrap.Col>
			<ReactBootstrap.Col xs={1} >
			<base.Loader src="./img/ajax-loader.gif" isLoading={@state.common.loading}/>
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
						defaultValue={@state.search.loginId} onChange={wObj.handleChange} />
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.search.loginId_s}
					name="search#loginId_s" onChange={wObj.handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.search.loginId_e}
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
						defaultValue={@state.search.name} onChange={wObj.handleChange} />
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.search.name_s}
					name="search#name_s" onChange={wObj.handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.search.name_e}
					name="search#name_e" onChange={wObj.handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
		</ReactBootstrap.Row>
		<ReactBootstrap.Row style={{margin:5}}>
			<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={wObj.handleClick}
					name="btnUpdate" style={{width:60,marginLeft:10}}>更新</ReactBootstrap.Button>
			<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={wObj.handleClick}
					name="btnDelete" style={{width:60,marginLeft:10}}>削除</ReactBootstrap.Button>
			<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={wObj.handleClick}
					name="btnCancel" style={{width:60,marginLeft:10}}>取消</ReactBootstrap.Button>
		</ReactBootstrap.Row>
		<div style={{width:460,border:1,borderStyle:"solid", borderColor:"black",height:120,backgroundColor: "#FFFFFF"}}>
			<ReactBootstrap.Table bordered condensed className="wscrolltable" style={{width:"100%",height:"100%"}}
			onClick={wObj.handleClick}>
			<thead>
				<tr >
					<th　style={{width:@state.login.cw.c1}}>Login Id</th>
					<th style={{width:@state.login.cw.c2}}>氏名</th>
					<th style={{width:@state.login.cw.c3}}>Role</th>
					<th　style={{width:@state.login.cw.c4}}>id</th>
					<th style={{width:@state.login.cw.c5}}>versionNo</th>
				</tr>
			</thead>
			<wObj.LoginRows rcds={@state.login.rcds} cw={@state.login.cw}
					selRow={@state.login.selRow} onChange={wObj.handleChange}
					onKeyDown={wObj.handleRowKeyDown} onDragStart={@dragStart}
					onDrop={@drop} onDragOver={@dragOver}/>
			</ReactBootstrap.Table>
		</div>

		<base.Alert isShow={@state.common.alert.isShow}
				message={@state.common.alert.message} onClick={wObj.handleClick} />
		<base.DeleteConfirm isShow={@state.common.deleteCfm.isShow}
				onClick={wObj.handleClick}/>
		</div>

	componentDidMount: ->

	dragStart: (e) ->
		e.dataTransfer.setData("text", e.target.id);

	drop: (e) ->
		e.preventDefault();
		from = e.dataTransfer.getData("text");
		to=e.target.id;
		wObj.drop(this,from,to)

	dragOver: (e) ->
		e.preventDefault()


React.render <wObj.Application flux={wObj.flux}/>, document.getElementById('content');