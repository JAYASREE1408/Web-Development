<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "students";
String userid = "root";
String password = "password";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body align="center" bgcolor="aquamarine">
<h1>RETRIEVED DATA</h1>
<table align="center" bgcolor="grey" style="color:white; padding:2px"border="2">
<tr>
<td>NAME</td>
<td>REGISTERNO</td>
<td>YEAR</td>
<td>MOBILE</td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String z=request.getParameter("Name");
String sql ="select * from IT where Name='"+z+"'";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("NAME") %></td>
<td><%=resultSet.getString("REGISTERNO") %></td>
<td><%=resultSet.getString("YEAR") %></td>
<td><%=resultSet.getString("MOBILE") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>