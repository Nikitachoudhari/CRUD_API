import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	
	Connection con;
	PreparedStatement ps;
 
	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3305/JavaFullStack" , "root","root");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Integer d = (Integer)request.getAttribute("x");  
		int roll = d.intValue();   
		
		out.println("<html>");
		out.println("<body bgcolor=wheat>");
		
		 try {
		     String sql = "delete from student where roll=?";
			 ps = con.prepareStatement(sql);
			 ps.setInt(1, roll);
			 ps.executeUpdate();
			 

			 out.println("<center><h1>Data Deleted Successfully!!!");
			 out.println("<br><h3><a href=index.html>enter account details</a>");
			 out.println("</body></html>");
			 
			 out.close();
			 ps.close();
			 
		 }
		 catch(Exception e) {
				e.printStackTrace();
			}
		}
		
 		public void destroy() {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}