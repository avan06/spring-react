  var Hello = React.createClass({displayName: 'Hello',
    getInitialState: function() {
        return {input1:0, 
                input2:0};
    },
    render: function() {
      var total = this.state.input1 + this.state.input2;
      return (
        React.createElement("div", null, total, React.createElement("br", null), 
          React.createElement("input", {type: "text", value: this.state.input1, 
                             onChange: this.handleChange.bind(this, 'input1','t')}), 
          React.createElement("input", {type: "text", value: this.state.input2, 
                             onChange: this.handleChange.bind(this, 'input2','x')})
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
