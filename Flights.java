import java.util.Scanner;

public class Flights {
	
	//Defining the attributes
	protected int flightID;
	protected String type;
	protected String origin;
	protected String destination;
	protected int capacity;


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

	
}
