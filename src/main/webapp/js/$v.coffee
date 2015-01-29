

checkAndCreate = (v)->
  window[v] = {} if not window[v]?  

###
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
###





checkAndCreate("$v")
$v.displayType = "alert-all" # "alert-one", "alert-all" or "display-html"
$v.errorTextIntro = ""
$v.errorJSItemBullet = ""
$v.customErrorHandler = null
$v.onCompleteHandler = null

# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

###*
@param form the name attribute of the form to validate.
@param rules an array of the validation rules, each rule a string.
@return mixed returns a boolean (success/failure) for "alert-single" and "alert-all" options, and an
array of arrays for return
###
$v.validate = (form, rules) ->
  $v.returnHash = []
  
  # loop through rules
  i = 0

  while i < rules.length
    
    # split row into component parts (replace any commas with %%C%% - they will be converted back later)
    row = rules[i].replace(/\\,/g, "%%C%%")
    row = row.split(",")
    

    requirement = row[0]
    fieldName = row[1]
    fieldName2 = undefined
    fieldName3 = undefined
    errorMessage = undefined
    lengthRequirements = undefined
    date_flag = undefined
    
    # help the web developer out a little: this is a very common problem
    if requirement isnt "function" and not form[fieldName]?
      alert "RSV Error: the field \"" + fieldName + "\" doesn't exist! Please check your form and settings."
      return false
   
    # depending on the validation test, store the incoming strings for use later...
    if row.length is 6 # valid_date
      fieldName2 = row[2]
      fieldName3 = row[3]
      date_flag = row[4]
      errorMessage = row[5]
    else if row.length is 5 # reg_exp (WITH flags like g, i, m)
      fieldName2 = row[2]
      fieldName3 = row[3]
      errorMessage = row[4]
    else if row.length is 4 # same_as, custom_alpha, reg_exp (without flags like g, i, m)
      fieldName2 = row[2]
      errorMessage = row[3]
    else # everything else!
      errorMessage = row[2]
    
    # if the requirement is "length...", rename requirement to "length" for switch statement
    if requirement.match("^length")
      lengthRequirements = requirement
      requirement = "length"
    
    # if the requirement is "range=...", rename requirement to "range" for switch statement
    if requirement.match("^range")
      rangeRequirements = requirement
      requirement = "range"
    fieldValue=form[fieldName]
    # now, validate whatever is required of the field
    switch requirement
      when "required"
        $v.processError(form[fieldName], errorMessage)  unless fieldValue? and fieldValue.length > 0
      when "digits_only"
        $v.processError(form[fieldName], errorMessage)  if fieldValue? and fieldValue.match(/\D/)
      when "letters_only"
        $v.processError(form[fieldName], errorMessage)  if fieldValue? and fieldValue.match(/[^a-zA-Z]/)
      when "is_alpha"
        $v.processError(form[fieldName], errorMessage)  if fieldValue? and fieldValue.match(/\W/)
      when "reg_exp"
      # Sample rules.push("reg_exp,loginId,^\\d+$,digits_only loginId.");  
        reg_exp_str = fieldName2.replace(/%%C%%/g, ",")
        if row.length is 5
          reg_exp = new RegExp(reg_exp_str, fieldName3)
        else
          reg_exp = new RegExp(reg_exp_str)
        $v.processError(form[fieldName], errorMessage)  if fieldValue? and not reg_exp.exec(fieldValue)?
      when "length"
        comparison_rule = ""
        rule_string = ""
        
        # if-else order is important here: needs to check for >= before >
        if lengthRequirements.match(/length=/)
          comparison_rule = "equal"
          rule_string = lengthRequirements.replace("length=", "")
        else if lengthRequirements.match(/length>=/)
          comparison_rule = "greater_than_or_equal"
          rule_string = lengthRequirements.replace("length>=", "")
        else if lengthRequirements.match(/length>/)
          comparison_rule = "greater_than"
          rule_string = lengthRequirements.replace("length>", "")
        else if lengthRequirements.match(/length<=/)
          comparison_rule = "less_than_or_equal"
          rule_string = lengthRequirements.replace("length<=", "")
        else if lengthRequirements.match(/length</)
          comparison_rule = "less_than"
          rule_string = lengthRequirements.replace("length<", "")
        
        # now perform the appropriate validation
        switch comparison_rule
          when "greater_than_or_equal"
            $v.processError(form[fieldName], errorMessage)  unless fieldValue.length >= parseInt(rule_string)
          when "greater_than"
            $v.processError(form[fieldName], errorMessage)  unless fieldValue.length > parseInt(rule_string)
          when "less_than_or_equal"
            $v.processError(form[fieldName], errorMessage)  unless fieldValue.length <= parseInt(rule_string)
          when "less_than"
            $v.processError(form[fieldName], errorMessage)  unless fieldValue.length < parseInt(rule_string)
          when "equal"
            range_or_exact_number = rule_string.match(/[^_]+/)
            fieldCount = range_or_exact_number[0].split("-")
            
            # if the user supplied two length fields, make sure the field is within that range
            if fieldCount.length is 2
              $v.processError(form[fieldName], errorMessage)  if fieldValue.length < parseInt(fieldCount[0]) or fieldValue.length > parseInt(fieldCount[1])
            
            # otherwise, check it's EXACTLY the size the user specified
            else
              $v.processError(form[fieldName], errorMessage)  unless fieldValue.length is parseInt(fieldCount[0])
      
      # this is also true if field is empty [should be same for digits_only]
      when "valid_email"
        $v.processError(form[fieldName], errorMessage)  unless fieldValue? and $v.isValidEmail(fieldValue)
      when "valid_date"
        isLaterDate = false
        if date_flag is "later_date"
          isLaterDate = true
        else isLaterDate = false  if date_flag is "any_date"
        $v.processError(form[fieldName], errorMessage)  unless $v.isValidDate(fieldValue, form[fieldName2], form[fieldName3], isLaterDate)
      when "same_as"
        $v.processError(form[fieldName], errorMessage)  unless fieldValue is form[fieldName2]
      when "range"
        comparison_rule = ""
        rule_string = ""
        
        # if-else order is important here: needs to check for >= before >
        if rangeRequirements.match(/range=/)
          comparison_rule = "equal"
          rule_string = rangeRequirements.replace("range=", "")
        else if rangeRequirements.match(/range>=/)
          comparison_rule = "greater_than_or_equal"
          rule_string = rangeRequirements.replace("range>=", "")
        else if rangeRequirements.match(/range>/)
          comparison_rule = "greater_than"
          rule_string = rangeRequirements.replace("range>", "")
        else if rangeRequirements.match(/range<=/)
          comparison_rule = "less_than_or_equal"
          rule_string = rangeRequirements.replace("range<=", "")
        else if rangeRequirements.match(/range</)
          comparison_rule = "less_than"
          rule_string = rangeRequirements.replace("range<", "")
        
        # now perform the appropriate validation
        switch comparison_rule
          when "greater_than_or_equal"
            v.processError(form[fieldName], errorMessage)  unless fieldValue >= Number(rule_string)
          when "greater_than"
            $v.processError(form[fieldName], errorMessage)  unless fieldValue > Number(rule_string)
          when "less_than_or_equal"
            $v.processError(form[fieldName], errorMessage)  unless fieldValue <= Number(rule_string)
          when "less_than"
            $v.processError(form[fieldName], errorMessage)  unless fieldValue < Number(rule_string)
          when "equal"
            rangeValues = rule_string.split("-")
            
            # if the user supplied two length fields, make sure the field is within that range
            $v.processError(form[fieldName], errorMessage)  if (fieldValue < Number(rangeValues[0])) or (fieldValue > Number(rangeValues[1]))
      when "function"
        custom_function = fieldName
        eval "var result = " + custom_function + "(form)"
        unless result.constructor.toString().indexOf("Array") is -1
          j = 0

          while j < result.length
            $v.processError(result[j][0], result[j][1])
            j++
      else
        alert "Unknown requirement flag in validateFields(): " + requirement
        return false
    i++
  
  # if the user has defined a custom event handler, pass the information to it
  if typeof $v.customErrorHandler is "function"
    return false  unless $v.customErrorHandler(form, $v.returnHash)
  
  # if the user has chosen "alert-all" or "return-errors", perform the appropriate action
  else if $v.displayType is "alert-all"
    if $v.errorTextIntro.length > 0
      errorStr = $v.errorTextIntro + "\n\n"
    else
      errorStr = ""
    i = 0

    while i < $v.returnHash.length
      errorStr += $v.errorJSItemBullet + $v.returnHash[i][1] + "\n"
      
      # apply the error CSS class (if defined) all the fields and place the focus on the first
      # offending field
      #$v.styleField $v.returnHash[i][0], i is 0
      i++
    if $v.returnHash.length > 0
      #Shimura Edit
      return errorStr
      #return false
    else
      return ""
  # finally, if the user has specified a custom onCompleteHandler, use it
  if typeof $v.onCompleteHandler is "function"
    $v.onCompleteHandler()
  else
    true


