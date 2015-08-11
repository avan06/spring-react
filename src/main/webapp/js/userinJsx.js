// Generated by CoffeeScript 1.9.3
wObj.LoginRows = React.createClass({displayName: "LoginRows",
  render: function() {
    var rows;
    wObj.loginRows = this;
    rows = this.props.rcds.map(function(rcd, i) {
      var bgcolor;
      bgcolor = "";
      if (i === this.props.selRow) {
        bgcolor = "#d9edf7";
        return React.createElement("tr", {
          "key": i,
          "draggable": "true",
          "onDragOver": this.props.onDragOver,
          "onDragStart": this.props.onDragStart,
          "onDrop": this.props.onDrop,
          "id": "row#" + i
        }, React.createElement("td", {
          "style": {
            width: this.props.cw.c1,
            backgroundColor: bgcolor,
            padding: 0,
            margin: 0
          }
        }, React.createElement(ReactBootstrap.Input, {
          "type": "text",
          "value": rcd.loginId,
          "name": "loginrow#loginId#" + i,
          "ref": "loginrow#loginId#" + i,
          "onChange": this.props.onChange,
          "onKeyDown": this.props.onKeyDown,
          "style": {
            height: 20,
            fontSize: 12,
            width: "100%",
            padding: 0,
            margin: 0
          }
        })), React.createElement("td", {
          "style": {
            width: this.props.cw.c2,
            backgroundColor: bgcolor,
            padding: 0,
            margin: 0
          }
        }, React.createElement(ReactBootstrap.Input, {
          "type": "text",
          "value": rcd.name,
          "name": "loginrow#name#" + i,
          "ref": "loginrow#name#" + i,
          "onChange": this.props.onChange,
          "onKeyDown": this.props.onKeyDown,
          "style": {
            height: 20,
            fontSize: 12,
            width: "100%",
            padding: 0,
            margin: 0
          }
        })), React.createElement("td", {
          "style": {
            width: this.props.cw.c3,
            backgroundColor: bgcolor,
            padding: 0,
            margin: 0
          }
        }, React.createElement(ReactBootstrap.Input, {
          "type": "text",
          "value": rcd.role,
          "name": "loginrow#role#" + i,
          "ref": "loginrow#role#" + i,
          "onChange": this.props.onChange,
          "onKeyDown": this.props.onKeyDown,
          "style": {
            height: 20,
            fontSize: 12,
            width: "100%",
            padding: 0,
            margin: 0
          }
        })), React.createElement("td", {
          "id": "loginrow#lid#" + i,
          "style": {
            width: this.props.cw.c4,
            backgroundColor: bgcolor,
            textAlign: "right"
          }
        }, rcd.id), React.createElement("td", {
          "id": "loginrow#versionNo#" + i,
          "style": {
            width: this.props.cw.c5,
            backgroundColor: bgcolor,
            textAlign: "right"
          }
        }, rcd.versionNo));
      } else {
        if (i % 2 === 1) {
          bgcolor = "#F8F8F8";
        } else {
          bgcolor = "#FFFFFF";
        }
      }
      return React.createElement("tr", {
        "key": i,
        "draggable": "true",
        "onDragOver": this.props.onDragOver,
        "onDragStart": this.props.onDragStart,
        "onDrop": this.props.onDrop,
        "id": "row#" + i
      }, React.createElement("td", {
        "id": "loginrow#loginId#" + i,
        "style": {
          width: this.props.cw.c1,
          backgroundColor: bgcolor
        }
      }, rcd.loginId), React.createElement("td", {
        "id": "loginrow#name#" + i,
        "style": {
          width: this.props.cw.c2,
          backgroundColor: bgcolor
        }
      }, rcd.name), React.createElement("td", {
        "id": "loginrow#role#" + i,
        "style": {
          width: this.props.cw.c3,
          backgroundColor: bgcolor
        }
      }, rcd.role), React.createElement("td", {
        "id": "loginrow#lid#" + i,
        "style": {
          width: this.props.cw.c4,
          backgroundColor: bgcolor,
          textAlign: "right"
        }
      }, rcd.id), React.createElement("td", {
        "id": "loginrow#versionNo#" + i,
        "style": {
          width: this.props.cw.c5,
          backgroundColor: bgcolor,
          textAlign: "right"
        }
      }, rcd.versionNo));
    }, this);
    return React.createElement("tbody", {
      "style": {
        overflowY: "auto",
        height: 92
      }
    }, rows);
  }
});

