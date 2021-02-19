import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AjaxValidate extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
								throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String field_name = request.getParameter("field");
		String value = request.getParameter("data");

		if(field_name.equals("username")){
			if(value!=" " && value!=null){
				String regex1 = "^[a-zA-Z0-9]+$";
				Pattern pattern1 = Pattern.compile(regex1);
				Matcher matcher1 = pattern1.matcher(value);
				if(value.length()<4 || value.length()>25 || !matcher1.matches()){
					out.write("Username must contain atleast 4 alphanumeric Characters!!");
				}
				else{
					out.write("valid");
				}
			}
		}
		if(field_name.equals("emailId")){
			if(value!=" " && value!=null){
				String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+[.][a-z]+$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(value);
				if(!matcher.matches()){
					out.write("Please enter a Valid Email Address!");
				}
				else{
					out.write("valid");
				}
			}
		}
		if(field_name.equals("dob")){
			if(value!=" " && value!=null){
				int user_age = Integer.parseInt(value);
				if(user_age<5 || user_age>99){
					out.write("Invalid age");
				}
				else{
						out.write("valid");
					}
				}
		}
		if(field_name.equals("password1")){
			if(value!=" " && value!=null){
				if(value.length()<6 || value.length()>15)
				{
					out.write("Password must contains atleast 6 Characters!!");
				}
				else{
					out.write("valid");
				}
			}
		}
		out.close();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
								throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		out.println("<head>");
        out.println("<title>ServletTest</title>");
        out.println("</head>");
		out.println("<h1>" +username + "! "+ "You have Registered Successfully!</h1>");
		out.println("</body>");
        out.println("</html>");
		out.close();
	}
}