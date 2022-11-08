package Database.TableView;

import java.sql.Date;

public class BookingHistory{
    private int Bookin_Id;
    private String Name;
    private String Email;
    private String PhoneNumber;
    private String HallName;
    private Date StartDate;
    private Date EndDate;
    private String Status;


    public BookingHistory(int bookin_Id, String name, String email, String phoneNumber, String hallName, Date startDate, Date endDate, String status) {
        Bookin_Id = bookin_Id;
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
        HallName = hallName;
        StartDate = startDate;
        EndDate = endDate;
        Status = status;
    }

    public int getBookin_Id() {
        return Bookin_Id;
    }

    public void setBookin_Id(int bookin_Id) {
        Bookin_Id = bookin_Id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getHallName() {
        return HallName;
    }

    public void setHallName(String hallName) {
        HallName = hallName;
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


}