(function() {
  var checkAndCreate;
  checkAndCreate = function(v) {
    if (!(window[v] != null)) {
      return window[v] = {};
    }
  };
  /*
  rsv.js - Really Simple Validation
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  v2.5.3, Nov 1 2014

  This powerful little script lets you add client-side validation to any webform with very little
  work. It includes a number of pre-existing routines for common tasks like validating email
  addresses, numbers, and other field content, and provides a simple mechanism to extend it to
  whatever custom functions you need. For documentation and examples, please visit:
  http://www.benjaminkeen.com/software/rsv

  This script is written by Ben Keen with additional code contributed by Mihai Ionescu and Nathan
  Howard. It is free to distribute, to re-write, spread on your toast - do what ever you want with it!
  */
  checkAndCreate("$v");
  $v.displayType = "alert-all";
  $v.errorTextIntro = "";
  $v.errorJSItemBullet = "";
  $v.customErrorHandler = null;
  $v.onCompleteHandler = null;
  /**
  @param form the name attribute of the form to validate.
  @param rules an array of the validation rules, each rule a string.
  @return mixed returns a boolean (success/failure) for "alert-single" and "alert-all" options, and an
  array of arrays for return
  */
  $v.validate = function(form, rules) {
    var comparison_rule, custom_function, date_flag, errorMessage, errorStr, fieldCount, fieldName, fieldName2, fieldName3, fieldValue, i, isLaterDate, j, lengthRequirements, rangeRequirements, rangeValues, range_or_exact_number, reg_exp, reg_exp_str, requirement, row, rule_string;
    $v.returnHash = [];
    i = 0;
    while (i < rules.length) {
      row = rules[i].replace(/\\,/g, "%%C%%");
      row = row.split(",");
      requirement = row[0];
      fieldName = row[1];
      fieldName2 = void 0;
      fieldName3 = void 0;
      errorMessage = void 0;
      lengthRequirements = void 0;
      date_flag = void 0;
      if (requirement !== "function" && !(form[fieldName] != null)) {
        alert("RSV Error: the field \"" + fieldName + "\" doesn't exist! Please check your form and settings.");
        return false;
      }
      if (row.length === 6) {
        fieldName2 = row[2];
        fieldName3 = row[3];
        date_flag = row[4];
        errorMessage = row[5];
      } else if (row.length === 5) {
        fieldName2 = row[2];
        fieldName3 = row[3];
        errorMessage = row[4];
      } else if (row.length === 4) {
        fieldName2 = row[2];
        errorMessage = row[3];
      } else {
        errorMessage = row[2];
      }
      if (requirement.match("^length")) {
        lengthRequirements = requirement;
        requirement = "length";
      }
      if (requirement.match("^range")) {
        rangeRequirements = requirement;
        requirement = "range";
      }
      fieldValue = form[fieldName];
      switch (requirement) {
        case "required":
          if (!((fieldValue != null) && fieldValue.length > 0)) {
            $v.processError(form[fieldName], errorMessage);
          }
          break;
        case "digits_only":
          if ((fieldValue != null) && fieldValue.match(/\D/)) {
            $v.processError(form[fieldName], errorMessage);
          }
          break;
        case "letters_only":
          if ((fieldValue != null) && fieldValue.match(/[^a-zA-Z]/)) {
            $v.processError(form[fieldName], errorMessage);
          }
          break;
        case "is_alpha":
          if ((fieldValue != null) && fieldValue.match(/\W/)) {
            $v.processError(form[fieldName], errorMessage);
          }
          break;
        case "reg_exp":
          reg_exp_str = fieldName2.replace(/%%C%%/g, ",");
          if (row.length === 5) {
            reg_exp = new RegExp(reg_exp_str, fieldName3);
          } else {
            reg_exp = new RegExp(reg_exp_str);
          }
          if ((fieldValue != null) && !(reg_exp.exec(fieldValue) != null)) {
            $v.processError(form[fieldName], errorMessage);
          }
          break;
        case "length":
          comparison_rule = "";
          rule_string = "";
          if (lengthRequirements.match(/length=/)) {
            comparison_rule = "equal";
            rule_string = lengthRequirements.replace("length=", "");
          } else if (lengthRequirements.match(/length>=/)) {
            comparison_rule = "greater_than_or_equal";
            rule_string = lengthRequirements.replace("length>=", "");
          } else if (lengthRequirements.match(/length>/)) {
            comparison_rule = "greater_than";
            rule_string = lengthRequirements.replace("length>", "");
          } else if (lengthRequirements.match(/length<=/)) {
            comparison_rule = "less_than_or_equal";
            rule_string = lengthRequirements.replace("length<=", "");
          } else if (lengthRequirements.match(/length</)) {
            comparison_rule = "less_than";
            rule_string = lengthRequirements.replace("length<", "");
          }
          switch (comparison_rule) {
            case "greater_than_or_equal":
              if (!(fieldValue.length >= parseInt(rule_string))) {
                $v.processError(form[fieldName], errorMessage);
              }
              break;
            case "greater_than":
              if (!(fieldValue.length > parseInt(rule_string))) {
                $v.processError(form[fieldName], errorMessage);
              }
              break;
            case "less_than_or_equal":
              if (!(fieldValue.length <= parseInt(rule_string))) {
                $v.processError(form[fieldName], errorMessage);
              }
              break;
            case "less_than":
              if (!(fieldValue.length < parseInt(rule_string))) {
                $v.processError(form[fieldName], errorMessage);
              }
              break;
            case "equal":
              range_or_exact_number = rule_string.match(/[^_]+/);
              fieldCount = range_or_exact_number[0].split("-");
              if (fieldCount.length === 2) {
                if (fieldValue.length < parseInt(fieldCount[0]) || fieldValue.length > parseInt(fieldCount[1])) {
                  $v.processError(form[fieldName], errorMessage);
                }
              } else {
                if (fieldValue.length !== parseInt(fieldCount[0])) {
                  $v.processError(form[fieldName], errorMessage);
                }
              }
          }
          break;
        case "valid_email":
          if (!((fieldValue != null) && $v.isValidEmail(fieldValue))) {
            $v.processError(form[fieldName], errorMessage);
          }
          break;
        case "valid_date":
          isLaterDate = false;
          if (date_flag === "later_date") {
            isLaterDate = true;
          } else {
            if (date_flag === "any_date") {
              isLaterDate = false;
            }
          }
          if (!$v.isValidDate(fieldValue, form[fieldName2], form[fieldName3], isLaterDate)) {
            $v.processError(form[fieldName], errorMessage);
          }
          break;
        case "same_as":
          if (fieldValue !== form[fieldName2]) {
            $v.processError(form[fieldName], errorMessage);
          }
          break;
        case "range":
          comparison_rule = "";
          rule_string = "";
          if (rangeRequirements.match(/range=/)) {
            comparison_rule = "equal";
            rule_string = rangeRequirements.replace("range=", "");
          } else if (rangeRequirements.match(/range>=/)) {
            comparison_rule = "greater_than_or_equal";
            rule_string = rangeRequirements.replace("range>=", "");
          } else if (rangeRequirements.match(/range>/)) {
            comparison_rule = "greater_than";
            rule_string = rangeRequirements.replace("range>", "");
          } else if (rangeRequirements.match(/range<=/)) {
            comparison_rule = "less_than_or_equal";
            rule_string = rangeRequirements.replace("range<=", "");
          } else if (rangeRequirements.match(/range</)) {
            comparison_rule = "less_than";
            rule_string = rangeRequirements.replace("range<", "");
          }
          switch (comparison_rule) {
            case "greater_than_or_equal":
              if (!(fieldValue >= Number(rule_string))) {
                v.processError(form[fieldName], errorMessage);
              }
              break;
            case "greater_than":
              if (!(fieldValue > Number(rule_string))) {
                $v.processError(form[fieldName], errorMessage);
              }
              break;
            case "less_than_or_equal":
              if (!(fieldValue <= Number(rule_string))) {
                $v.processError(form[fieldName], errorMessage);
              }
              break;
            case "less_than":
              if (!(fieldValue < Number(rule_string))) {
                $v.processError(form[fieldName], errorMessage);
              }
              break;
            case "equal":
              rangeValues = rule_string.split("-");
              if ((fieldValue < Number(rangeValues[0])) || (fieldValue > Number(rangeValues[1]))) {
                $v.processError(form[fieldName], errorMessage);
              }
          }
          break;
        case "function":
          custom_function = fieldName;
          eval("var result = " + custom_function + "(form)");
          if (result.constructor.toString().indexOf("Array") !== -1) {
            j = 0;
            while (j < result.length) {
              $v.processError(result[j][0], result[j][1]);
              j++;
            }
          }
          break;
        default:
          alert("Unknown requirement flag in validateFields(): " + requirement);
          return false;
      }
      i++;
    }
    if (typeof $v.customErrorHandler === "function") {
      if (!$v.customErrorHandler(form, $v.returnHash)) {
        return false;
      }
    } else if ($v.displayType === "alert-all") {
      if ($v.errorTextIntro.length > 0) {
        errorStr = $v.errorTextIntro + "\n\n";
      } else {
        errorStr = "";
      }
      i = 0;
      while (i < $v.returnHash.length) {
        errorStr += $v.errorJSItemBullet + $v.returnHash[i][1] + "\n";
        i++;
      }
      if ($v.returnHash.length > 0) {
        return errorStr;
      } else {
        return "";
      }
    }
    if (typeof $v.onCompleteHandler === "function") {
      return $v.onCompleteHandler();
    } else {
      return true;
    }
  };
  /**

  @param obj the offending form field
  @param message the error message string
  */
  $v.processError = function(obj, message) {
    message = message.replace(/%%C%%/g, ",");
    return $v.returnHash.push([obj, message]);
  };
  /**
  Tests a string is a valid email. NOT the most elegant function...
  */
  $v.isValidEmail = function(str) {
    var at, dot, lat, lstr, s, str2;
    str2 = str.replace(/^\s*/, "");
    s = str2.replace(/\s*$/, "");
    at = "@";
    dot = ".";
    lat = s.indexOf(at);
    lstr = s.length;
    if (s.indexOf(at) === -1 || (s.indexOf(at) === -1 || s.indexOf(at) === 0 || s.indexOf(at) === lstr) || (s.indexOf(dot) === -1 || s.indexOf(dot) === 0 || s.indexOf(dot) === lstr) || (s.indexOf(at, lat + 1) !== -1) || (s.substring(lat - 1, lat) === dot || s.substring(lat + 1, lat + 2) === dot) || (s.indexOf(dot, lat + 2) === -1) || (s.indexOf(" ") !== -1)) {
      return false;
    }
    return true;
  };
  /**
  Returns true if string parameter is empty or whitespace characters only.
  */
  $v.isWhitespace = function(s) {
    var c, i, whitespaceChars;
    whitespaceChars = " \t\n\r\f";
    if ((!(s != null)) || (s.length === 0)) {
      return true;
    }
    i = 0;
    while (i < s.length) {
      c = s.charAt(i);
      if (whitespaceChars.indexOf(c) === -1) {
        return false;
      }
      i++;
    }
    return true;
  };
  $v.isValidDate = function(month, day, year, isLaterDate) {
    var currDate, currDay, currMonth, currYear, daysInMonth, incomingDate, today;
    daysInMonth = void 0;
    if ((year % 4 === 0) && ((year % 100 !== 0) || (year % 400 === 0))) {
      daysInMonth = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    } else {
      daysInMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    }
    if (!month || !day || !year) {
      return false;
    }
    if (1 > month || month > 12) {
      return false;
    }
    if (year < 0) {
      return false;
    }
    if (1 > day || day > daysInMonth[month - 1]) {
      return false;
    }
    if (isLaterDate) {
      today = new Date();
      currMonth = today.getMonth() + 1;
      currDay = today.getDate();
      currYear = today.getFullYear();
      if (String(currMonth).length === 1) {
        currMonth = "0" + currMonth;
      }
      if (String(currDay).length === 1) {
        currDay = "0" + currDay;
      }
      currDate = String(currYear) + String(currMonth) + String(currDay);
      if (String(month).length === 1) {
        month = "0" + month;
      }
      if (String(day).length === 1) {
        day = "0" + day;
      }
      incomingDate = String(year) + String(month) + String(day);
      if (Number(currDate) > Number(incomingDate)) {
        return false;
      }
    }
    return true;
  };
}).call(this);