###*

@param obj the offending form field
@param message the error message string
###
$v.processError = (obj, message) ->
  message = message.replace(/%%C%%/g, ",")
  $v.returnHash.push [
    obj
    message
  ]




###*
Tests a string is a valid email. NOT the most elegant function...
###
$v.isValidEmail = (str) ->
  str2 = str.replace(/^\s*/, "")
  s = str2.replace(/\s*$/, "")
  at = "@"
  dot = "."
  lat = s.indexOf(at)
  lstr = s.length
  return false  if s.indexOf(at) is -1 or (s.indexOf(at) is -1 or s.indexOf(at) is 0 or s.indexOf(at) is lstr) or (s.indexOf(dot) is -1 or s.indexOf(dot) is 0 or s.indexOf(dot) is lstr) or (s.indexOf(at, (lat + 1)) isnt -1) or (s.substring(lat - 1, lat) is dot or s.substring(lat + 1, lat + 2) is dot) or (s.indexOf(dot, (lat + 2)) is -1) or (s.indexOf(" ") isnt -1)
  true


###*
Returns true if string parameter is empty or whitespace characters only.
###
$v.isWhitespace = (s) ->
  whitespaceChars = " \t\n\r\f"
  return true  if (not (s?)) or (s.length is 0)
  i = 0

  while i < s.length
    c = s.charAt(i)
    return false  if whitespaceChars.indexOf(c) is -1
    i++
  true


