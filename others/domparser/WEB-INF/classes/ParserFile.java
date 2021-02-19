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
public class ParserFile extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>STUDENT INFORMATION</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"black\">");
        out.println("<div style='font-family:Comic Sans MS, Comic Sans, cursive;font-stretch: extra-condensed;font-weight: 300;font-style: italic;text-align:center;color:white;position: absolute;top: 50%;left: 50%;margin-right: -50%;transform: translate(-50%, -50%)'>");
            DomParser parser = new DomParser();
            String s[] = parser.searchStudent(request.getParameter("data"));
            if(s != null){
                out.println("<h1><span style='color: red'><u>Roll Number :" + s[0] + "</u></span></h1>");
                out.println("<p><h2>First Name :" + s[1] + "</h2></p>");
                out.println("<p><h2>Last Name :" + s[2] + "</h2></p>");
                out.println("<p><h2>Year of study :" + s[3] + "</h2></p>");
                out.println("<p><h2>CGPA :" + s[4] + "</h2></p>");
            }
            else{
                out.println("<h1>No Data Available About that Student!!</h1>");
            }
        out.println("</div>");
        out.println("</body>");
        out.println("<html>");
    }
}
    
