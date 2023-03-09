import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update2")
public class UpdateServlet2 extends HttpServlet{
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
 
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
  		
	 	int roll =  Integer.parseInt(request.getParameter("t1"));
		String name =  (String)request.getParameter("t2");  
		String address = (String)request.getParameter("t3");  
		String cls = (String)request.getParameter("t4");  
		String sub = (String)request.getParameter("t5"); 
		
		try {
			String sql = "update student set name=? , address=? , class=? , subject=? where roll="+roll;
			
			ps = con.prepareStatement(sql);
		 	ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, cls);
			ps.setString(4, sub);
		    ps.execute();
		    
		    out.println("<html>");
			out.println("<body bgcolor=pink>");
		    out.println("<center><h1>Data Updated Successfully!");
	 	   	out.println("<br><h3><a href=index.html>Add another Data</a>");
		  	out.println("</body></html>");
	 		out.close();
	 		
 		}catch(Exception e) {
			e.printStackTrace();
		}
  	}
	
	
	@Override
	public void destroy() {
		 try {
			 con.close();
			 ps.close();
	 	 }catch(Exception e) {
				e.printStackTrace();
			}
	   }
	
	
}
