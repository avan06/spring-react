(function() {
  var rcdStore;
  $c.checkAndCreate("$w");
  $w.handleChange = function(jsx, e) {
    return $c.handleChange(jsx, e.target.name, e.target.value);
  };
  $w.handleClick = function(jsx, e, tab) {
    var ids, logintemp, name, selRow, tabkey;
    name = e.target.name;
    if (name === "tabselect") {
      tabkey = {
        tabkey: tab
      };
      jsx.setState(tabkey);
      return;
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
    if (name === "btnNew") {
      $w.formClear(jsx);
    }
    if (name === "btnSearch") {
      $w.formSearch(jsx);
    }
    if (name === "btnUpdate") {
      $w.formUpdate(jsx);
    }
    if (name === "btnDelete") {
      $w.formDelete(jsx);
      ids = [];
    }
    if (typeof e.target.id === "undefined") {
      return;
    }
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
      return jsx.setState(logintemp);
    }
  };
  $w.formSearch = function(jsx) {
    var criteria;
    criteria = $c.createCriteria(jsx.state.search, ["loginId", "name"]);
    return $w.flux.actions.$c_rcd_fetch(jsx.state.login, jsx.state.form, "login", criteria);
  };
  $w.formUpdate = function(jsx) {
    var form, res, rules;
    form = jsx.state.form;
    res = "";
    if (form.id === "") {
      rules = [];
      rules.push("required,loginId,Login IDは必須項目です");
      rules.push("required,name,氏名は必須項目です");
      rules.push("required,password,パスワードは必須項目です");
      rules.push("required,passwordcfm,パスワード（確認）は必須項目です");
      rules.push("same_as,password,passwordcfm,パスワードとパスワード（確認）が一致しません");
      res = $v.validate(form, rules);
    } else {
      rules = [];
      rules.push("required,loginId,Login IDは必須項目です");
      rules.push("required,name,氏名は必須項目です");
      rules.push("function,$w.formUpdateCheck");
      res = $v.validate(form, rules);
    }
    if (res.length > 0) {
      $w.flux.actions.$c_alertShow(res);
      return;
    }
    return $w.flux.actions.$c_rcd_update(jsx.state.login, jsx.state.form, "login");
  };
  $w.formDelete = function(jsx) {
    if (jsx.state.form.id === "") {
      $w.flux.actions.$c_rcd_delete_id_blank();
      return;
    }
    return $w.flux.actions.$c_deleteCfmShow();
  };
  $w.formDeleteCfm = function(jsx) {
    return $w.flux.actions.$c_rcd_delete(jsx.state.login, jsx.state.form, "login");
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
  $w.rcdStore.on("rcdComplete_login", function() {
    var loginTemp, rcdLogin;
    rcdLogin = _.cloneDeep($w.app.state.rcd.login);
    loginTemp = {
      login: $w.app.state.login
    };
    loginTemp.login.rcds = rcdLogin.rcds;
    loginTemp.form = rcdLogin.rcd;
    loginTemp.login.selRow = rcdLogin.selRow;
    return $w.app.setState(loginTemp);
  });
}).call(this);
