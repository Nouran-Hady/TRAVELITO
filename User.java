import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class User extends Flights {
    
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
    
            
    
                String sql = "select * from Users";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                                        Statement stmt = con.createStatement();
                          
     int result = stmt.executeUpdate("insert into Users(User_Name,p_assword,first_name,last_name,gender,Phone_number,email,age) values('"+user_name+"','"+password+"','"+first_name+"','"+last_name+"','"+gender+"','"+phone_num+"','"+email+"','"+age+"')");
     System.out.println("Added successfully");

    }



    public void log_inuser() throws SQLException, ClassNotFoundException{
        setU_name();
        setPass();
        Connection con = connection.connectDB();
        Statement stmt = con.createStatement();
        String k="SELECT User_Name,p_assword FROM Users";
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
          log_inuser();
      }
 


    }



    public void book_flight() throws SQLException, ClassNotFoundException{
        setorigin();
        setdestination();
        setno_ofpassengers();
        settype();
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        con = connection.connectDB();
                Statement stmt = con.createStatement();
            String sql ="SELECT * FROM Flights_db WHERE destination = '"+getdestination()+"' AND origin = '"+getorigin()+"' AND flight_type = '"+gettype()+"'  ";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                // Condition check
          while (rs.next()) {
            int capacity = rs.getInt(5);
            int flightID = rs.getInt(1);
            String type = rs.getString(2);
            String origin = rs.getString(3);
                            String destination = rs.getString(4);
            if(capacity>getno_ofpassengers()){
                String q1 = "UPDATE Users set booked_flights = '" + flightID +"' WHERE User_Name = '" +getU_name()+ "' AND p_assword = '" + getPass() + "'";
        int x = stmt.executeUpdate(q1);
        int cap;
         cap=capacity-getno_ofpassengers();
        String q2 = "UPDATE Flights_db set capacity = '" + cap +"' WHERE destination = '"+getdestination()+"' AND origin = '"+getorigin()+"' AND flight_type = '"+gettype()+"'";
        int y = stmt.executeUpdate(q2);
        System.out.println("Flight booked successfully !!");
            }
            
            System.out.println("Flight ID is : " + flightID + "\n" + "Flight type is : " +type+ "\n" +"The origin of the flight is : " +origin+"\n" +"The destination of the flight is : " +destination+ "\n" );
          }

    }

}
