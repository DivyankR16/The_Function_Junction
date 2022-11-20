package Database.TableView;

import Database.DBconnection.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Venue
{
    private String VenueName;
    private String BookingStatus;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity() {
        Connection con=Connect.createConnection();
        try {
            Statement St = con.createStatement();
            String query = "Select * from Venue";
            ResultSet rs=St.executeQuery(query);
            while (rs.next()){
                if (rs.getString(2).compareToIgnoreCase( this.VenueName)==0){
                    this.capacity=rs.getInt(3);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            Connect.closeConnection();
        }
    }

    //private String City;
    private double cost;
    private int numberOfGuests;

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

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
               if(status.compareToIgnoreCase("booked")==0){
                   if(Startdate.compareTo(startDate)>=0 && Startdate.compareTo(endDate)<=0|| EndDate.compareTo(startDate)>=0 && EndDate.compareTo(endDate)<=0){
                           BookingStatus="Not Available";
                   }
               }
           }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            Connect.closeConnection();
        }
        return BookingStatus;
    }

//    public String getCity() {
//        return City;
//    }
//
//    public void setCity(String city) {
//        City = city;
//    }

    public Venue(String venueName,int numberOfGuests) {
        this.VenueName = venueName;
        this.numberOfGuests=numberOfGuests;
    }

    public double getCost(){
        Connection con=Connect.createConnection();
        try {
            Statement St = con.createStatement();
            String query = "Select * from Venue";
            ResultSet rs=St.executeQuery(query);
            while (rs.next()){
                if (rs.getString(2).compareToIgnoreCase( this.VenueName)==0){
                    this.cost=rs.getDouble(4);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            Connect.closeConnection();
        }
        return this.cost;
    }
    public Venue(){

    }
    public ArrayList<String>getAllVenueNames(){
        ArrayList<String>arr=new ArrayList<>();
        Connection con=Connect.createConnection();
        try{
            Statement stmt=con.createStatement();
            String query="Select * from venue";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                arr.add(rs.getString(2));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return arr;
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
