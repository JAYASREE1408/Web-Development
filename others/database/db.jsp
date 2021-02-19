<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>


<%
String n=request.getParameter("Name");  
String p=request.getParameter("RegisterNo");  
String e=request.getParameter("year");  
String c=request.getParameter("mobile"); 
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/students","root","password");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into IT values(?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
ps.setString(4,c);  
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");    
          
}catch (Exception e2) {System.out.println(e2);}    
%>