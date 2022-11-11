package Database.TableView;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class BookingHistory{
    private int Bookin_Id;
    private String Name;
    private String Email;
    private String PhoneNumber;
    private String HallName;
    private String StartDate;
    private String EndDate;
    private String Status;


    public BookingHistory(int bookin_Id, String name, String email, String phoneNumber, String hallName, String startDate, String endDate, String status) {
        this.Bookin_Id = bookin_Id;
        this.Name = name;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
        this.HallName = hallName;
        this.StartDate = startDate;
        this.EndDate = endDate;
        this.Status = status;
    }

    public String getBookinID() {
        return String.valueOf(Bookin_Id);
    }

    public void setBookin_Id(int bookin_Id) {
        Bookin_Id=bookin_Id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status=status;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber=phoneNumber;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name=name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email=email;
    }

    public String getHallName() {
        return HallName;
    }

    public void setHallName(String hallName) {
        HallName=hallName;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate=startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate=endDate;
    }


}