package Database.TableView;
import CSVLoaders.EventUpdate;
import CSVLoaders.changeBookingHistoryCSV;
import Database.DBconnection.Connect;
import Login.Customer;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public abstract class Event
{
    private Date StartDate;
    private Date EndDate;
    private Venue venue;
    private String BookingStatus="";
    private ArrayList<Menu> menus=new ArrayList<>();
    private double finalCost;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(double finalCost) {
        this.finalCost = finalCost;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getBookingStatus() {
        return BookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        BookingStatus = bookingStatus;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public Event() {
    }

    public Event(Date startDate, Date endDate, Venue venue, String bookingStatus, ArrayList<Menu> menus) {
        StartDate = startDate;
        EndDate = endDate;
        this.venue = venue;
        BookingStatus = bookingStatus;
        this.menus = menus;
    }

    abstract double CalculateCost();
    public static void updateEvent(Event even, Customer c, int BookingID, String name) throws SQLException {
        try (Connection con = Connect.createConnection()) {
            String query = "insert into event values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,BookingID);
            ps.setString(2,c.getCustomerID());
            ps.setString(3,name);
            ps.setString(4,c.getFirstName());
            ps.setString(5,c.getLastName());
            ps.setString(6,c.getEmailId());
            ps.setString(7,even.getVenue().getVenueName());
            ps.setString(8,even.getStartDate().toString());
            ps.setString(9,even.getEndDate().toString());
            ps.setDouble(10,even.getFinalCost());
            ps.setString(11,c.getPhoneNumber());
            ps.setString(12,even.getBookingStatus());
            ps.executeUpdate();
            EventUpdate.load_into_event_csv(String.valueOf(BookingID),c.getCustomerID(),name,c.getFirstName(),c.getLastName(),c.getEmailId(),even.getVenue().getVenueName(),even.getStartDate().toString(),even.getEndDate().toString(),String.valueOf(even.getFinalCost()),c.getPhoneNumber(),even.getBookingStatus());
            changeBookingHistoryCSV.load_into_customer_csv(String.valueOf(BookingID),c.getFirstName(),c.getLastName(),c.getEmailId(),c.getPhoneNumber(),even.getVenue().getVenueName(),even.getStartDate().toString(),even.getEndDate().toString(),even.getBookingStatus());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
