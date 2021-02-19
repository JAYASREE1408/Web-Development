import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class Session extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<head>");
		out.println("<title>the servlet test</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"\">");

		HttpSession session = request.getSession();
		Integer c=(Integer)session.getAttribute("count");
		if(session.isNew())
			{
				String dataName = request.getParameter("uname");
				c=1;
				if (dataName != null && dataName.length() > 0) {
					session.setAttribute("attribname",dataName);
				}
				out.println("This is the first time this user requests this servlet");
				session.setAttribute("count",c);
		
			}
			else
			{
					if(session.getAttribute("attribname")!=null)
					{
						out.println(session.getAttribute("attribname"));
						c++;
						out.println("You have visited\t" + c + "\t times\n");
						session.setAttribute("count",c);
				}
			}
		// print session info

		out.println("</body>");
		out.println("</html>");
		
		Date created = new Date(session.getCreationTime());
		Date accessed = new Date(session.getLastAccessedTime());
		out.println("ID" + session.getId());
		out.println("Created:" + created);
		out.println("Last Accessed:" + accessed);

	}
}
		