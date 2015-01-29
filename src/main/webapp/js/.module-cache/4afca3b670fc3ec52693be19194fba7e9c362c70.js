  var b = ReactBootstrap;
  var Hello = React.createClass({displayName: 'Hello',
    getInitialState: function() {
        return {input1:0, 
                input2:0};
    },
    render: function() {
      var total = this.state.input1 + this.state.input2;
      return (
        
        React.createElement("div", {class: "container-fixed"}, total, React.createElement("br", null), 
        React.createElement(b.Row, null, 
          React.createElement(b.Col, {xs: 1}, 
            React.createElement(b.Input, {type: "text", value: this.state.input1, 
              name: "input1", onChange: this.handleChange})
          )
        ), 
        React.createElement(b.Row, null, 
          React.createElement(b.Col, {xs: 1}, 
            React.createElement(b.Input, {type: "text", value: this.state.input2, 
               name: "input1", onChange: this.handleChange})
          )
           )
        )
       
      );
    },
    handleChange: function (e) {
      var change = {};
      change[name] = Number(e.target.value);
      this.setState(change);
    }
  });

React.renderComponent(React.createElement(Hello, null), document.getElementById('example'));
