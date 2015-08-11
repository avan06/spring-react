wObj.LoginRows = React.createClass({
		render: function() {
				wObj.loginRows = this;
				var rows = this.props.rcds.map(function(rcd, i){
				var bgcolor=""; 
				if (i==this.props.selRow) {
					bgcolor="#d9edf7";
					return (
						<tr key={i} draggable="true" onDragOver={this.props.onDragOver}
						onDragStart={this.props.onDragStart} onDrop={this.props.onDrop} 
						id={"row#"+i}>
					 
						<td style={{width:this.props.cw.c1,backgroundColor:bgcolor,padding:0,margin:0}}>
						 <ReactBootstrap.Input type="text" value={rcd.loginId}  name={"loginrow#loginId#"+i}
									ref={"loginrow#loginId#"+i} 
									onChange={this.props.onChange} onKeyDown={this.props.onKeyDown}
									style={{height:20,fontSize:12,width:"100%",padding:0,margin:0}}/>
						</td>
						<td style={{width:this.props.cw.c2,backgroundColor:bgcolor,padding:0,margin:0}}>
							<ReactBootstrap.Input type="text" value={rcd.name} name={"loginrow#name#"+i} 
									ref={"loginrow#name#"+i} 
									onChange={this.props.onChange} onKeyDown={this.props.onKeyDown}
									style={{height:20,fontSize:12,width:"100%",padding:0,margin:0}}/>
						</td>
						<td style={{width:this.props.cw.c3,backgroundColor:bgcolor,padding:0,margin:0}}>
							<ReactBootstrap.Input type="text" value={rcd.role} name={"loginrow#role#"+i} 
									ref={"loginrow#role#"+i} 
									onChange={this.props.onChange} onKeyDown={this.props.onKeyDown}
									style={{height:20,fontSize:12,width:"100%",padding:0,margin:0}}/>
						</td>
						<td id={"loginrow#lid#"+i} 
								style={{width:this.props.cw.c4,backgroundColor:bgcolor,
								textAlign:"right"}}>{rcd.id}</td>
						<td id={"loginrow#versionNo#"+i} 
								style={{width:this.props.cw.c5,backgroundColor:bgcolor,
								textAlign:"right"}}>{rcd.versionNo}</td>
					 </tr>
				)
					}
				else
					if (i%2 == 1)
						bgcolor="#F8F8F8";
					else
						bgcolor="#FFFFFF";
				return (
					<tr key={i} draggable="true" onDragOver={this.props.onDragOver}
						onDragStart={this.props.onDragStart} onDrop={this.props.onDrop}
						id={"row#"+i}>
					<td id={"loginrow#loginId#"+i} style={{width:this.props.cw.c1,backgroundColor:bgcolor}}>{rcd.loginId}</td>
					<td id={"loginrow#name#"+i} style={{width:this.props.cw.c2,backgroundColor:bgcolor}}>{rcd.name}</td>
					<td id={"loginrow#role#"+i} style={{width:this.props.cw.c3,backgroundColor:bgcolor}}>{rcd.role}</td>
					<td id={"loginrow#lid#"+i} style={{width:this.props.cw.c4,backgroundColor:bgcolor,textAlign:"right"}}>{rcd.id}</td>
					<td id={"loginrow#versionNo#"+i} style={{width:this.props.cw.c5,backgroundColor:bgcolor,textAlign:"right"}}>{rcd.versionNo}</td>
				 </tr>
				)
				}, this);
					return ( 
						<tbody style={{overflowY:"auto",height:92}}>
								{rows}
						</tbody>
					);
		}
	});
wObj.Application = React.createClass({
	mixins: [wObj.FluxMixin, wObj.StoreWatchMixin("PAGE","COMMON","RCD")],
	getInitialState: function() {
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
			return {
								user:base.login.name,
								search:{
									loginId:"starts with",
									loginId_s:"",
									loginId_e:"",
									name:"starts with",
									name_s:"",
									name_e:""
								},
								login:{
									url:"/ajax/login",
									cw:{c1:100,c2:150,c3:60,c4:60,c5:60},
									rcds:[],
									blank:_.cloneDeep(blank),
									selRow:-1
								},
								form:_.cloneDeep(blank)

							};
	},
	getStateFromFlux: function() {
		//this.props.flux=wObj.flux;
		var pageStore = wObj.flux.stores.PAGE;
		var commonStore = wObj.flux.stores.COMMON;
		var rcdStore = wObj.flux.stores.RCD;
		return {
			page: _.cloneDeep(pageStore.data),
			common:_.cloneDeep(commonStore.data),
			rcd:_.cloneDeep(rcdStore.data)
			};
	},
	render: function() {
		return (
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
							defaultValue={this.state.search.loginId} onChange={wObj.handleChange} />
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
			<ReactBootstrap.Row style={{margin:5}}>
				<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={wObj.handleClick} 
						name="btnUpdate" style={{width:60,marginLeft:10}}>更新</ReactBootstrap.Button>
				<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={wObj.handleClick} 
						name="btnDelete" style={{width:60,marginLeft:10}}>削除</ReactBootstrap.Button>
				<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={wObj.handleClick}
						name="btnCancel" style={{width:60,marginLeft:10}}>取消</ReactBootstrap.Button>
			</ReactBootstrap.Row>
			<div style={{width:460,border:1,borderStyle:"solid",
					borderColor:"black",height:120,backgroundColor: "#FFFFFF"}}>
			<ReactBootstrap.Table bordered condensed className="wscrolltable" 
					style={{width:"100%",height:"100%"}}
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
					selRow={this.state.login.selRow} onChange={wObj.handleChange}
					onKeyDown={wObj.handleRowKeyDown} onDragStart={this.dragStart}
					onDrop={this.drop} onDragOver={this.dragOver}/>
			</ReactBootstrap.Table>
			</div>

			<base.Alert isShow={this.state.common.alert.isShow} 
					message={this.state.common.alert.message} onClick={wObj.handleClick} />
			<base.DeleteConfirm isShow={this.state.common.deleteCfm.isShow}
					onClick={wObj.handleClick}/>
			</div>
		);
	},
	componentDidMount: function() {
	},
	dragStart:function (e) {
		e.dataTransfer.setData("text", e.target.id);
	},
	drop:function (e) {
		e.preventDefault();
		var from = e.dataTransfer.getData("text");
		var to=e.target.id;
		wObj.drop(this,from,to)
	},
	dragOver:function (e) {
		e.preventDefault()
	},
});

React.render(<wObj.Application flux={wObj.flux}/>, document.getElementById('content'));