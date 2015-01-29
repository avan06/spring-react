  var b = ReactBootstrap;
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
	      React.createElement(b.Table, {striped: true, bordered: true, condensed: true, hover: true}, 
		      React.createElement("thead", null, 
		        React.createElement("tr", null, 
		          React.createElement("th", {style: {width: 40}}, "#"), 
		          React.createElement("th", {style: {width: 180}}, "First Name"), 
		          React.createElement("th", {style: {width: 180}}, "Last Name"), 
		          React.createElement("th", {style: {width: 100}}, "Username")
		        )
		      ), 
		      React.createElement("tbody", null, 
		        React.createElement("tr", null, 
		          React.createElement("td", null, "1"), 
		          React.createElement("td", null, "Mark"), 
		          React.createElement("td", null, "Otto"), 
		          React.createElement("td", null, "@mdo")
		        ), 
		        React.createElement("tr", null, 
		          React.createElement("td", null, "2"), 
		          React.createElement("td", null, "Jacob"), 
		          React.createElement("td", null, "Thornton"), 
		          React.createElement("td", null, "@fat")
		        ), 
		        React.createElement("tr", null, 
		          React.createElement("td", null, "3"), 
		          React.createElement("td", {colSpan: "2"}, "Larry the Bird"), 
		          React.createElement("td", null, "@twitter")
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

React.render(React.createElement(Hello, null), document.getElementById('example'));
