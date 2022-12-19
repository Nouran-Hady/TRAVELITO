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
    private String gender;
    private int phone_num;
    private String email;
    private int age;
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

    public String getGender() {
        return gender;
    }

    public void setGender() {
        System.out.println("Please enter your gender :");
        gender = s.nextLine();
    }

    public int getP_num() {
        return phone_num;
    }

    public void setP_num() {
        System.out.println("Please enter your Phone number :");
        phone_num = s.nextInt();
        s.nextLine();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        System.out.println("Please enter your email :");
       email = s.nextLine();
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        System.out.println("Please enter your age :");
         age= s.nextInt();
         s.nextLine();
    }

    
    
    public void sign_up() throws SQLException, ClassNotFoundException{
        setU_name();
        setPass();
        setF_name();
        setL_name();
        setGender();
        setP_num();
        setEmail();
        setAge();
        Connection con = null;
            PreparedStatement p = null;
            ResultSet rs = null;
    
            con = connection.connectDB();
    
            
    
                String sql = "select * from Admins";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                                        Statement stmt = con.createStatement();
                          
     int result = stmt.executeUpdate("insert into Admins(User_Name,p_assword,first_name,last_name,gender,Phone_number,email,age) values('"+user_name+"','"+password+"','"+first_name+"','"+last_name+"','"+gender+"','"+phone_num+"','"+email+"','"+age+"')");
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
    
            
    
                String sql = "select * from Flights";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                                        Statement stmt = con.createStatement();
                          
     int result = stmt.executeUpdate("insert into Flights(flightID,flight_type,origin,destination,capacity) values('"+getflight_id()+"','"+gettype()+"','"+getorigin()+"','"+getdestination()+"','"+getcapacity()+"')");
     System.out.println("Added successfully");

    }
    
    
    public void deleteFlight () throws SQLException, ClassNotFoundException
    {
    	setflight_id();
        Connection con = connection.connectDB();
        Statement stmt = con.createStatement();

     String q1 = "DELETE from Flights WHERE flightID = '"+ getflight_id() +"'";
                     
            int x = stmt.executeUpdate(q1);
             
            if (x > 0)           
                System.out.println("Flight Successfully Deleted"); 

else
                System.out.println("ERROR OCCURED :(");  
    }

}




        /*public void sign_in(){
        System.out.println("Please enter your user name :");
        String user_n=s.nextLine();
        System.out.println("Please enter your Password :");
        String user_p=s.nextLine();
        PreparedStatement p = null;
        ResultSet rs = null;
        
        // Try block to catch exception/s
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/mydb","root","HELLO55");
 
 
            // SQL command data stored in String datatype
            String sql = "select * from Admins";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();
 
            // Printing ID, name, email of customers
            // of the SQL command above
 
            // Condition check
            while (rs.next()) {
 
                String User_Name = rs.getString("User_Name");
                if(User_Name==user_n){
                    System.out.println("signed in successfuly");
                }
                 
            }
        }
 
        // Catch block to handle exception
        catch(Exception e)
        {
         System.out.println(e);
    
        }
     }*/