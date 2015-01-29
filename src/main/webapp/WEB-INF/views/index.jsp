<html xmlns="http://www.w3.org/1999/xhtml" lang="ja" xml:lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Content-Style-Type" content="text/css" />
  <meta http-equiv="Content-Script-Type" content="text/JavaScript" />
  <%@ page import="java.util.HashMap"  %>
  <%@ page import="java.util.ArrayList"  %>
  <%@ page import="org.apache.commons.lang.*"  %>   
  <% 	
      ArrayList jscmd = (ArrayList)((HashMap)request.getAttribute("__jscss")).get("jscmd");
      ArrayList jslib =(ArrayList)((HashMap)request.getAttribute("__jscss")).get("jslib");
  		ArrayList js =(ArrayList)((HashMap)request.getAttribute("__jscss")).get("js");
  		ArrayList css =(ArrayList)((HashMap)request.getAttribute("__jscss")).get("css");
  		String title =(String)((HashMap)request.getAttribute("__jscss")).get("title");
  		String jscmdh =(String)((HashMap)request.getAttribute("__jscss")).get("jscmdh");
  %>


  <script><% out.print(jscmdh); %></script>
 
  <% for(Object s:jslib) { %>
  	<script src=<% out.print(s); %>></script> 
  <% } %>
   <script>
  <% for(Object s:jscmd) { %>
  <% out.print(s); %>
  <% } %>
  </script>
    <% for(Object s:css) { %>
  	<LINK rel="stylesheet" href="<% out.print(s); %>">
  <% } %>  
  <title><% out.print(title); %></title>
</head>
<body>
    <div id="content"></div>
  <% for(Object s:js) { %>
  	<script src=<% out.print(s); %>></script> 
  <% } %>
</body>
</html>
