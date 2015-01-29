  var Input = ReactBootstrap.Input;
  var Hello = React.createClass({displayName: 'Hello',
    getInitialState: function() {
        return {input1:0, 
                input2:0};
    },
    render: function() {
      var total = this.state.input1 + this.state.input2;
      return (
        React.createElement("form", null, 
        React.createElement("div", null, total, React.createElement("br", null), 
          React.createElement(Input, {type: "text", value: this.state.input1, width: "200px", 
                             onChange: this.handleChange.bind(this, 'input1','t')}), 
          React.createElement(Input, {type: "text", value: this.state.input2, 
                             onChange: this.handleChange.bind(this, 'input2','x')})
        )
        )
      );
    },
    handleChange: function (name,n2, e) {
      var change = {};
      change[name] = Number(e.target.value);
      this.setState(change);
    }
  });

React.renderComponent(React.createElement(Hello, null), document.getElementById('example'));
