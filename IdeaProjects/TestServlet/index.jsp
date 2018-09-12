<html>
  <head><title>Index JSP Page</title></head>
<body>
  <p>This is a JSP page</p>

  <%
    out.println("Your IP address: " + request.getRemoteAddr());
  %>

</body>
</html>
