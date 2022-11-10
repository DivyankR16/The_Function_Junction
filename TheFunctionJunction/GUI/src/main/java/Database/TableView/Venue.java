package Database.TableView;

import Database.DBconnection.Connect;

import java.sql.*;

public class Venue
{
    private String VenueName;
    private String BookingStatus;
    private String City;

    public String getVenueName() {
        return VenueName;
    }

    public void setVenueName(String venueName) {
        VenueName = venueName;
    }

    public String getBookingStatus(Date Startdate,Date EndDate) {
        BookingStatus="Available";
        Connection con= Connect.createConnection();
        try{
            Statement stmt=con.createStatement();
            String query="select * from bookinghistory where hallname='"+(VenueName)+"'";
            ResultSet rs=stmt.executeQuery(query);
           while(rs.next()){
               Date startDate=rs.getDate(6);
               Date endDate=rs.getDate(7);
               String status=rs.getString(8);
               if(status.compareTo("booked")==0){
                   if(Startdate.compareTo(startDate)>0 && Startdate.compareTo(endDate)<0|| EndDate.compareTo(startDate)<0 && EndDate.compareTo(endDate)<0){
                           BookingStatus="Not Available";
                   }
               }
           }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return BookingStatus;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Venue(String venueName, String city) {
        VenueName = venueName;
        City = city;
    }
    public Venue(){

    }

}
//public class Run{
//     public static void main(String[] args) throws ParseException {
//         Venue a=new Venue();
//         a.setVenueName("Dhanush");
//         LocalDate date=LocalDate.of(2022,11,9);
//         LocalDate date1=LocalDate.of(2222,12,10);
//         Date d1=Date.valueOf(date);
//         Date d2=Date.valueOf(date1);
//         String ans=a.getBookingStatus(d1,d2);
//         System.out.println(ans);
//     }
//}
