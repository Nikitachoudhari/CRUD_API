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

@WebServlet("/create")
public class CreateServlet extends HttpServlet{
	
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
		
		String name =  (String)request.getAttribute("x1");  
		String address = (String)request.getAttribute("x2");  
		String cls = (String)request.getAttribute("x3");  
		String sub = (String)request.getAttribute("x4"); 
		
		try {
			String sql = "insert into student values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1,roll);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, cls);
			ps.setString(5, sub);
		    int n = ps.executeUpdate();
		    
		    out.println("<html>");
			out.println("<body bgcolor=pink>");
		    
		    if(n>0) {
		        out.println("<center><h1>Data Updated Successfully!");
				out.println("<br><h3><a href=index.html>Add another Data</a>");
		    }else {
		    	out.println("<center><h1>Something went wrong!");
				out.println("<br><h3><a href=index.html>try again</a>");
		    }
			
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
