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
import javax.servlet.http.HttpSession;

@WebServlet("/CRUD")
public class CRUDServlet extends HttpServlet{
	
	
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String button = request.getParameter("A");
		
		if(button.equals("Create")) {
			int roll = Integer.parseInt(request.getParameter("t1"));
			String name = request.getParameter("t2");
			String address = request.getParameter("t3");
			String cls = request.getParameter("t4");
			String sub = request.getParameter("t5");
			 
			request.setAttribute("x" , roll);
			request.setAttribute("x1" , name);
			request.setAttribute("x2" , address);
			request.setAttribute("x3" , cls);
			request.setAttribute("x4" , sub);
 			 
			ServletContext sc = getServletContext();
			RequestDispatcher rs =sc.getRequestDispatcher("/create");
			rs.forward(request, response);
		}
		else if(button.equals("Update")) {
			int roll = Integer.parseInt(request.getParameter("t1"));
        	request.setAttribute("x" , roll);
        	ServletContext sc = getServletContext();
			RequestDispatcher rs =sc.getRequestDispatcher("/update");
			rs.forward(request, response);
		}
        else if(button.equals("Delete")) {
        	int roll = Integer.parseInt(request.getParameter("t1"));
        	request.setAttribute("x" , roll);
        	ServletContext sc = getServletContext();
			RequestDispatcher rs =sc.getRequestDispatcher("/delete");
			rs.forward(request, response);
		}
        else  if(button.equals("Show")) {
         
        	ServletContext sc = getServletContext();
			RequestDispatcher rs =sc.getRequestDispatcher("/show");
			rs.forward(request, response);
        }
    	 
    	
    }
}
