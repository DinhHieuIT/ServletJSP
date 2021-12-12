<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
  <%
 HttpSession ss = request.getSession();
 String username = (String) ss.getAttribute("nameloged");
 String path = request.getContextPath();
 
  if(username != null){
	  out.print(username);
	  out.print("<a href='" + path + "/logout'>Logout</a>");
  }else{
	  out.print("<a href='" + path + "/login'>Login</a>");
  }
  
  
  
  
  %>
</body>
</html>