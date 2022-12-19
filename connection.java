// Java Program to Retrieve Contents of a Table Using JDBC
// connection

// Showing linking of created database

// Importing SQL libraries to create database
import java.sql.*;

public class connection {

	Connection con = null;

	public static Connection connectDB() throws ClassNotFoundException

	{

		try {
			// Importing and registering drivers
			Class.forName("com.mysql.cj.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "HELLO55");

			// here,root is the username and 1234 is the
			// password,you can set your own username and
			// password.
  
return con;  
}catch(Exception e){ System.out.println(e);}  
            return null;
  
} 

}  

