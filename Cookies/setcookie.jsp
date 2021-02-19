<%@ page language="java" import="java.util.*"%>
<%
String username=request.getParameter("username");
if(username==null) username="";


Date now = new Date();
String timestamp = now.toString();
Cookie cookie = new Cookie ("username",username);
cookie.setMaxAge(365 * 24 * 60 * 60);
response.addCookie(cookie);

%>

<html>
<head>
<title>Cookie Saved</title>
</head>
<body>
<p><a href="showcookievalue.jsp">Next Page to view the cookie value</a><p>

</body>