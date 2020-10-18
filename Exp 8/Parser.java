import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.*;


public class Parser extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>1818128_Data Fetch</title>");
        out.println("</head>");
        out.println("<body style='background-color:black;color:#00fff7;font-size: 30px;padding: 30px;'>");
        out.print("<h1 style='color:red;text-shadow: 2px 1px white;'>Information about the Student </h1>");
            DomParser parser = new DomParser();
            String s[] = parser.searchStudent(request.getParameter("data"));
            if(s!=null){
                out.print("<h1 style='color:red;text-shadow: 2px 1px white;'>"+s[0]+":</h1>");
                out.println("<ul>");
                out.println("<li><h3>Roll Number :" + s[0] + "</h3></li>");
                out.println("<li><h3>First Name :" + s[1] + "</h3></li>");
                out.println("<li><h3>Last Name :" + s[2] + "</h3></li>");
                out.println("<li><h3>Department :" + s[3] + "</h3></li>");
                out.println("<li><h3>CGPA :" + s[4] + "</h3></li>");
                out.println("</ul>");
            }
            else{
                out.println("<h3>There is no data available for this student !</h3>");
            }
        out.println("</body>");
        out.println("<html>");
    }
}
    
