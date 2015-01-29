 var b = ReactBootstrap;
$w.LoginRows = React.createClass({displayName: 'LoginRows',

    render: function() {
        var rows = this.props.rcds.map(function(rcd, i){
        var bgcolor="";
        if (i==this.props.selRow)
          bgcolor="#d9edf7";
        else
          if (i%2 == 1)
            bgcolor="#F8F8F8";
          else
            bgcolor="#FFFFFF";
        return (
          React.createElement("tr", {key: i}, 
          React.createElement("td", {id: "loginrow#loginId#"+i, style: {width:this.props.cw.c1,backgroundColor:bgcolor}}, rcd.loginId), 
          React.createElement("td", {id: "loginrow#name#"+i, style: {width:this.props.cw.c2,backgroundColor:bgcolor}}, rcd.name), 
          React.createElement("td", {id: "loginrow#lid#"+i, style: {width:this.props.cw.c3,backgroundColor:bgcolor,textAlign:"right"}}, rcd.id), 
          React.createElement("td", {id: "loginrow#versionNo#"+i, style: {width:this.props.cw.c4,backgroundColor:bgcolor,textAlign:"right"}}, rcd.versionNo)
         )
        )
        }, this);
          return ( 
            React.createElement("tbody", {style: {overflowY:"auto",height:92}}, 
                rows
            )
          );
    }
  });
