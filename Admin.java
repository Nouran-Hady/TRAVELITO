import java.util.Scanner;
import java.io.*;
import java.sql.DriverManager;
import java.sql.*;


public class Admin {

    // definning the variables 
    public String user_name;
    public String password;
    public String first_name;
    public String last_name;
    public String gender;
    public int phone_num;
    public String email;
    public int age;

    
    Scanner s = new Scanner(System.in); 
    
    
    public void sign_up(){
        try
    {
     Class.forName("com.mysql.cj.jdbc.Driver");
     Connection con=DriverManager.getConnection
     ("jdbc:mysql://localhost:3306/mydb","root","HELLO55");
     //Statement stmt=con.createStatement();



     System.out.println(
        "Enter your First Name : ");
        first_name= s.nextLine();



  System.out.println(
    "Enter your Last Name : ");
    last_name= s.nextLine();
 



    
System.out.println(
    "Enter your Gender : ");
    gender= s.next();




    System.out.println(
        "Enter your age : ");
        age= s.nextInt();
        s.nextLine();
 


        System.out.println(
            "Enter Password : ");
        password=s.nextLine();



        System.out.println(
            "Enter your email : ");
        email=s.nextLine();


        System.out.println(
        "Enter your phone number : ");
        phone_num= s.nextInt();
        s.nextLine();


     System.out.println(
        "Enter username : ");
    user_name = s.nextLine();

  


    String SQL = "INSERT INTO Admins VALUES (?,?,?,?,?,?,?,?)";
    PreparedStatement p = con.prepareStatement(SQL);
    p.setString(1, first_name);
    p.setString(2, last_name);
    p.setString(3, gender);
    p.setInt(4, age);
    p.setString(5, password);
    p.setString(6, email);
    p.setInt(7, phone_num);
    p.setString(8, user_name);
    p.executeUpdate();
    p.close();


//stmt.executeUpdate("INSERT INTO Admins VALUES (first_name, last_name, gender ,age, password, email,phone_num,user_name");
     con.close();
    }



    catch(Exception e)
    {
     System.out.println(e);

    }

       
    }



    public void sign_in(){
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
     }

    }

