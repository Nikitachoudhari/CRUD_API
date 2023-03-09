import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
 
	public static Student getStudentById(int roll){  
		
        Student s1 = new Student();   
            
        try{    
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/JavaFullStack" , "root","root");
		  
            PreparedStatement ps =con.prepareStatement("select * from student where roll=?");    
            ps.setInt(1,roll);      
            ResultSet  rs = ps.executeQuery();   
            if(rs.next()){     
            	s1.setRoll(rs.getInt(1));    
            	s1.setSname(rs.getString(2));      
            	s1.setAddress(rs.getString(3));   
            	s1.setCls(rs.getString(4));    
            	s1.setSub(rs.getString(5));      
            }   
            con.close();  
            
        }catch(Exception e){
        	e.printStackTrace();
        }   
            
        return s1;      
    }
}
