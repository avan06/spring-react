b = ReactBootstrap;
Hello = React.createClass
	getInitialState: ->
		input1:0
		input2:0


	render: ->
	  total = this.state.input1 + this.state.input2
	  name1="input1"
	  sieze1 = 1
	  return (
	    <div style={{maxWidth: 800, minWidth: 800, width: 800,  "border-width":1,"border-style":"solid",  background:"#FFF"}}>
	      <b.Table striped bordered condensed hover style={{width:"100%"}}>
		      <thead>
		        <tr>
		          <th style={{width: 40}}>#</th>
		          <th style={{width: 180}}>First Name</th>
		          <th style={{width: 180}}>Last Name</th>
		          <th style={{width: 100}}>Username</th>
		        </tr>
		      </thead>
		      <tbody>
		        <tr>
		          <td>1</td>
		          <td>Mark</td>
		          <td>Otto</td>
		          <td>@mdo</td>
		        </tr>
		        <tr>
		          <td>2</td>
		          <td>Jacob</td>
		          <td>Thornton</td>
		          <td>@fat</td>
		        </tr>
		        <tr>
		          <td>3</td>
		          <td colSpan="2">Larry the Bird</td>
		          <td>@twitter</td>
		        </tr>
		      </tbody>
			  </b.Table>
		    <b.Table condensed style={{width:"100%"}}>
		      <tbody>
		        <tr>
		          <td align="right" valign="middle" style={{width: 100,"text-align": "right","vertical-align": "middle"}}>TEST</td>
		          <td>
									<b.Input type="select" label=''>
										<option value=""></option>
										<option value="V1">Value 1</option>
										<option value="V2">Value 2</option>
									</b.Input>
							
		          </td>
		          <td style={{width: 100}}>Otto</td>
	
		        </tr>
		
		      </tbody>
		    </b.Table>
		    {total}
		    <br/>
		    <b.Row>
		      <b.Col xs={sieze1}>
		        <b.Input type="text" value={this.state[name1]} style={{padding: 1}}
		          name={name1} onChange={this.handleChange} />
		      </b.Col>
		    </b.Row>
		    <b.Row>
		      <b.Col xs={1}>&nbsp;TEST
		      </b.Col>
		      <b.Col xs={2}>
			      <b.Input type="select" label='' >
			        <option value=""></option>
			        <option value="V1">Value 1</option>
			        <option value="V2">Value 2</option>
			      </b.Input>
		      </b.Col>
		    </b.Row>
	    </div>
	   
	  )

	handleChange: (e) ->
	  change = {}
	  change[e.target.name] = Number(e.target.value)
	  this.setState(change)
window.onload = ->
	React.render(<Hello />, document.getElementById('example'))