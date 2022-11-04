package Login;

import java.util.Calendar;
import java.util.Date;

public class Customer extends Person
{
    private String CustomerID;
    private String MembershipStatus; //New,Premium,Gold
    private Calendar DateOfJoining ;

    public Customer()
    {

    }

    public Customer(String firstName, String lastName, String phoneNumber, String emailId, String loginId, String password, Date DOB, String membershipStatus) {
        super(firstName, lastName, phoneNumber, emailId, loginId, password, DOB);
        this.MembershipStatus = membershipStatus;
        this.DateOfJoining = Calendar.getInstance();
        this.DateOfJoining.set(Calendar.HOUR_OF_DAY,0);
    }

    public Customer(String firstName, String lastName, String phoneNumber, String emailId, String loginId, String password, Date DOB) {
        super(firstName, lastName, phoneNumber, emailId, loginId, password, DOB);
        this.MembershipStatus = "New";
        this.DateOfJoining = Calendar.getInstance();
        this.DateOfJoining.set(Calendar.HOUR_OF_DAY,0);
    }

    public String getCustomerID(){return this.CustomerID;}
    public void setCustomerID(String customerID){this.CustomerID = customerID;}
    public String getMembershipStatus(){return this.MembershipStatus;}
    public void setMembershipStatus(String membershipStatus){this.MembershipStatus = membershipStatus;}
    public Calendar getDateOfJoining(){return this.DateOfJoining;}
    public void setDateOfJoining(Calendar dateOfJoining){this.DateOfJoining = dateOfJoining;}


}
