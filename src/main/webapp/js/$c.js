(function() {
  var LoginClient, checkAndCreate;
  checkAndCreate = function(v) {
    if (!(window[v] != null)) {
      return window[v] = {};
    }
  };
  checkAndCreate("$c");
  $c.checkAndCreate = checkAndCreate;
  $c.handleChange = function(jsx, name, value) {
    var change, names, temp;
    change = {};
    names = name.split("#");
    if (names.length === 1) {
      change[name] = value;
    }
    if (names.length === 2) {
      temp = jsx.state[names[0]];
      temp[names[1]] = value;
      change[names[0]] = temp;
    }
    return jsx.setState(change);
  };
  $c.constants = {
    $C_ALERT_SHOW: "$C_ALERT_SHOW",
    $C_ALERT_HIDE: "$C_ALERT_HIDE",
    $C_DELETE_CFM_SHOW: "$C_DELETE_CFM_SHOW",
    $C_DELETE_CFM_HIDE: "$C_DELETE_CFM_HIDE",
    $C_LOADING: "$C_LOADING",
    $C_LOADED: "$C_LOADED"
  };
  $c.actions = {
    $c_alertShow: function(message) {
      return this.dispatch($c.constants.$C_ALERT_SHOW, message);
    },
    $c_alertHide: function() {
      return this.dispatch($c.constants.$C_ALERT_HIDE);
    },
    $c_deleteCfmShow: function() {
      return this.dispatch($c.constants.$C_DELETE_CFM_SHOW);
    },
    $c_deleteCfmHide: function() {
      return this.dispatch($c.constants.$C_DELETE_CFM_HIDE);
    }
  };
  LoginClient = {
    login: function(logbtn_value, success, failure) {
      return $.post;
    }
  };
  $c.CommonStore = Fluxxor.createStore({
    initialize: function() {
      this.data = {
        alert: {
          message: "",
          isShow: false
        },
        deleteCfm: {
          isShow: false
        },
        loading: false
      };
      this.bindActions($c.constants.$C_ALERT_SHOW, this.onAlertShow, $c.constants.$C_ALERT_HIDE, this.onAlertHide, $c.constants.$C_DELETE_CFM_SHOW, this.onDeleteCfmShow, $c.constants.$C_DELETE_CFM_HIDE, this.onDeleteCfmHide, $c.constants.$C_LOADING, this.onLoading, $c.constants.$C_LOADED, this.onLoaded);
    },
    onAlertShow: function(message) {
      this.data.alert.message = message;
      this.data.alert.isShow = true;
      this.emit("change");
    },
    onAlertHide: function() {
      this.data.alert.isShow = false;
      this.emit("change");
    },
    onDeleteCfmShow: function() {
      this.data.deleteCfm.isShow = true;
      this.emit("change");
    },
    onDeleteCfmHide: function() {
      this.data.deleteCfm.isShow = false;
      this.emit("change");
    },
    onLoading: function() {
      this.data.loading = true;
      this.emit("change");
    },
    onLoaded: function() {
      this.data.loading = false;
      this.emit("change");
    }
  });
  $c.ajaxPost = function(url, data, contentype, callback) {
    return $.ajax({
      type: "POST",
      url: $c_contextpath + url,
      data: data,
      contentType: contentype
    }).always(callback);
  };
  $c.ajaxPostJson = function(url, param, contentype, callback) {
    var data;
    data = JSON.stringify(param);
    return $c.ajaxPost(url, data, contentype, callback);
  };
  $c.getXhr = function(response, payload) {
    if (typeof payload === "string") {
      return response;
    }
    return payload;
  };
  $c.getServerError = function(xhr) {
    if (xhr.status === 200) {
      return "";
    }
    if (xhr.status === 0) {
      return "Internet or Server error";
    }
    return "Server error status=" + xhr.status + " " + xhr.statusText;
  };
  $c.getResponse = function(xhr) {
    var res;
    if (typeof xhr.responseJSON === "object") {
      return xhr.responseJSON.response;
    }
    res = $.parseJSON(xhr.responseText);
    return res.response;
  };
  $c.getAppError = function(xhr) {
    var response;
    response = $c.getResponse(xhr);
    if (response != null) {
      if (response.status < 0) {
        return response.data;
      }
    }
    return "";
  };
  $c.getServerOrAppError = function(xhr) {
    var error;
    error = $c.getServerError(xhr);
    if (error > "") {
      return error;
    }
    return $c.getAppError(xhr);
  };
  $c.ajaxCallback = function(context, successDispatch, ajaxresponse, textStatus, payload) {
    var error, res, response, xhr;
    this.dispatch($c.constants.$C_LOADED);
    xhr = $c.getXhr(ajaxresponse, payload);
    error = $c.getServerOrAppError(xhr);
    if (error > "") {
      this.dispatch($c.constants.$C_ALERT_SHOW, error);
      return;
    }
    response = $c.getResponse(xhr);
    res = {
      context: context,
      response: response
    };
    return this.dispatch(successDispatch, res);
  };
  $c.createCriteria = function(form, fields) {
    var criteria, field, _i, _len;
    criteria = [];
    for (_i = 0, _len = fields.length; _i < _len; _i++) {
      field = fields[_i];
      criteria.push({
        fieldName: field,
        operator: form[field],
        start: form[field + "_s"],
        end: form[field + "_e"]
      });
    }
    return criteria;
  };
  $c.rcdConstants = {
    $C_RCD_FETCH_SUCCESS: "$C_RCD_FETCH_SUCCESS",
    $C_RCD_ADD_SUCCESS: "$C_RCD_ADD_SUCCESS",
    $C_RCD_UPDATE_SUCCESS: "$C_RCD_UPDATE_SUCCESS",
    $C_RCD_DELETE_SUCCESS: "$C_RCD_DELETE_SUCCESS",
    $C_RCD_TRANSACTIONS_SUCCESS: "$C_RCD_TRANSACTIONS_SUCCESS"
  };
  $c.rcdActions = {
    $c_rcd_fetch: function(rcdData, form, table, criteria) {
      var context, params;
      params = {
        operationType: "fetch",
        data: {
          criteria: criteria
        }
      };
      context = {
        rcdData: rcdData,
        table: table,
        action: "fetch"
      };
      this.dispatch($c.constants.$C_LOADING);
      return $c.ajaxPostJson(rcdData.url, params, "application/json", $c.ajaxCallback.bind(this, context, $c.rcdConstants.$C_RCD_FETCH_SUCCESS));
    },
    $c_rcd_update: function(rcdData, form, table) {
      var context, dispachAction, operationType, params;
      if (form.id === "") {
        dispachAction = $c.rcdConstants.$C_RCD_ADD_SUCCESS;
        operationType = "add";
      } else {
        dispachAction = $c.rcdConstants.$C_RCD_UPDATE_SUCCESS;
        operationType = "update";
      }
      params = {
        operationType: operationType,
        data: form
      };
      context = {
        rcdData: rcdData,
        table: table,
        action: "update"
      };
      this.dispatch($c.constants.$C_LOADING);
      return $c.ajaxPostJson(rcdData.url, params, "application/json", $c.ajaxCallback.bind(this, context, dispachAction));
    },
    $c_rcd_delete: function(rcdData, form, table) {
      var context, params;
      params = {
        operationType: "remove",
        data: form.id
      };
      context = {
        rcdData: rcdData,
        table: table,
        action: "remove"
      };
      this.dispatch($c.constants.$C_LOADING);
      return $c.ajaxPostJson(rcdData.url, params, "application/json", $c.ajaxCallback.bind(this, context, $c.rcdConstants.$C_RCD_DELETE_SUCCESS));
    },
    $c_rcd_delete_id_blank: function() {
      return this.dispatch($c.constants.$C_ALERT_SHOW, "レコードが選択されていません");
    },
    $c_rcd_transaction: function(rcdData, params, table) {
      var context;
      context = {
        rcdData: rcdData,
        table: table,
        action: "remove"
      };
      this.dispatch($c.constants.$C_LOADING);
      return $c.ajaxPostJson(rcdData.url, params, "application/json", $c.ajaxCallback.bind(this, context, $c.rcdConstants.$C_RCD_TRANSACTIONS_SUCCESS));
    }
  };
  $c.RcdStore = Fluxxor.createStore({
    initialize: function() {
      this.data = {};
      this.bindActions($c.rcdConstants.$C_RCD_FETCH_SUCCESS, this.onRcdFetchSuccess, $c.rcdConstants.$C_RCD_ADD_SUCCESS, this.onRcdAddSuccess, $c.rcdConstants.$C_RCD_UPDATE_SUCCESS, this.onRcdUpdateSuccess, $c.rcdConstants.$C_RCD_DELETE_SUCCESS, this.onRcdDeleteSuccess, $c.rcdConstants.$C_RCD_TRANSACTIONS_SUCCESS, this.onRcdTransactionsSuccess);
    },
    onRcdFetchSuccess: function(res) {
      var context, rcdData, response, table;
      context = res.context;
      response = res.response;
      table = context.table;
      rcdData = context.rcdData;
      this.data[table].rcds = response.data;
      this.data[table].rcd = rcdData.blank;
      this.data[table].selRow = -1;
      this.emit("change");
      this.emit("rcdComplete_" + table);
    },
    onRcdAddSuccess: function(res) {
      var context, rcdData, response, table;
      context = res.context;
      response = res.response;
      table = context.table;
      rcdData = context.rcdData;
      this.data[table].rcds = _.cloneDeep(rcdData.rcds);
      this.data[table].rcd = response.data;
      this.data[table].selRow = this.data[table].rcds.length;
      this.data[table].rcds.push(response.data);
      this.emit("change");
      this.emit("rcdComplete_" + table);
    },
    onRcdUpdateSuccess: function(res) {
      var context, i, rcd, rcdData, response, table, _len, _ref;
      context = res.context;
      response = res.response;
      table = context.table;
      rcdData = context.rcdData;
      this.data[table].rcds = _.cloneDeep(rcdData.rcds);
      this.data[table].selRow = rcdData.selRow;
      this.data[table].rcd = response.data;
      _ref = this.data[table].rcds;
      for (i = 0, _len = _ref.length; i < _len; i++) {
        rcd = _ref[i];
        if (Number(rcd.id) === Number(response.data.id)) {
          this.data[table].rcds[i] = response.data;
        }
      }
      this.emit("change");
      this.emit("rcdComplete_" + table);
    },
    onRcdDeleteSuccess: function(res) {
      var context, i, newData, rcd, rcdData, response, table, _len, _ref;
      context = res.context;
      response = res.response;
      table = context.table;
      rcdData = context.rcdData;
      this.data[table].rcds = _.cloneDeep(rcdData.rcds);
      newData = [];
      _ref = this.data[table].rcds;
      for (i = 0, _len = _ref.length; i < _len; i++) {
        rcd = _ref[i];
        if (Number(rcd.id) !== Number(response.data.id)) {
          newData.push(rcd);
        }
      }
      this.data[table].rcds = newData;
      this.data[table].rcd = rcdData.blank;
      this.data[table].selRow = -1;
      this.emit("change");
      this.emit("rcdComplete_" + table);
    },
    onRcdTransactionsSuccess: function(res) {
      var context, i, id, newrcd, old, rcd, rcdData, response, table, _len, _ref;
      context = res.context;
      response = res.response;
      table = context.table;
      rcdData = context.rcdData;
      this.data[table].rcds = _.cloneDeep(rcdData.rcds);
      _.remove(this.data[table].rcds, function(rcd) {
        return rcd.id === "";
      });
      _ref = response.data;
      for (i = 0, _len = _ref.length; i < _len; i++) {
        rcd = _ref[i];
        newrcd = rcd.response.data;
        id = newrcd.id;
        old = $c.getRecordNoById(this.data[table].rcds, id);
        if (old === -1) {
          this.data[table].rcds.push(newrcd);
        } else {
          this.data[table].rcds[old] = newrcd;
        }
      }
      this.data[table].rcd = rcdData.blank;
      this.data[table].selRow = -1;
      this.emit("change");
      this.emit("rcdComplete_" + table);
    },
    addTable: function(table) {
      var template;
      template = {
        rcds: [],
        rcd: {},
        selRow: -1
      };
      return this.data[table] = template;
    }
  });
  $c.isNull = function(value) {
    if (typeof value === "undefined" || value === null) {
      return true;
    }
    if (value.length === 0) {
      return true;
    }
  };
  $c.dirtyCheck = function(record, oldRecord) {
    var dirty, prop;
    dirty = false;
    for (prop in record) {
      if ($c.isNull(oldRecord[prop])) {
        if (!$c.isNull(record[prop])) {
          dirty = true;
        }
      } else {
        if (record[prop] !== oldRecord[prop]) {
          dirty = true;
        }
      }
    }
    return dirty;
  };
  $c.getRecordById = function(records, id) {
    var rcd, _i, _len;
    for (_i = 0, _len = records.length; _i < _len; _i++) {
      rcd = records[_i];
      if (rcd.id === id) {
        return rcd;
      }
    }
    return null;
  };
  $c.getRecordNoById = function(records, id) {
    var i, rcd, _len;
    for (i = 0, _len = records.length; i < _len; i++) {
      rcd = records[i];
      if (rcd.id === id) {
        return i;
      }
    }
    return -1;
  };
  $c.totalW = function(cw) {
    var length, v;
    length = 0;
    for (v in cw) {
      length = length + cw[v];
    }
    return length;
  };
  $c.stringOption = [
    {
      value: "",
      label: ""
    }, {
      value: "=",
      label: "="
    }, {
      value: "between",
      label: "間"
    }, {
      value: "starts with",
      label: "先頭"
    }, {
      value: "contains",
      label: "含む"
    }, {
      value: ">",
      label: ">"
    }, {
      value: ">=",
      label: ">="
    }, {
      value: "<",
      label: "<"
    }, {
      value: "<=",
      label: "<="
    }, {
      value: "<>",
      label: "<>"
    }, {
      value: "like",
      label: "%?指定"
    }
  ];
}).call(this);