wObj.Application = React.createClass({displayName: "Application",
  mixins: [wObj.FluxMixin, wObj.StoreWatchMixin("PAGE", "COMMON", "RCD")],
  getInitialState: function() {
    var blank;
    wObj.application = this;
    blank = {
      loginId: "",
      name: "",
      role: "",
      id: "",
      versionNo: "",
      password: "",
      passwordcfm: ""
    };
    return {
      user: base.login.name,
      search: {
        loginId: "starts with",
        loginId_s: "",
        loginId_e: "",
        name: "starts with",
        name_s: "",
        name_e: ""
      },
      login: {
        url: "/ajax/login",
        cw: {
          c1: 100,
          c2: 150,
          c3: 60,
          c4: 60,
          c5: 60
        },
        rcds: [],
        blank: _.cloneDeep(blank),
        selRow: -1
      },
      form: _.cloneDeep(blank)
    };
  },
  getStateFromFlux: function() {

    /* @props.flux=wObj.flux; */
    var commonStore, pageStore, rcdStore;
    pageStore = wObj.flux.stores.PAGE;
    commonStore = wObj.flux.stores.COMMON;
    rcdStore = wObj.flux.stores.RCD;
    return {
      page: _.cloneDeep(pageStore.data),
      common: _.cloneDeep(commonStore.data),
      rcd: _.cloneDeep(rcdStore.data)
    };
  },
  render: function() {
    return React.createElement("div", {
      "className": "container-fixed",
      "style": {
        fontSize: 12,
        border: 1,
        borderStyle: "solid",
        width: 800,
        height: 600,
        backgroundColor: "#F0F0F0"
      }
    }, React.createElement(ReactBootstrap.Row, {
      "className": "darkBgLarge",
      "style": {
        margin: 0,
        height: 40,
        lineHeight: "40px",
        verticalAlign: "middle"
      }
    }, React.createElement(ReactBootstrap.Col, {
      "xs": 5.,
      "style": {
        textAlign: "center"
      }
    }, "USER\u7ba1\u7406"), React.createElement(ReactBootstrap.Col, {
      "xs": 5.,
      "className": "darkBgMid",
      "style": {
        textAlign: "center"
      }
    }, this.state.user), React.createElement(ReactBootstrap.Col, {
      "xs": 1.,
      "className": "darkBgMid"
    }), React.createElement(ReactBootstrap.Col, {
      "xs": 1.
    }, React.createElement(base.Loader, {
      "src": "./img/ajax-loader.gif",
      "isLoading": this.state.common.loading
    }))), React.createElement(ReactBootstrap.Row, {
      "style": {
        margin: 5
      }
    }, React.createElement(ReactBootstrap.Button, {
      "bsSize": "xsmall",
      "bsStyle": "primary",
      "onClick": wObj.handleClick,
      "name": "btnSearch",
      "style": {
        width: 60,
        marginLeft: 10
      }
    }, "\u691c\u7d22")), React.createElement(ReactBootstrap.Row, {
      "style": {
        verticalAlign: "middle",
        lineHeight: "26px",
        marginLeft: 0
      }
    }, React.createElement(ReactBootstrap.Col, {
      "xs": 1.,
      "style": {
        textAlign: "right"
      }
    }, "Login ID"), React.createElement(ReactBootstrap.Col, {
      "xs": 2.
    }, React.createElement(base.SelectOption, {
      "options": base.stringOption,
      "style": {
        height: 24,
        fontSize: 12
      },
      "name": "search#loginId",
      "defaultValue": this.state.search.loginId,
      "onChange": wObj.handleChange
    })), React.createElement(ReactBootstrap.Col, {
      "xs": 3.
    }, React.createElement(ReactBootstrap.Input, {
      "type": "text",
      "value": this.state.search.loginId_s,
      "name": "search#loginId_s",
      "onChange": wObj.handleChange,
      "style": {
        height: 24,
        fontSize: 12,
        width: "100%"
      }
    })), React.createElement(ReactBootstrap.Col, {
      "xs": 3.
    }, React.createElement(ReactBootstrap.Input, {
      "type": "text",
      "value": this.state.search.loginId_e,
      "name": "search#loginId_e",
      "onChange": wObj.handleChange,
      "style": {
        height: 24,
        fontSize: 12,
        width: "100%"
      }
    }))), React.createElement(ReactBootstrap.Row, {
      "style": {
        verticalAlign: "middle",
        lineHeight: "26px",
        marginLeft: 0
      }
    }, React.createElement(ReactBootstrap.Col, {
      "xs": 1.,
      "style": {
        textAlign: "right"
      }
    }, "\u6c0f\u540d"), React.createElement(ReactBootstrap.Col, {
      "xs": 2.
    }, React.createElement(base.SelectOption, {
      "options": base.stringOption,
      "style": {
        height: 24,
        fontSize: 12
      },
      "name": "search#name",
      "defaultValue": this.state.search.name,
      "onChange": wObj.handleChange
    })), React.createElement(ReactBootstrap.Col, {
      "xs": 3.
    }, React.createElement(ReactBootstrap.Input, {
      "type": "text",
      "value": this.state.search.name_s,
      "name": "search#name_s",
      "onChange": wObj.handleChange,
      "style": {
        height: 24,
        fontSize: 12,
        width: "100%"
      }
    })), React.createElement(ReactBootstrap.Col, {
      "xs": 3.
    }, React.createElement(ReactBootstrap.Input, {
      "type": "text",
      "value": this.state.search.name_e,
      "name": "search#name_e",
      "onChange": wObj.handleChange,
      "style": {
        height: 24,
        fontSize: 12,
        width: "100%"
      }
    }))), React.createElement(ReactBootstrap.Row, {
      "style": {
        margin: 5
      }
    }, React.createElement(ReactBootstrap.Button, {
      "bsSize": "xsmall",
      "bsStyle": "primary",
      "onClick": wObj.handleClick,
      "name": "btnUpdate",
      "style": {
        width: 60,
        marginLeft: 10
      }
    }, "\u66f4\u65b0"), React.createElement(ReactBootstrap.Button, {
      "bsSize": "xsmall",
      "bsStyle": "primary",
      "onClick": wObj.handleClick,
      "name": "btnDelete",
      "style": {
        width: 60,
        marginLeft: 10
      }
    }, "\u524a\u9664"), React.createElement(ReactBootstrap.Button, {
      "bsSize": "xsmall",
      "bsStyle": "primary",
      "onClick": wObj.handleClick,
      "name": "btnCancel",
      "style": {
        width: 60,
        marginLeft: 10
      }
    }, "\u53d6\u6d88")), React.createElement("div", {
      "style": {
        width: 460,
        border: 1,
        borderStyle: "solid",
        borderColor: "black",
        height: 120,
        backgroundColor: "#FFFFFF"
      }
    }, React.createElement(ReactBootstrap.Table, {
      "bordered": true,
      "condensed": true,
      "className": "wscrolltable",
      "style": {
        width: "100%",
        height: "100%"
      },
      "onClick": wObj.handleClick
    }, React.createElement("thead", null, React.createElement("tr", null, React.createElement("th", {
      "style": {
        width: this.state.login.cw.c1
      }
    }, "Login Id"), React.createElement("th", {
      "style": {
        width: this.state.login.cw.c2
      }
    }, "\u6c0f\u540d"), React.createElement("th", {
      "style": {
        width: this.state.login.cw.c3
      }
    }, "Role"), React.createElement("th", {
      "style": {
        width: this.state.login.cw.c4
      }
    }, "id"), React.createElement("th", {
      "style": {
        width: this.state.login.cw.c5
      }
    }, "versionNo"))), React.createElement(wObj.LoginRows, {
      "rcds": this.state.login.rcds,
      "cw": this.state.login.cw,
      "selRow": this.state.login.selRow,
      "onChange": wObj.handleChange,
      "onKeyDown": wObj.handleRowKeyDown,
      "onDragStart": this.dragStart,
      "onDrop": this.drop,
      "onDragOver": this.dragOver
    }))), React.createElement(base.Alert, {
      "isShow": this.state.common.alert.isShow,
      "message": this.state.common.alert.message,
      "onClick": wObj.handleClick
    }), React.createElement(base.DeleteConfirm, {
      "isShow": this.state.common.deleteCfm.isShow,
      "onClick": wObj.handleClick
    }));
  },
  componentDidMount: function() {},
  dragStart: function(e) {
    return e.dataTransfer.setData("text", e.target.id);
  },
  drop: function(e) {
    var from, to;
    e.preventDefault();
    from = e.dataTransfer.getData("text");
    to = e.target.id;
    return wObj.drop(this, from, to);
  },
  dragOver: function(e) {
    return e.preventDefault();
  }
});

React.render(React.createElement(wObj.Application, {
  "flux": wObj.flux
}), document.getElementById('content'));