$w.app = React.createClass({displayName: 'Application',
  mixins: [$w.FluxMixin, $w.StoreWatchMixin("COMMON","RCD")],
  getInitialState: function() {
  $w.app = this;
      blank={
                    loginId:"",
                    name:"",
                    id:"",
                    versionNo:"",
                    password:"",
                    passwordcfm:""
                    
                };
      return {
                user:$c.login.name,
                search:{
                  loginId:"starts with",
                  loginId_s:"",
                  loginId_e:"",
                  name:"starts with",
                  name_s:"",
                  name_e:""
                },
                login:{
                  url:"/ajax/login",
                  cw:{c1:100,c2:150,c3:60,c4:60},
                  rcds:[],
                  blank:_.cloneDeep(blank),
                  selRow:-1
                },
                form:_.cloneDeep(blank)
              };
  },
  getStateFromFlux: function() {
    return {
      common:_.cloneDeep($w.common.data),
      rcd:_.cloneDeep($w.rcd.data)
      };
  },
  render: function() {
    return (
      React.createElement("div", {className: "container-fixed", 
          style: {fontSize:12,border:1,borderStyle:"solid",width:800,height:600,backgroundColor: "#F0F0F0"}}, 

      React.createElement(b.Row, {className: "darkBgLarge", 
          style: {margin:0,height:40,lineHeight:"40px",verticalAlign: "middle"}}, 
        React.createElement(b.Col, {xs: 5, style: {textAlign: "center"}}, "USER管理"
        ), 
        React.createElement(b.Col, {xs: 5, className: "darkBgMid", style: {textAlign: "center"}}, 
        this.state.user
        ), 
        React.createElement(b.Col, {xs: 1, className: "darkBgMid"}
        ), 
         React.createElement(b.Col, {xs: 1}, 
        React.createElement($c.Loader, {src: "../img/ajax-loader.gif", isLoading: this.state.common.loading})
        )
      ), 
      React.createElement(b.Row, {style: {margin:5}}, 
      React.createElement(b.Button, {bsSize: "xsmall", bsStyle: "primary", onClick: $w.handleClick, 
        name: "btnSearch", style: {width:60,marginLeft:10}}, "検索")
      ), 
      React.createElement(b.Row, {　style: {verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}, 
         React.createElement(b.Col, {xs: 1, style: {textAlign: "right"}}, "Login ID"
          ), 
          React.createElement(b.Col, {xs: 2}, 
          React.createElement($c.SelectOption, {options: $c.stringOption, style: {height:24,  fontSize:12}, 
               name: "search#loginId", 
              defaultValue: this.state.search.loginId, onChange: $w.handleChange})
          ), 
          React.createElement(b.Col, {xs: 3}, 
          React.createElement(b.Input, {type: "text", value: this.state.search.loginId_s, 
            name: "search#loginId_s", onChange: $w.handleChange, 
            style: {height:24,fontSize:12,width:"100%"}})
          ), 
          React.createElement(b.Col, {xs: 3}, 
          React.createElement(b.Input, {type: "text", value: this.state.search.loginId_e, 
            name: "search#loginId_e", onChange: $w.handleChange, 
            style: {height:24,fontSize:12,width:"100%"}})
          )
      ), 
      React.createElement(b.Row, {　style: {verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}, 
         React.createElement(b.Col, {xs: 1, style: {textAlign: "right"}}, "氏名"
          ), 
          React.createElement(b.Col, {xs: 2}, 
          React.createElement($c.SelectOption, {options: $c.stringOption, 
              style: {height:24,  fontSize:12}, name: "search#name", 
              defaultValue: this.state.search.name, onChange: $w.handleChange})
          ), 
          React.createElement(b.Col, {xs: 3}, 
          React.createElement(b.Input, {type: "text", value: this.state.search.name_s, 
            name: "search#name_s", onChange: $w.handleChange, 
            style: {height:24,fontSize:12,width:"100%"}})
          ), 
          React.createElement(b.Col, {xs: 3}, 
          React.createElement(b.Input, {type: "text", value: this.state.search.name_e, 
            name: "search#name_e", onChange: $w.handleChange, 
            style: {height:24,fontSize:12,width:"100%"}})
          )
      ), 
      React.createElement("div", {style: {width:400,border:1,borderStyle:"solid",
          borderColor:"black",height:120,backgroundColor: "#FFFFFF"}}, 
      React.createElement(b.Table, {bordered: true, condensed: true, className: "wscrolltable", 
          style: {width:"100%",height:"100%"}, 
      onClick: $w.handleClick}, 
       React.createElement("thead", null, 
        React.createElement("tr", null, 
          React.createElement("th", {　style: {width:this.state.login.cw.c1}}, "Login Id"), 
          React.createElement("th", {style: {width:this.state.login.cw.c2}}, "氏名"), 
          React.createElement("th", {　style: {width:this.state.login.cw.c3}}, "id"), 
          React.createElement("th", {style: {width:this.state.login.cw.c4}}, "versionNo")
        )
      ), 
      React.createElement($w.LoginRows, {rcds: this.state.login.rcds, cw: this.state.login.cw, 
          selRow: this.state.login.selRow})
      )
      ), 
      React.createElement(b.Row, {style: {margin:5}}, 
        React.createElement(b.Button, {bsSize: "xsmall", bsStyle: "primary", onClick: $w.handleClick, 
            name: "btnNew", style: {width:60,marginLeft:10}}, "新規"), 
        React.createElement(b.Button, {bsSize: "xsmall", bsStyle: "primary", onClick: $w.handleClick, 
            name: "btnUpdate", style: {width:60,marginLeft:10}}, "更新"), 
        React.createElement(b.Button, {bsSize: "xsmall", bsStyle: "primary", onClick: $w.handleClick, 
            name: "btnDelete", style: {width:60,marginLeft:10}}, "削除")

      ), 
      React.createElement(b.Row, {　style: {verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}, 
         React.createElement(b.Col, {xs: 2, style: {textAlign: "right"}}, "Login ID"
          ), 
          React.createElement(b.Col, {xs: 2}, 
          React.createElement(b.Input, {type: "text", value: this.state.form.loginId, 
            name: "form#loginId", onChange: $w.handleChange, 
            style: {height:24,fontSize:12,width:"100%"}})
          )
      ), 
      React.createElement(b.Row, {　style: {verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}, 
         React.createElement(b.Col, {xs: 2, style: {textAlign: "right"}}, "氏名"
          ), 
          React.createElement(b.Col, {xs: 2}, 
          React.createElement(b.Input, {type: "text", value: this.state.form.name, 
            name: "form#name", onChange: $w.handleChange, 
            style: {height:24,fontSize:12,width:"100%"}})
          )
      ), 
      React.createElement(b.Row, {　style: {verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}, 
         React.createElement(b.Col, {xs: 2, style: {textAlign: "right"}}, "パスワード"
          ), 
          React.createElement(b.Col, {xs: 2}, 
          React.createElement(b.Input, {type: "password", value: this.state.form.password, 
            name: "form#password", onChange: $w.handleChange, 
            style: {height:24,fontSize:12,width:"100%"}})
          )
      ), 
      React.createElement(b.Row, {　style: {verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}, 
         React.createElement(b.Col, {xs: 2, style: {textAlign: "right"}}, "パスワード(確認）"
          ), 
          React.createElement(b.Col, {xs: 2}, 
          React.createElement(b.Input, {type: "password", value: this.state.form.passwordcfm, 
            name: "form#passwordcfm", onChange: $w.handleChange, 
            style: {height:24,fontSize:12,width:"100%"}})
          )
      ), 
      React.createElement(b.Row, {　style: {verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}, 
         React.createElement(b.Col, {xs: 2, style: {textAlign: "right"}}, "id"
          ), 
          React.createElement(b.Col, {xs: 1}, 
          React.createElement(b.Input, {type: "text", value: this.state.form.id, 
            name: "form#id", onChange: $w.handleChange, 
            disabled: true, 
            style: {height:24,fontSize:12,width:"100%"}})
          ), 
         React.createElement(b.Col, {xs: 1, xsOffset: 1, style: {textAlign: "right"}}, "ver. No"
          ), 
          React.createElement(b.Col, {xs: 1}, 
          React.createElement(b.Input, {type: "text", value: this.state.form.versionNo, 
            name: "form#versionNo", onChange: $w.handleChange, 
            disabled: true, 
            style: {height:24,fontSize:12,width:"100%"}})
          )
      ), 
      React.createElement($c.Alert, {isShow: this.state.common.alert.isShow, 
          message: this.state.common.alert.message, onClick: $w.handleClick}), 
      React.createElement($c.DeleteConfirm, {isShow: this.state.common.deleteCfm.isShow, 
          onClick: $w.handleClick})
      )
    );
  },
  componentDidMount: function() {
  }

});

React.render(React.createElement($w.app, {flux: $w.flux}), document.getElementById('content'));