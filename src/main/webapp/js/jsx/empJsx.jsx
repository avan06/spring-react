  var b = ReactBootstrap;
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
						<b.Input type="select" label='' 
						    defaultValue={defaultValue} 
        				multiple={this.props.multiple}
        				name={this.props.name} style={this.props.style}
        				onSelect={this.handleChange}
        				>
								{options}
						</b.Input>
					);
    }
  });
  var Application = React.createClass({
    mixins: [$w.FluxMixin, $w.StoreWatchMixin("RecordStore")],
    getInitialState: function() {
        return {input1:0, 
                input2:0,
                isModalOpen: false
                };
    },
    getStateFromFlux: function() {
    this.props.flux=$w.flux;
    var store = $w.flux.store("RecordStore");
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
		    <b.Row style={{margin:2}}>

            <b.Button bsSize="small" bsStyle="primary" onClick={this.handleClick} name="btnSearch">検索</b.Button>

            <b.Button bsSize="small" bsStyle="primary" onClick={this.handleClick} name="btnSearch2">TEST</b.Button>

            <b.Button bsSize="small" bsStyle="primary" onClick={this.handleClick} name="btnSearch">検索</b.Button>

            <b.Button bsSize="small" bsStyle="primary" onClick={this.handleClick} name="btnSearch2">検索</b.Button>

        </b.Row>
        <form className="form-horizontal" style={{margin:2}}>
          <b.Row style={{margin:2}}>
            <b.Col xs={1} style={{textAlign: "right",lineHeight:"20px",verticalAlign:"middle"}} >
              TEST
            </b.Col>  
            <b.Col xs={sieze1}>
              <b.Input type="text" value={this.state[name1]} 
                name={name1} onChange={this.handleChange} style={{height:20,fontSize:12}}/>
            </b.Col> 
          </b.Row>   
          <b.Row   style={{margin:2}}>
            <b.Col xs={1} style={{textAlign: "right",lineHeight:"20px",verticalAlign:"middle"}}>TEST
            </b.Col>  
            <b.Col xs={sieze1}>
              <b.Input type="text" value={this.state[name1]} 
                name={name1} onChange={this.handleChange} style={{height:20,fontSize:12}}/>
            </b.Col> 
          </b.Row>  
        </form>
		    <b.Table condensed style={{width:"100%"}}>
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
									<b.Input type="select" label='' style={{height:24}}>
										<option value=""></option>
										<option value="V1">Value 1</option>
										<option value="V2">Value 2</option>
									</b.Input>
							
		          </td>

		        </tr>		
		      </tbody>
		    </b.Table>
        <b.Row>
          <b.Col xs={sieze1}>
            <b.Input type="text" value={this.state[name1]} 
              name={name1} onChange={this.handleChange} />
          </ b.Col>
        </b.Row>
        <b.Row>
          <b.Col xs={sieze1}>
            <b.Input type="text" value={this.state.input2} 
               name="input2" onChange={this.handleChange} />
          </ b.Col>
           </b.Row>
        </div>
       
      );
    },
    componentDidMount: function() {
    $w.flux.actions.loadBuzz();
  },
    handleChange: function (e) {
      $w.handleChange(this,e);
    },
    handleClick: function (e) {
      $w.handleClick(this,e);
    }
  });

React.render(<Application />, document.getElementById('content'));
