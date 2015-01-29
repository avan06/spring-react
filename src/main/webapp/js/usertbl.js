(function() {
  var rcdStore;
  $c.checkAndCreate("$w");
  $w.handleChange = function(jsx, e) {
    return $c.handleChange(jsx, e.target.name, e.target.value);
  };
  $w.handleClick = function(jsx, e) {
    var ids, name, selRow, temp;
    name = e.target.name;
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
    }
    if (typeof e.target.id === "undefined") {
      return;
    }
    ids = e.target.id.split("#");
    if (ids[0] === "row") {
      temp = {
        usertbl: jsx.state.usertbl
      };
      selRow = Number(ids[2]);
      temp.usertbl.selRow = selRow;
      temp.form = _.cloneDeep(temp.usertbl.rcds[selRow]);
      temp.form.password = "";
      temp.form.passwordcfm = "";
      return jsx.setState(temp);
    }
  };
  $w.formSearch = function(jsx) {
    var criteria;
    criteria = $c.createCriteria(jsx.state.search, ["tableName", "key1"]);
    return $w.flux.actions.$c_rcd_fetch(jsx.state.usertbl, jsx.state.form, "usertbl", criteria);
  };
  $w.formUpdate = function(jsx) {
    var form, res, rules;
    form = jsx.state.form;
    res = "";
    if (form.id === "") {
      rules = [];
    }
    if (res.length > 0) {
      $w.flux.actions.$c_alertShow(res);
      return;
    }
    return $w.flux.actions.$c_rcd_update(jsx.state.usertbl, jsx.state.form, "usertbl");
  };
  $w.formDelete = function(jsx) {
    if (jsx.state.form.id === "") {
      $w.flux.actions.$c_rcd_delete_id_blank();
      return;
    }
    return $w.flux.actions.$c_deleteCfmShow();
  };
  $w.formDeleteCfm = function(jsx) {
    return $w.flux.actions.$c_rcd_delete(jsx.state.usertbl, jsx.state.form, "usertbl");
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
      form: _.cloneDeep(jsx.state.usertbl.blank)
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
  rcdStore.addTable("usertbl");
  $w.FluxMixin = Fluxxor.FluxMixin(React);
  $w.StoreWatchMixin = Fluxxor.StoreWatchMixin;
  $w.fix = function() {
    return $('#tableusertbl').tablefix({
      width: 900,
      height: 300,
      fixRows: 1
    });
  };
  $w.rcdStore.on("rcdComplete_usertbl", function() {
    var rcdTemp, temp;
    rcdTemp = _.cloneDeep($w.app.state.rcd.usertbl);
    temp = {
      usertbl: $w.app.state.usertbl
    };
    temp.usertbl.rcds = rcdTemp.rcds;
    temp.form = rcdTemp.rcd;
    temp.usertbl.selRow = rcdTemp.selRow;
    return $w.app.setState(temp);
  });
  $w.getDom = function(refname) {
    return $w.app.refs[refname].getDOMNode();
  };
  $w.scroll = function() {
    return $w.getDom("tableHead").scrollLeft = $w.getDom("tableBody").scrollLeft;
  };
  $w.onscroll = function() {
    return $w.getDom("tableBody").onscroll = $w.scroll;
  };
}).call(this);
