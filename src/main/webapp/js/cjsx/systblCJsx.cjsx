wObj.width=900;
wObj.height=800;
wObj.tableHeight=340;
wObj.tableColW={c1:140,c2:130,c3:130,c4:150,c5:150,c6:150,c7:60,c8:60,c9:60,c10:60,c11:60}
wObj.systblRows = React.createClass
	render: ->
		rows = @props.rcds.map((rcd, i) ->
			bgcolor="";
			if (i==@props.selRow)
				bgcolor="#d9edf7";
			else
				if (i%2 == 1)
					bgcolor="#F8F8F8";
				else
					bgcolor="#FFFFFF";
			<tr key={i} >
				<td id={"row#tableName#"+i}
					style={{width:@props.cw.c1,backgroundColor:bgcolor}}>{rcd.tableName}</td>
				<td id={"row#key1#"+i}
					style={{width:@props.cw.c2,backgroundColor:bgcolor}}>{rcd.key1}</td>
				<td id={"row#key2#"+i}
					style={{width:@props.cw.c3,backgroundColor:bgcolor}}>{rcd.key2}</td>
				<td id={"row#s1Data#"+i}
				style={{width:@props.cw.c4,backgroundColor:bgcolor}}>{rcd.s1Data}</td>
				<td id={"row#s2Data#"+i}
				style={{width:@props.cw.c5,backgroundColor:bgcolor}}>{rcd.s2Data}</td>
				<td id={"row#s3Data#"+i}
				style={{width:@props.cw.c6,backgroundColor:bgcolor}}>{rcd.s3Data}</td>
				<td id={"row#n1Data#"+i}
				style={{width:@props.cw.c7,backgroundColor:bgcolor,textAlign:"right"}}>
					{rcd.n1Data}</td>
				<td id={"row#n2Data#"+i}
				style={{width:@props.cw.c8,backgroundColor:bgcolor,textAlign:"right"}}>
					{rcd.n2Data}</td>
				<td id={"row#n3Data#"+i}
				style={{width:@props.cw.c9,backgroundColor:bgcolor,textAlign:"right"}}>
					{rcd.n3Data}</td>
				<td id={"row#vid#"+i}
				style={{width:@props.cw.c10,backgroundColor:bgcolor,textAlign:"right"}}>
					{rcd.id}</td>
				<td id={"row#versionNo#"+i}
				style={{width:@props.cw.c11,backgroundColor:bgcolor,textAlign:"right"}}>
					{rcd.versionNo}</td>
			</tr>
		, this);
		<tbody>
			{rows}
		</tbody>

