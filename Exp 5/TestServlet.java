import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
public class TestServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) 
        throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out =response.getWriter();
        out.println("<head>");
        out.println("<title>1818128_ServletTest</title>");
        out.println("</head>");
        out.println("<body style='background-image: linear-gradient(to bottom right,#fa1964,pink,#fa1964,pink,#fa1964,pink,#fa1964)'>");
        out.println("<h1 style='text-align:center;box-shadow: 3px 3px 3px 3px #e6fffb;background:#8dd6eb;position: absolute;top: 40%;left: 50%;border:3px solid #0a42a3;padding:20px;border-radius:40px;margin-right: -50%;transform: translate(-50%, -50%);'>The Test Servlet is running successfully !...<h1>");
        out.println("</body>");
        out.println("</html>");
       }
}
        