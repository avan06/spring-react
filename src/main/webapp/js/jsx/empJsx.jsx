	var optionv =  [
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
				
	var SelectOption = React.createClass({
		handleChange: function (e) {
				this.prop.onChange(e);
			}
			,
		render: function() {
				var defaultValue; 
 
				var options = this.props.options.map(function(opt, i){
					if (opt.selected === true || opt.selected === 'selected') {
						if (this.props.multiple) {
							if (defaultValue === undefined) {
								defaultValue = [];
							}
							defaultValue.push( opt.value );
						} else {
							defaultValue = opt.value;
						}
					}
					return <option key={i} value={opt.value} label={opt.label}>{opt.label}</option>;
				}, this);

					return ( 
						<ReactBootstrap.Input type="select" label='' 
								defaultValue={defaultValue} 
								multiple={this.props.multiple}
								name={this.props.name} style={this.props.style}
								onSelect={this.handleChange}
								>
								{options}
						</ReactBootstrap.Input>
					);
		}
	});
	var Application = React.createClass({
		mixins: [wObj.FluxMixin, wObj.StoreWatchMixin("RecordStore")],
		getInitialState: function() {
				return {input1:0, 
								input2:0,
								isModalOpen: false
								};
		},
		getStateFromFlux: function() {
		this.props.flux=wObj.flux;
		var store = wObj.flux.store("RecordStore");
		return {
			loading: store.loading,
			error: store.error,
			words:store.words
		};
	},
		render: function() {
			var total = Number(this.state.input1) + Number(this.state.input2);
			var name1="input1";
			var sieze1 = 2;
			return (  
				
				<div className="container-fixed" style={{fontSize:12}}>
				<p style={{marginLeft:30}}>{total}</p>
				<ReactBootstrap.Row style={{margin:2}}>

						<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={this.handleClick} name="btnSearch">検索</ReactBootstrap.Button>

						<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={this.handleClick} name="btnSearch2">TEST</ReactBootstrap.Button>

						<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={this.handleClick} name="btnSearch">検索</ReactBootstrap.Button>

						<ReactBootstrap.Button bsSize="small" bsStyle="primary" onClick={this.handleClick} name="btnSearch2">検索</ReactBootstrap.Button>

				</ReactBootstrap.Row>
				<form className="form-horizontal" style={{margin:2}}>
					<ReactBootstrap.Row style={{margin:2}}>
						<ReactBootstrap.Col xs={1} style={{textAlign: "right",lineHeight:"20px",verticalAlign:"middle"}} >
							TEST
						</ReactBootstrap.Col>  
						<ReactBootstrap.Col xs={sieze1}>
							<ReactBootstrap.Input type="text" value={this.state[name1]} 
								name={name1} onChange={this.handleChange} style={{height:20,fontSize:12}}/>
						</ReactBootstrap.Col> 
					</ReactBootstrap.Row>   
					<ReactBootstrap.Row   style={{margin:2}}>
						<ReactBootstrap.Col xs={1} style={{textAlign: "right",lineHeight:"20px",verticalAlign:"middle"}}>TEST
						</ReactBootstrap.Col>  
						<ReactBootstrap.Col xs={sieze1}>
							<ReactBootstrap.Input type="text" value={this.state[name1]} 
								name={name1} onChange={this.handleChange} style={{height:20,fontSize:12}}/>
						</ReactBootstrap.Col> 
					</ReactBootstrap.Row>  
				</form>
				<ReactBootstrap.Table condensed style={{width:"100%"}}>
					<tbody>
						<tr style={{height:22}}>
							<td  style={{width: 50,textAlign: "right",verticalAlign: "middle"}}>TEST</td>
							<td style={{width: 200}}>
								<SelectOption options={optionv} style={{height:24, fontSize:12}} name={"testname"}
								onChange={this.handleChange} />
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
						<ReactBootstrap.Input type="text" value={this.state[name1]} 
							name={name1} onChange={this.handleChange} />
					</ ReactBootstrap.Col>
				</ReactBootstrap.Row>
				<ReactBootstrap.Row>
					<ReactBootstrap.Col xs={sieze1}>
						<ReactBootstrap.Input type="text" value={this.state.input2} 
							 name="input2" onChange={this.handleChange} />
					</ ReactBootstrap.Col>
					 </ReactBootstrap.Row>
				</div>
			 
			);
		},
		componentDidMount: function() {
		wObj.flux.actions.loadBuzz();
	},
		handleChange: function (e) {
			wObj.handleChange(this,e);
		},
		handleClick: function (e) {
			wObj.handleClick(this,e);
		}
	});

React.render(<Application />, document.getElementById('content'));
