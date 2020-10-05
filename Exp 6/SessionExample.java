import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import java.util.*; 

public class SessionExample extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException,ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<head>");
        out.println("<title>1818128_SESSION</title>");
        out.println("</head>");
        out.println("<body style='background-image: linear-gradient(to bottom right,#038f8f , white,#038f8f)'>");
     
        HttpSession session = request.getSession();
        Integer c = (Integer)session.getAttribute("count");
        if(session.isNew())
        {
            
            String dataName = request.getParameter("uname");
            c = 1;
            if (dataName != null && dataName.length() > 0){
                session.setAttribute("name", dataName);
            }
            out.println("<h1 style='text-align:center;box-shadow: 2px 2px 2px 2px #00fcfc;background:black;color:white;position: absolute;top: 40%;left: 50%;border:2px solid #00fcfc;font-style:italic;padding:20px;border-radius:40px;text-shadow:3px 2px 3px #00fcfc;margin-right: -50%;transform: translate(-50%, -50%);'>");
            out.println("This is the first time the user requests this servlet");
            out.println("</h1>");
            session.setAttribute("count",c);
        }
        else
        {
            out.println("<h1 style='text-align:center;box-shadow: 2px 2px 2px 2px #00fcfc;background:black;color:white;position: absolute;top: 40%;left: 50%;border:2px solid #00fcfc;font-style:italic;padding:20px;border-radius:40px;text-shadow:3px 2px 3px #00fcfc;margin-right: -50%;transform: translate(-50%, -50%);'>");
            out.println(session.getAttribute("name"));
            c++;
            out.println("The user has visited this servlet," + c + " times");
            session.setAttribute("count",c);
            out.println("</h1>");
        }
        //print session info
        out.println("</body>");
        out.println("</html>");
        
        }
}