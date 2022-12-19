public class UpdatedFunctions {
	
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
        {
        	System.out.println("Flight Successfully Deleted"); 
        }
        else 
        {
                System.out.println("ERROR OCCURED :(");  
        }

}
}
