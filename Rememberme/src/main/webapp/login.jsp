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
String username="", password="", remember="";
Cookie[] cookies = request.getCookies();
if(cookies != null){
	for (Cookie cook : cookies){
		if(cook.getName().equals("cookiename")){
			username = cook.getValue();
		}else if(cook.getName().equals("cookiepass")){
			password = cook.getValue();
		}else if(cook.getName().equals("cookieremember")){
			remember = cook.getValue();
		}
	}
}


%>

${message1}
${message2}
<form action="${pageContext.request.contextPath}/login" method="post">

<div>
Username: <input name="username" value="<%=username %>"/>
</div>
<div>
Password: <input type="password" name="password" value="<%=password %>" />
</div>
<div>
Remember me: <input type="checkbox" name="remember" value="1" 
<%= "1".equals(remember) ? "checked='/checked'" : "" %> />
</div>
<div>
<input type="submit" name="Login" />
</div>


</form>
</body>
</html>