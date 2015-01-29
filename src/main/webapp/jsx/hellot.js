  var b = ReactBootstrap;
  var Hello = React.createClass({
    getInitialState: function() {
        return {input1:0, 
                input2:0};
    },
    render: function() {
      var total = this.state.input1 + this.state.input2;
      var name1="input1";
      var sieze1 = 2;
      return (
        
        <div className="container-fixed">{total}<br/>
		    <b.Table condensed style={{width:"100%"}}>
		      <tbody>
		        <tr>
		          <td align="right" valign="middle" style={{width: 50,"text-align": "right","vertical-align": "top"}}>TEST</td>
		          <td style={{width: 200}}>
									<b.Input type="select" label='' >
										<option value=""></option>
										<option value="V1">Value 1</option>
										<option value="V2">Value 2</option>
									</b.Input>
							
		          </td>
		          <td style={{width: "100% - 300px"}}>Otto</td>
	
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
    handleChange: function (e) {
      var change = {};
      change[e.target.name] = Number(e.target.value);
      this.setState(change);
    }
  });

React.render(<Hello />, document.getElementById('example'));