#
# * Checks incoming date is valid. If any of the date parameters fail, it returns a string
# * message denoting the problem.
# *
# * @param month an integer between 1 and 12
# * @param day an integer between 1 and 31 (depending on month)
# * @year a 4-digit integer value
# * @isLaterDate a boolean value. If true, the function verifies the date being passed in is LATER
# *   than the current date
# 
$v.isValidDate = (month, day, year, isLaterDate) ->
  
  # depending on the year, calculate the number of days in the month
  daysInMonth = undefined
  if (year % 4 is 0) and ((year % 100 isnt 0) or (year % 400 is 0)) # LEAP YEAR
    daysInMonth = [
      31
      29
      31
      30
      31
      30
      31
      31
      30
      31
      30
      31
    ]
  else
    daysInMonth = [
      31
      28
      31
      30
      31
      30
      31
      31
      30
      31
      30
      31
    ]
  
  # check the incoming month and year are valid
  return false  if not month or not day or not year
  return false  if 1 > month or month > 12
  return false  if year < 0
  return false  if 1 > day or day > daysInMonth[month - 1]
  
  # if required, verify the incoming date is LATER than the current date.
  if isLaterDate
    
    # get current date
    today = new Date()
    currMonth = today.getMonth() + 1 # since returns 0-11
    currDay = today.getDate()
    currYear = today.getFullYear()
    
    # zero-pad today's month & day
    currMonth = "0" + currMonth  if String(currMonth).length is 1
    currDay = "0" + currDay  if String(currDay).length is 1
    currDate = String(currYear) + String(currMonth) + String(currDay)
    
    # zero-pad incoming month & day
    month = "0" + month  if String(month).length is 1
    day = "0" + day  if String(day).length is 1
    incomingDate = String(year) + String(month) + String(day)
    return false  if Number(currDate) > Number(incomingDate)
  true

