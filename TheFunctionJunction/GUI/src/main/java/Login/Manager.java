package Login;

import java.util.Calendar;
import java.util.Date;

public class Manager extends Person
{
    private String EmployeeID;
    private Calendar DateOfJoining;
    public String getEmployeeID(){return this.EmployeeID;}
    public void setEmployeeID(String employeeID){this.EmployeeID = employeeID;}
    public Calendar getDateOfJoining(){return this.DateOfJoining;}
    public void setDateOfJoining(Calendar dateOfJoining){this.DateOfJoining = dateOfJoining;}
    public Manager()
    {

    }

    public Manager(String firstName, String lastName, String phoneNumber, String emailId, String loginId, String password, Date DOB) {
        super(firstName, lastName, phoneNumber, emailId, loginId, password, DOB);
        DateOfJoining = Calendar.getInstance();
        this.DateOfJoining.set(Calendar.HOUR_OF_DAY,0);
    }

}
