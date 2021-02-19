<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import ="java.lang.Class" %>
<%

    String carname = request.getParameter("carname");
    String carbrand = request.getParameter("carbrand");
    String mileage = request.getParameter("mileage");
    String year = request.getParameter("year");

    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
        PreparedStatement ps = conn.prepareStatement("insert into cardetails (carbrand,carname,mileage,year) values (?,?,?,?); ");
        
        ps.setString(1,carbrand);
        ps.setString(2,carname);
        ps.setString(3,mileage);
        ps.setString(4,year);

        int x = ps.executeUpdate();
        

%>
<!DOCTYPE html>
<head>
    <title>Registration Successfull !</title>
</head>
<body>
    <div class="container">

<% 
    if(x>0)
        {
%>

    <h2>Registration Successfull!</h2>

    
<% 
        }
        else {

%>

    <h2>An Eror Occurred</h2>

<% 

        }
        }catch(Exception e){
        out.println(e);
    }

%>

    
    </div>
</body>



