import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpConnectTimeoutException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/show")
public class ShowServlet extends HttpServlet{
	
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
		
		out.println("<html>");
		out.println("<body bgcolor=wheat>");
		
		try {
			
			String sql="select * from student" ;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			out.println("<center><h1>Student Details");
			if(rs.next()) {
				out.println("<br><center><table border=1 >");
				out.println("<tr>");
				out.println("<th>Roll no.</th>");
				out.println("<th>Student Name</th>");
				out.println("<th>Address</th>");
				out.println("<th>Class</th>");
				out.println("<th>Subject</th>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>"+rs.getInt(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("</tr>");
				
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>"+rs.getInt(1)+"</td>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getString(3)+"</td>");
					out.println("<td>"+rs.getString(4)+"</td>");
					out.println("<td>"+rs.getString(5)+"</td>");
					out.println("</tr>");
			 	}
			}else {
				out.println("<center><h1>Table is Empty");
			}
	  	}catch(Exception e) {
			e.printStackTrace();
		}
		out.println("<input type=button value=Back onClick=history.back() />");
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
