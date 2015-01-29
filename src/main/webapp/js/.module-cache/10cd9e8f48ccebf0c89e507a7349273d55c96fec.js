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
				
  var SelectOption = React.createClass({displayName: 'SelectOption',
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
    			return React.createElement("option", {key: i, value: opt.value, label: opt.label}, opt.label);
    		}, this);

          return ( 
						React.createElement(b.Input, {type: "select", label: "", 
						    defaultValue: defaultValue, 
        				multiple: this.props.multiple, 
        				name: this.props.name, style: this.props.style, 
        				onSelect: this.handleChange
        				}, 
								options
						)
					);
    }
  });
  var Application = React.createClass({displayName: 'Application',
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
        
        React.createElement("div", {className: "container-fixed", style: {fontSize:12}}, 
        React.createElement("p", {style: {marginLeft:30}}, total), 
		    React.createElement(b.Row, {style: {margin:2}}, 

            React.createElement(b.Button, {bsSize: "small", bsStyle: "primary", onClick: this.handleClick, name: "btnSearch"}, "検索"), 

            React.createElement(b.Button, {bsSize: "small", bsStyle: "primary", onClick: this.handleClick, name: "btnSearch2"}, "TEST"), 

            React.createElement(b.Button, {bsSize: "small", bsStyle: "primary", onClick: this.handleClick, name: "btnSearch"}, "検索"), 

            React.createElement(b.Button, {bsSize: "small", bsStyle: "primary", onClick: this.handleClick, name: "btnSearch2"}, "検索")

        ), 
        React.createElement("form", {className: "form-horizontal", style: {margin:2}}, 
          React.createElement(b.Row, {style: {margin:2}}, 
            React.createElement(b.Col, {xs: 1, style: {textAlign: "right",lineHeight:"20px",verticalAlign:"middle"}}, 
              "TEST"
            ), 
            React.createElement(b.Col, {xs: sieze1}, 
              React.createElement(b.Input, {type: "text", value: this.state[name1], 
                name: name1, onChange: this.handleChange, style: {height:20,fontSize:12}})
            )
          ), 
          React.createElement(b.Row, {style: {margin:2}}, 
            React.createElement(b.Col, {xs: 1, style: {textAlign: "right",lineHeight:"20px",verticalAlign:"middle"}}, "TEST"
            ), 
            React.createElement(b.Col, {xs: sieze1}, 
              React.createElement(b.Input, {type: "text", value: this.state[name1], 
                name: name1, onChange: this.handleChange, style: {height:20,fontSize:12}})
            )
          )
        ), 
		    React.createElement(b.Table, {condensed: true, style: {width:"100%"}}, 
		      React.createElement("tbody", null, 
		        React.createElement("tr", {style: {height:22}}, 
		          React.createElement("td", {style: {width: 50,textAlign: "right",verticalAlign: "middle"}}, "TEST"), 
		          React.createElement("td", {style: {width: 200}}, 
								React.createElement(SelectOption, {options: optionv, style: {height:24, fontSize:12}, name: "testname", 
								onChange: this.handleChange})
		          ), 
		          React.createElement("td", {style: {width: 550,textAlign: "left",verticalAlign: "middle"}}, "TEST")
		        ), 
		        React.createElement("tr", {style: {height:22}}, 
		          React.createElement("td", {style: {width: 50,textAlign: "right",verticalAlign: "middle"}}, "TEST"), 
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

React.render(React.createElement(Application, null), document.getElementById('content'));
