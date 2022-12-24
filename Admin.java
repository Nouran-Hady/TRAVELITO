import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin extends Flights {

    // definning the variables 
    private String user_name;
    private String password;
    private String first_name;
    private String last_name;
    Scanner s = new Scanner(System.in); 

    public String getU_name() {
        return user_name;
    }
    
    public void setU_name() {
        System.out.println("Please enter your user name :");
        
        user_name = s.nextLine();
    }

    public String getPass() {
        return password;
    }

    public void setPass() {
        System.out.println("Please enter your password");

        password = s.nextLine();
    }

    public String getF_name() {

        return first_name;
    }
    
    public void setF_name() {
        System.out.println("Please enter your First name");
        first_name = s.nextLine();
    }

    public String getL_name() {
        return last_name;
    }

    public void setL_name() {
        System.out.println("Please enter your Last name :");

        last_name = s.nextLine();
    }

    
    
    
    public void sign_up() throws SQLException, ClassNotFoundException{
        setU_name();
        setPass();
        setF_name();
        setL_name();
        Connection con = null;
            PreparedStatement p = null;
            ResultSet rs = null;
    
            con = connection.connectDB();
    
            
    
                String sql = "select * from Admins";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                                        Statement stmt = con.createStatement();
                          
     int result = stmt.executeUpdate("insert into Admins(User_Name,p_assword,first_name,last_name) values('"+user_name+"','"+password+"','"+first_name+"','"+last_name+"')");
     System.out.println("Added successfully");

    }


    public void log_inadmin() throws SQLException, ClassNotFoundException{
        setU_name();
        setPass();
        Connection con = connection.connectDB();
        Statement stmt = con.createStatement();
        String k="SELECT User_Name,p_assword FROM Admins";
        ResultSet rs = stmt.executeQuery(k);
        boolean ch1=false;
        boolean ch2=false;
      while (rs.next()) {
         String user_name = rs.getString("User_Name");
         if(user_name.equals(getU_name()) ){
             ch1=true;
         }
         String pass=rs.getString("p_assword");
             if(pass.equals(getPass())){
             ch2=true;
         }
         //&& ppin==getPin()
      }
      if(ch1==true && ch2==true){
          System.out.println("Logged in successfully");
      }
      else{
          System.out.println("Sorry either the password or the pin is wrong");
          log_inadmin();
      }
 


    }

    public void add_flights() throws SQLException, ClassNotFoundException{
        setflight_id();
        settype();
        setorigin();
        setdestination();
        setcapacity();
        Connection con = null;
            PreparedStatement p = null;
            ResultSet rs = null;
    
            con = connection.connectDB();
    
            
    
                String sql = "select * from Flights_db";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                                        Statement stmt = con.createStatement();
                          
     int result = stmt.executeUpdate("insert into Flights_db(flightID,flight_type,origin,destination,capacity) values('"+getflight_id()+"','"+gettype()+"','"+getorigin()+"','"+getdestination()+"','"+getcapacity()+"')");
     System.out.println("Added successfully");

    }
    
    
    public void deleteFlight () throws SQLException, ClassNotFoundException
    {
    	setflight_id();
        Connection con = connection.connectDB();
        Statement stmt = con.createStatement();

     String q1 = "DELETE from Flights_db WHERE flightID = '"+ getflight_id() +"'";
                     
            int x = stmt.executeUpdate(q1);
             
            if (x > 0)           
                System.out.println("Flight Successfully Deleted"); 

else
                System.out.println("ERROR OCCURED :(");  
    }



}



    