wObj.Application = React.createClass
	mixins: [wObj.FluxMixin, wObj.StoreWatchMixin("PAGE","COMMON","RCD")]
	getInitialState: ->
		wObj.application = @
		blank={
			tableName:"",
			key1:"",
			key2:"",
			s1Data:"",
			s2Data:"",
			s3Data:"",
			n1Data:"",
			n2Data:"",
			n3Data:"",
			id:"",
			versionNo:""
		};
		user:base.login.name
		search:{
			tableName:"starts with",
			tableName_s:"",
			tableName_e:"",
			key1:"starts with",
			key1_s:"",
			key1_e:"",
			maxRecord:"300"
		}
		systbl:{
			url:"/ajax/systbl",
			cw:wObj.tableColW,
			totalW:base.totalW(wObj.tableColW)+2,
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
		page: _.cloneDeep(pageStore.data),
		common:_.cloneDeep(commonStore.data),
		rcd:_.cloneDeep(rcdStore.data)

	render: ->
		<div className="container-fixed"
				style={{fontSize:12,border:1,borderStyle:"solid",
				width:wObj.width,height:wObj.height,backgroundColor: "#F0F0F0"}}>
		<ReactBootstrap.Row className="darkBgLarge"
				style={{margin:0,height:40,lineHeight:"40px",verticalAlign: "middle"}}>
			<ReactBootstrap.Col xs={5} style={{textAlign: "center"}}>システムテーブル管理
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
		<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={@handleClick}
				name="btnSearch" style={{width:60,marginLeft:10}}>検索</ReactBootstrap.Button>
		</ReactBootstrap.Row>
		<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
			<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>tableName
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={2} >
				<base.SelectOption options={base.stringOption} style={{height:24,  fontSize:12}}
						name={"search#tableName"}
						defaultValue={@state.search.tableName} onChange={@handleChange} />
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.search.tableName_s}
					name="search#tableName_s" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.search.tableName_e}
					name="search#tableName_e" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>MaxRecord
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1} >
					<ReactBootstrap.Input type="text" value={@state.search.maxRecord}
					name="search#names" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
		</ReactBootstrap.Row>
		<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
			<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>key1
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={2} >
				<base.SelectOption options={base.stringOption}
						style={{height:24,  fontSize:12}} name={"search#key1"}
						defaultValue={@state.search.key1} onChange={@handleChange} />
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.search.key1_s}
					name="search#key1_s" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.search.key1_e}
					name="search#key1_e" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
		</ReactBootstrap.Row>
		<div style={{width:wObj.width-2,border:1,borderStyle:"solid",
		borderColor:"black",height:wObj.tableHeight,backgroundColor: "#FFFFFF"}}>
		<div ref="tableHead"
				style={{width:wObj.width-20,height:20,overflowX:"hidden",overflowY:"hidden"}}>
		<ReactBootstrap.Table bordered condensed className="wscrolltable" >
		<thead style={{width:@state.systbl.totalW,overflowX:"hidden",overflowY:"hidden"}}>
			<tr >
				<th　style={{width:@state.systbl.cw.c1}}>tableName</th>
				<th style={{width:@state.systbl.cw.c2}}>key1</th>
				<th　style={{width:@state.systbl.cw.c3}}>key2</th>
				<th style={{width:@state.systbl.cw.c4}}>s1Data</th>
				<th style={{width:@state.systbl.cw.c5}}>s2Data</th>
				<th style={{width:@state.systbl.cw.c6}}>s3Data</th>
				<th style={{width:@state.systbl.cw.c7}}>n1Data</th>
				<th style={{width:@state.systbl.cw.c8}}>n2Data</th>
				<th style={{width:@state.systbl.cw.c9}}>n3Data</th>
				<th　style={{width:@state.systbl.cw.c10}}>id</th>
				<th style={{width:@state.systbl.cw.c11}}>versionNo</th>
			</tr>
		</thead>
		</ReactBootstrap.Table>
		</div>
		<div ref="tableBody"
			style={{width:wObj.width-4,height:wObj.tableHeight-22,overflowX:"scroll",overflowY:"scroll"}}>
		<div style={{width:@state.systbl.totalW,overflowX:"hidden",overflowY:"hidden"}}>
		<ReactBootstrap.Table bordered condensed className="wscrolltable"
		onClick={@handleClick}>
		<wObj.systblRows rcds={@state.systbl.rcds} cw={@state.systbl.cw}
				selRow={@state.systbl.selRow}/>
		</ReactBootstrap.Table>
		</div>
		</div>
		</div>
		<ReactBootstrap.Row style={{margin:5}}>
			<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={@handleClick}
					name="btnNew" style={{width:60,marginLeft:10}}>新規</ReactBootstrap.Button>
			<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={@handleClick}
					name="btnUpdate" style={{width:60,marginLeft:10}}>更新</ReactBootstrap.Button>
			<ReactBootstrap.Button bsSize="xsmall" bsStyle="primary" onClick={@handleClick}
					name="btnDelete" style={{width:60,marginLeft:10}}>削除</ReactBootstrap.Button>

		</ReactBootstrap.Row>
		<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0,marginRight:5}}>
			<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>tableName
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.form.tableName}
					name="form#tableName" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>key1
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.form.key1}
					name="form#key1" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>key2
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.form.key2}
					name="form#key2" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
		</ReactBootstrap.Row>
		<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0,marginRight:5}}>
			<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>s1Data
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.form.s1Data}
					name="form#s1Data" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>s2Data
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.form.s2Data}
					name="form#s2Data" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>s3Data
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.form.s3Data}
					name="form#s3Data" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
		</ReactBootstrap.Row>
		<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0,marginRight:5}}>
			<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>n1Data
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.form.n1Data}
					name="form#n1Data" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>n2Data
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.form.n2Data}
					name="form#n2Data" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>n3Data
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={3}>
				<ReactBootstrap.Input type="text" value={@state.form.n3Data}
					name="form#n3Data" onChange={@handleChange}
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
		</ReactBootstrap.Row>
		<ReactBootstrap.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0,marginRight:5}}>
			<ReactBootstrap.Col xs={1} style={{textAlign: "right"}}>id
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1}>
				<ReactBootstrap.Input type="text" value={@state.form.id}
					name="form#id" onChange={@handleChange}
					disabled
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
			<ReactBootstrap.Col xs={1} xsOffset={2} style={{textAlign: "right"}}>ver. No
				</ReactBootstrap.Col>
				<ReactBootstrap.Col xs={1}>
				<ReactBootstrap.Input type="text" value={@state.form.versionNo}
					name="form#versionNo" onChange={@handleChange}
					disabled
					style={{height:24,fontSize:12,width:"100%"}}/>
				</ReactBootstrap.Col>
		</ReactBootstrap.Row>
		<base.Alert isShow={@state.common.alert.isShow}
				message={@state.common.alert.message} onClick={@handleClick} />
		<base.DeleteConfirm isShow={@state.common.deleteCfm.isShow}
				onClick={@handleClick}/>
		</div>

	componentDidMount: ->
		wObj.onscroll();

	handleChange: (e) ->
		wObj.handleChange(this, e);

	handleClick: (e) ->
		wObj.handleClick(this, e);

React.render <wObj.Application flux={wObj.flux}/>, document.getElementById('content');