import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Flights {
	
	//Defining the attributes
	protected int flightID;
	protected String type;
	protected String origin;
	protected String destination;
	protected int capacity;
    protected int no_ofpassengers;


    Scanner s = new Scanner(System.in); 

    public int getflight_id() {
        return flightID;
    }
    
    public void setflight_id() {
        System.out.println("Please enter flight Id :");
        
        flightID = s.nextInt();
        s.nextLine();
    }

    public String gettype() {
        return type;
    }

    public void settype() {
        System.out.println("Please enter flight type :");

        type = s.nextLine();
    }

    public String getorigin() {

        return origin;
    }
    
    public void setorigin() {
        System.out.println("Please enter The origin of the flight :");
        origin = s.nextLine();
    }

    public String getdestination() {
        return destination;
    }

    public void setdestination() {
        System.out.println("Please enter The flight destination :");

        destination = s.nextLine();
    }
    
    public int getcapacity() {
        return capacity;
    }

    public void setcapacity() {
        System.out.println("Please enter the flight capacity :");

        capacity = s.nextInt();
        s.nextLine();
    }
    public int getno_ofpassengers() {
        return no_ofpassengers;
    }

    public void setno_ofpassengers() {
        System.out.println("Please enter the number of passengers you want to book :");

        no_ofpassengers = s.nextInt();
        s.nextLine();
    }
    
    public void ViewFlight_db() throws SQLException, ClassNotFoundException{
        setflight_id();
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        con = connection.connectDB();
                Statement stmt = con.createStatement();
            String sql ="SELECT * FROM Flights_db WHERE flightID = '"+getflight_id()+"'";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                // Condition check
          while (rs.next()) {
            int flightID = rs.getInt(1);
            String type = rs.getString(2);
            String origin = rs.getString(3);
                            String destination = rs.getString(4);
                            int capacity= rs.getInt(5);
            System.out.println("Flight ID is : " + flightID + "\n" + "Flight type is : " +type+ "\n" +"The origin of the flight is : " +origin+"\n" +"The destination of the flight is : " +destination+ "\n" + "The Capacity of the flight is : " + capacity );
          }
    
    }
	
}
