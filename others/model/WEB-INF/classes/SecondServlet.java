import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SecondServlet extends HttpServlet {
 public void doGet(HttpServletRequest request, 
    HttpServletResponse response){
    try{
       response.setContentType("text/html");
       PrintWriter pwriter = response.getWriter();
 
       //Reading cookies
       Cookie c[]=request.getCookies(); 
       //Displaying User name value from cookie
       pwriter.print("<br>Name: "+c[1].getValue()); 
       //Displaying user password value from cookie
       pwriter.print("");
       pwriter.print("<br>Password: "+c[2].getValue());
 
       pwriter.close();
    }catch(Exception exp){
       System.out.println(exp);
     }
  }
}