(function() {
  var rcdStore;
  $c.checkAndCreate("$w");
  $w.handleChange = function(jsx, e) {
    var logintemp, names;
    names = e.target.name.split("#");
    if (names[0] === "loginrow") {
      logintemp = {
        login: jsx.state.login
      };
      logintemp.login.rcds[names[2]][names[1]] = e.target.value;
      jsx.setState(logintemp);
      return;
    }
    return $c.handleChange(jsx, e.target.name, e.target.value);
  };
  $w.setFocus = function(ref, def) {
    var refnode;
    refnode = $w.loginRows.refs[ref];
    if (typeof refnode === "undefined") {
      refnode = $w.loginRows.refs[def];
    }
    return refnode.getInputDOMNode().focus();
  };
  $w.handleClick = function(jsx, e) {
    var def, ids, logintemp, name, ref, selRow;
    name = e.target.name;
    ids = e.target.id.split("#");
    if (ids[0] === "loginrow") {
      logintemp = {
        login: jsx.state.login
      };
      selRow = Number(ids[2]);
      logintemp.login.selRow = selRow;
      logintemp.form = _.cloneDeep(logintemp.login.rcds[selRow]);
      logintemp.form.password = "";
      logintemp.form.passwordcfm = "";
      ref = "loginrow#" + ids[1] + "#" + selRow;
      def = "loginrow#loginId#" + selRow;
      jsx.setState(logintemp, $w.setFocus.bind(this, ref, def));
    }
    if (name === "alert#CloseBtn") {
      $w.flux.actions.$c_alertHide();
    }
    if (name === "deleteCfm#CloseBtn") {
      $w.flux.actions.$c_deleteCfmHide();
    }
    if (name === "deleteCfm#YesBtn") {
      $w.flux.actions.$c_deleteCfmHide();
      $w.formDeleteCfm(jsx);
    }
    if (name === "btnCancel") {
      $w.formCancel(jsx);
    }
    if (name === "btnSearch") {
      $w.formSearch(jsx);
    }
    if (name === "btnUpdate") {
      $w.formUpdate(jsx);
    }
    if (name === "btnDelete") {
      return $w.formDelete(jsx);
    }
  };
  $w.handleRowKeyDown = function(jsx, e) {
    var curRow, def, done, logintemp, name, names, ref;
    name = e.target.name;
    names = name.split("#");
    logintemp = {
      login: jsx.state.login
    };
    curRow = logintemp.login.selRow;
    done = false;
    if (e.key === "ArrowDown") {
      curRow++;
      done = true;
    }
    if (e.key === "ArrowUp") {
      curRow--;
      done = true;
    }
    if (e.key === "Enter") {
      done = true;
    }
    if (done === false) {
      return;
    }
    if (curRow < 0) {
      curRow = 0;
    }
    if (curRow > (logintemp.login.rcds.length - 1)) {
      logintemp.login.rcds.push(logintemp.login.blank);
    }
    if (e.key === "Enter") {
      logintemp.login.selRow = -1;
      jsx.setState(logintemp);
      return;
    }
    logintemp.login.selRow = curRow;
    ref = "loginrow#" + names[1] + "#" + curRow;
    def = "loginrow#loginId#" + curRow;
    return jsx.setState(logintemp, $w.setFocus.bind(this, ref, def));
  };
  $w.formSearch = function(jsx) {
    var criteria;
    criteria = $c.createCriteria(jsx.state.search, ["loginId", "name"]);
    return $w.flux.actions.$c_rcd_fetch(jsx.state.login, jsx.state.form, "login", criteria);
  };
  $w.formUpdate = function(jsx) {
    var def, dirty, i, logintemp, oldrcds, oldrecord, params, rcd, rcds, ref, res, rules, tran, _len;
    oldrcds = jsx.state.rcd.login.rcds;
    rcds = jsx.state.login.rcds;
    rules = [];
    rules.push("required,loginId,Login IDは必須項目です");
    rules.push("required,name,氏名は必須項目です");
    params = {
      transactions: []
    };
    for (i = 0, _len = rcds.length; i < _len; i++) {
      rcd = rcds[i];
      res = $v.validate(rcd, rules);
      if (res.length > 0) {
        $w.flux.actions.$c_alertShow(res);
        logintemp = {
          login: jsx.state.login
        };
        logintemp.login.i;
        ref = "loginrow#loginId#" + i;
        def = ref;
        jsx.setState(logintemp, $w.setFocus.bind(this, ref, def));
        return;
      }
      if (rcd.id === "") {
        rcd.password = "kam";
        rcd.passwordcfm = "kam";
        tran = {
          operationType: "add",
          data: rcd
        };
        params.transactions.push(tran);
      } else {
        oldrecord = $c.getRecordById(oldrcds, rcd.id);
        dirty = $c.dirtyCheck(oldrecord, rcd);
        if (dirty) {
          rcd.password = "";
          rcd.passwordcfm = "";
          tran = {
            operationType: "update",
            data: rcd
          };
          params.transactions.push(tran);
        }
      }
    }
    if (params.transactions.length > 0) {
      return $w.flux.actions.$c_rcd_transaction(jsx.state.login, params, "login");
    }
  };
  $w.formDelete = function(jsx) {
    if (jsx.state.form.id === "") {
      $w.flux.actions.$c_rcd_delete_id_blank();
      return;
    }
    return $w.flux.actions.$c_deleteCfmShow();
  };
  $w.formCancel = function(jsx) {
    return $w.rcdSet();
  };
  $w.formDeleteCfm = function(jsx) {
    return $w.flux.actions.$c_rcd_delete(jsx.state.login, jsx.state.login.rcds[jsx.state.login.selRow], "login");
  };
  $w.formUpdateCheck = function(form) {
    if (form.password > "" || form.passwordcfm > "") {
      if (form.password !== form.passwordcfm) {
        return [["", "パスワードとパスワード（確認）が一致しません"]];
      }
    }
    return "";
  };
  $w.formClear = function(jsx) {
    var formtemp;
    formtemp = {
      form: {
        loginId: "",
        name: "",
        id: "",
        versionNo: "",
        password: "",
        passwordcfm: ""
      }
    };
    return jsx.setState(formtemp);
  };
  $w.drop = function(jsx, from, to) {
    var fromno, froms, i, newrcds, rcd, rcds, temp, tono, tos, _len;
    froms = from.split("#");
    tos = to.split("#");
    fromno = Number(froms[froms.length - 1]);
    tono = Number(tos[tos.length - 1]);
    rcds = jsx.state.login.rcds;
    newrcds = [];
    for (i = 0, _len = rcds.length; i < _len; i++) {
      rcd = rcds[i];
      if (i === tono) {
        newrcds.push(rcds[fromno]);
        newrcds.push(rcds[tono]);
      } else {
        if (i !== fromno) {
          newrcds.push(rcds[i]);
        }
      }
    }
    temp = jsx.state.login;
    temp.rcds = newrcds;
    return jsx.setState(temp);
  };
  $w.constants = {
    $W_LOGIN_SUCCESS: "$W_LOGIN_SUCCESS"
  };
  $w.actions = {
    logoffClick: function() {
      this.dispatch($c.constants.$C_LOADING);
      return $c.ajaxPostJson("/ajax/logout", "", "application/json", $c.ajaxCallback.bind(this, "", $w.constants.$W_LOGOFF_SUCCESS));
    }
  };
  $w.PageStore = Fluxxor.createStore({
    initialize: function() {
      this.data = {};
    }
  });
  $w.flux = new Fluxxor.Flux();
  $w.pageStore = new $w.PageStore;
  $w.flux.addStore("PAGE", $w.pageStore);
  $w.flux.addActions($w.actions);
  $w.commonStore = new $c.CommonStore;
  $w.flux.addStore("COMMON", $w.commonStore);
  $w.flux.addActions($c.actions);
  $w.rcdStore = new $c.RcdStore;
  $w.flux.addStore("RCD", $w.rcdStore);
  $w.flux.addActions($c.rcdActions);
  rcdStore = $w.flux.store("RCD");
  rcdStore.addTable("login");
  $w.FluxMixin = Fluxxor.FluxMixin(React);
  $w.StoreWatchMixin = Fluxxor.StoreWatchMixin;
  $w.rcdSet = function() {
    var loginTemp, rcdLogin;
    rcdLogin = _.cloneDeep($w.app.state.rcd.login);
    loginTemp = {
      login: $w.app.state.login
    };
    loginTemp.login.rcds = rcdLogin.rcds;
    loginTemp.form = rcdLogin.rcd;
    loginTemp.login.selRow = rcdLogin.selRow;
    return $w.app.setState(loginTemp);
  };
  $w.rcdStore.on("rcdComplete_login", function() {
    return $w.rcdSet();
  });
}).call(this);
