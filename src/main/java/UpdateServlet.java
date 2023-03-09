import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
 	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
 
	 	Integer d = (Integer)request.getAttribute("x");  
		int roll = d.intValue(); 
		
		Student e1 = new Student();
	 	e1= Dao.getStudentById(roll);
	 
		out.print("<html>"); 
		out.print("<body bgcolor=cyan>"); 
		out.print("<center><h1>Update Student Details</h1>");
		out.print("<form action='update2' method='post'>");    
        out.print("<table>");   
        out.print("<tr><td>Roll No.</td><td><input type='text' name='t1'  value='"+e1.getRoll()+"'/></td></tr>");     
        out.print("<tr><td>Student Name</td><td><input type='text' name='t2' value='"+e1.getSname()+"'/></td></tr>");      
        out.print("<tr><td>Address</td><td><input type='text' name='t3' value='"+e1.getAddress()+"'/></td></tr>");      
                
        out.print("<tr><td>Class</td>");      
        out.print("<td><select name='t4' style='width:150px' value='"+e1.getCls()+"' > ");      
        out.print("<option>5th</option>");      
        out.print("<option>6th</option>");      
        out.print("<option>7th</option>");     
        out.print("<option>8th</option>");   
        out.print("<option>9th</option>"); 
        out.print("<option>10th</option>"); 
        out.print("<option>11th</option>"); 
        out.print("<option>12th</option>"); 
        out.print("</select>");     
        out.print("</td></tr>");   
        
        out.print("<tr><td>Favourite Subject</td>");      
        out.print("<td><select name='t5' style='width:150px' value='"+e1.getSub()+"' >");      
        out.print("<option>Hindi</option>");      
        out.print("<option>Engilsh</option>");      
        out.print("<option>Maths</option>");     
        out.print("<option>Sanskrit</option>");   
        out.print("<option>Biology</option>"); 
        out.print("<option>History</option>"); 
        out.print("<option>Civix</option>"); 
        out.print("<option>Physics</option>"); 
        out.print("</select>");     
        out.print("</td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");     
        out.print("</table>");      
        out.print("</form>");   
            
        out.close();
		 
  	}
	
 
	
}
