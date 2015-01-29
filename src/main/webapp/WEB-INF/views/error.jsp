  <% 	
  		String errmsg =(String)request.getAttribute("__errmsg");
  %>
<html>
<body>

		<h4>Error:<% out.print(errmsg); %></h4>

 
</body>
</html>
