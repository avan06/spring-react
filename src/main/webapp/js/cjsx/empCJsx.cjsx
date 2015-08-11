optionv =  [
			{
				value: "optionOne",
				label: "Option One"
			},
			{
				value: "optionsTwo",
				label: "Option Two",
				selected: true,
			}
		];

SelectOption = React.createClass
	handleChange: (e) ->
			@prop.onChange(e);

	render: ->
			options = @props.options.map((opt, i) ->
				if (opt.selected == true || opt.selected == 'selected')
					if (@props.multiple)
						if (defaultValue == undefined)
							defaultValue = [];
						defaultValue.push( opt.value );
					else
						defaultValue = opt.value;

				return <option key={i} value={opt.value} label={opt.label}>{opt.label}</option>;
			, this);

			<ReactBootstrap.Input type="select" label=''
					defaultValue={defaultValue}
					multiple={@props.multiple}
					name={@props.name} style={@props.style}
					onSelect={@handleChange}
					>
					{options}
			</ReactBootstrap.Input>

Application = React.createClass
	mixins: [wObj.FluxMixin, wObj.StoreWatchMixin("RecordStore")]
	getInitialState: ->
		{input1:0, input2:0, isModalOpen: false}

	getStateFromFlux: ->
		@props.flux=wObj.flux;
		store = wObj.flux.store "RecordStore";
		{
			loading: store.loading,
			error: store.error,
			words:store.words
		};

	render: ->
		total = Number(@state.input1) + Number(@state.input2);
		name1 = "input1";
		sieze1 = 2;

		<div className="container-fixed" style={{fontSize:12}}>
		<p style={{marginLeft:30}}>{total}</p>
		<ReactBootstrap.Row style={{margin:2}}>

				<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={@handleClick} name="btnSearch">検索</ReactBootstrap.Button>

				<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={@handleClick} name="btnSearch2">TEST</ReactBootstrap.Button>

				<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={@handleClick} name="btnSearch">検索</ReactBootstrap.Button>

				<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={@handleClick} name="btnSearch2">検索</ReactBootstrap.Button>

		</ReactBootstrap.Row>
		<form className="form-horizontal" style={{margin:2}}>
			<ReactBootstrap.Row style={{margin:2}}>
				<ReactBootstrap.Col xs={1} style={{textAlign: "right",lineHeight:"20px",verticalAlign:"middle"}} >
					TEST
				</ReactBootstrap.Col>  
				<ReactBootstrap.Col xs={sieze1}>
					<ReactBootstrap.Input type="text" value={@state[name1]} 
						name={name1} onChange={@handleChange} style={{height:20,fontSize:12}}/>
				</ReactBootstrap.Col> 
			</ReactBootstrap.Row>   
			<ReactBootstrap.Row   style={{margin:2}}>
				<ReactBootstrap.Col xs={1} style={{textAlign: "right",lineHeight:"20px",verticalAlign:"middle"}}>TEST
				</ReactBootstrap.Col>  
				<ReactBootstrap.Col xs={sieze1}>
					<ReactBootstrap.Input type="text" value={@state[name1]} 
						name={name1} onChange={@handleChange} style={{height:20,fontSize:12}}/>
				</ReactBootstrap.Col> 
			</ReactBootstrap.Row>  
		</form>
		<ReactBootstrap.Table condensed style={{width:"100%"}}>
			<tbody>
				<tr style={{height:22}}>
					<td  style={{width: 50,textAlign: "right",verticalAlign: "middle"}}>TEST</td>
					<td style={{width: 200}}>
						<SelectOption options={optionv} style={{height:24, fontSize:12}} name={"testname"}
						onChange={@handleChange} />
					</td>
					<td  style={{width: 550,textAlign: "left",verticalAlign: "middle"}}>TEST</td>
				</tr>
				<tr style={{height:22}}>
					<td  style={{width: 50,textAlign: "right",verticalAlign: "middle"}}>TEST</td>
					<td style={{width: 200}}>
							<ReactBootstrap.Input type="select" label='' style={{height:24}}>
								<option value=""></option>
								<option value="V1">Value 1</option>
								<option value="V2">Value 2</option>
							</ReactBootstrap.Input>
					
					</td>

				</tr>		
			</tbody>
		</ReactBootstrap.Table>
		<ReactBootstrap.Row>
			<ReactBootstrap.Col xs={sieze1}>
				<ReactBootstrap.Input type="text" value={@state[name1]} 
					name={name1} onChange={@handleChange} />
			</ ReactBootstrap.Col>
		</ReactBootstrap.Row>
		<ReactBootstrap.Row>
			<ReactBootstrap.Col xs={sieze1}>
				<ReactBootstrap.Input type="text" value={@state.input2} 
					 name="input2" onChange={@handleChange} />
			</ ReactBootstrap.Col>
			 </ReactBootstrap.Row>
		</div>

	componentDidMount: ->
		wObj.flux.actions.loadBuzz();

	handleChange: (e) ->
		wObj.handleChange(this,e);

	handleClick: (e) ->
		wObj.handleClick(this,e);

React.render <Application />, document.getElementById('content');
