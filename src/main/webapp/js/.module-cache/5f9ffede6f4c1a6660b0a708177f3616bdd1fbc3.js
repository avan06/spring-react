  var b = ReactBootstrap;
  var optionv =  [
					{
						"value": optionOne,
						"label": "Option One"
					},
					{
						"value": optionsTwo,
						label: "Option Two",
						selected: true,
					}
				];
  var SelectOption = React.createClass({displayName: 'SelectOption',
		
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
    			return React.createElement("option", {key: i, value: opt.value, label: opt.label}, opt.label);
    		}, this);

          return ( 
						React.createElement(b.Input, {type: "select", label: "", style: {height:24}, 
						    defaultValue: defaultValue, 
        				multiple: this.props.multiple, 
        				name: this.props.name}, 
								options
						)
					);
    }
  });
  var Hello = React.createClass({displayName: 'Hello',
    getInitialState: function() {
        return {input1:0, 
                input2:0};
    },
    render: function() {
      var total = this.state.input1 + this.state.input2;
      var name1="input1";
      var sieze1 = 2;
      return (  
        
        React.createElement("div", {className: "container-fixed"}, total, React.createElement("br", null), 
		    React.createElement(b.Table, {condensed: true, style: {width:"100%"}}, 
		      React.createElement("tbody", null, 
		        React.createElement("tr", {style: {height:22}}, 
		          React.createElement("td", {style: {width: 50,textAlign: "right",verticalAlign: "top"}}, "TEST"), 
		          React.createElement("td", {style: {width: 200}}, 
								React.createElement(SelectOption, null)
		          ), 
		          React.createElement("td", {style: {width: 550,textAlign: "left",verticalAlign: "top"}}, "TEST")
		        ), 
		        React.createElement("tr", {style: {height:22}}, 
		          React.createElement("td", {style: {width: 50,textAlign: "right",verticalAlign: "top"}}, "TEST"), 
		          React.createElement("td", {style: {width: 200}}, 
									React.createElement(b.Input, {type: "select", label: "", style: {height:24}}, 
										React.createElement("option", {value: ""}), 
										React.createElement("option", {value: "V1"}, "Value 1"), 
										React.createElement("option", {value: "V2"}, "Value 2")
									)
							
		          )

		        )		
		      )
		    ), 
        React.createElement(b.Row, null, 
          React.createElement(b.Col, {xs: sieze1}, 
            React.createElement(b.Input, {type: "text", value: this.state[name1], 
              name: name1, onChange: this.handleChange})
          )
        ), 
        React.createElement(b.Row, null, 
          React.createElement(b.Col, {xs: sieze1}, 
            React.createElement(b.Input, {type: "text", value: this.state.input2, 
               name: "input2", onChange: this.handleChange})
          )
           )
        )
       
      );
    },
    handleChange: function (e) {
      var change = {};
      change[e.target.name] = Number(e.target.value);
      this.setState(change);
    }
  });

React.render(React.createElement(Hello, null), document.getElementById('content'));
