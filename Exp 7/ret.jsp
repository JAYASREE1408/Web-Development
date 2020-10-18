<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "deepa";
String userid = "root";
String password = "deepa@2000";
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
<body>

<table border="1">
<tr>
<td>NAME</td>
<td>PASS</td>
<td>EMAIL</td>
<td>COUNTRY</td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String z=request.getParameter("userName");
String sql ="select * from registeruser where NAME='"+z+"'";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("NAME") %></td>
<td><%=resultSet.getString("PASS") %></td>
<td><%=resultSet.getString("EMAIL") %></td>
<td><%=resultSet.getString("COUNTRY") %></td>
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