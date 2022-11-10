package Database.TableView;
import java.sql.*;
import java.util.ArrayList;

abstract class Event
{
    private Date StartDate;
    private Date EndDate;
    private Venue venue;
    private String BookingStatus;
    private ArrayList<Menu> menus=new ArrayList<>();

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
}
