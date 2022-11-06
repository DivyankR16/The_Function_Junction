package Database.TableView;

import java.util.Date;

public class Person
{
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String EmailId;
    private String LoginId;
    private String Password;
    private Date DOB;

    public String getFirstName(){return this.FirstName;}
    public void setFirstName(String firstName){this.FirstName = firstName;}
    public String getLastName(){return this.LastName;}
    public void setLastName(String lastName){this.LastName = lastName;}
    public Date getDOB(){return this.DOB;}
    public void setDOB(Date DOB){this.DOB = DOB;}
    public String getPhoneNumber(){return this.PhoneNumber;}
    public void setPhoneNumber(String phoneNumber){this.PhoneNumber = phoneNumber;}
    public String getEmailId(){return this.EmailId;}
    public void setEmailId(String emailId){this.EmailId = emailId;}
    public String getLoginId(){return this.LoginId;}
    public void setLoginId(String loginId){this.LoginId = loginId;}
    public String getPassword(){return this.Password;}
    public void setPassword(String password){this.Password = password;}

    public Person()
    {

    }

    public Person(String firstName, String lastName, String phoneNumber, String emailId, String loginId, String password, Date DOB) {
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        EmailId = emailId;
        LoginId = loginId;
        Password = password;
        this.DOB = DOB;
    }
}
