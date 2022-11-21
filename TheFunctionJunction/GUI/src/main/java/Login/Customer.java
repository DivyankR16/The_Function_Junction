package Login;

import CSVLoaders.changeBookingHistoryCSV;
import CSVLoaders.changeCustomerCSV;
import Database.DBconnection.Connect;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.concurrent.Callable;

public class Customer extends Person implements Login
{
    private String CustomerID;
    private String MembershipStatus; //New,Premium,Gold
    private LocalDate DateOfJoining ;

    public Customer()
    {

    }

    public Customer(String firstName, String lastName, String phoneNumber, String emailId, String loginId, String password,String DOB, String membershipStatus) {
        super(firstName, lastName, phoneNumber, emailId, loginId, password, DOB);
        this.MembershipStatus = membershipStatus;
        this.DateOfJoining = LocalDate.now();
    }

    public Customer(String firstName, String lastName, String phoneNumber, String emailId, String loginId, String password,String DOB) {
        super(firstName, lastName, phoneNumber, emailId, loginId, password, DOB);
        this.MembershipStatus = "New";
        this.DateOfJoining = LocalDate.now();
    }

    public String getCustomerID(){return this.CustomerID;}
    public void setCustomerID(String customerID){this.CustomerID = customerID;}
    public String getMembershipStatus(){return this.MembershipStatus;}
    public void setMembershipStatus(String membershipStatus){this.MembershipStatus = membershipStatus;}
    public LocalDate getDateOfJoining(){return this.DateOfJoining;}
    public void setDateOfJoining(LocalDate dateOfJoining){this.DateOfJoining = dateOfJoining;}
    @Override
    public String getPass(String loginID){
        String password="";
        try{
            Connection conn= Connect.createConnection();
            String query="Select password from customer where loginid=?";
            PreparedStatement preStatement=conn.prepareStatement(query);
            preStatement.setString(1,loginID);
            ResultSet rs=preStatement.executeQuery();
            if(rs.next()){
                password=rs.getString("password");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Connect.closeConnection();
        }
        return password;
    }
    @Override
    public void changePass(String LoginID,String newPassword){
        Connection conn=Connect.createConnection();
        try{String query="update customer set password=? where loginid=?";
            PreparedStatement preparedStatement=conn.prepareStatement(query);
            preparedStatement.setString(1,newPassword);
            preparedStatement.setString(2,LoginID);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Connect.closeConnection();
        }
    }
    public boolean Availability(String LogID)
    {
        Connection con1 = Connect.createConnection();
        try {
            String query1 = "SELECT loginid FROM customer WHERE loginid=?";
            PreparedStatement preStatement=con1.prepareStatement(query1);
            preStatement.setString(1,LogID);
            ResultSet rs1 = preStatement.executeQuery();
            if (rs1.isBeforeFirst())
            {
                System.out.println("LoginId Already Exists.");
                return false;
            }
            else
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally {
            Connect.closeConnection();
        }
    }
    public void Signup(String Fname, String Lname,String PhNo,String Email,String LoginId,String Password,String dob,String cid)
    {
        this.setFirstName(Fname);
        this.setLastName(Lname);
        this.setPhoneNumber(PhNo);
        this.setEmailId(Email);
        this.setLoginId(LoginId);
        this.setPassword(Password);
        this.setDOB(dob);
        this.setMembershipStatus("New");
        this.DateOfJoining = LocalDate.now();
        this.setCustomerID(cid);
//        Connection conn = Connect.createConnection();
        if (Availability(LoginId))
        {  Connection c2 = Connect.createConnection();
            try {
                String query2 = "INSERT INTO customer (LoginId,FirstName,LastName,PhoneNumber,EmailId,Password,DOB,CustomerID,MembershipStatus,DateOfJoining) VALUES (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement preStatement2 = c2.prepareStatement(query2);
                preStatement2.setString(1,this.getLoginId());
                preStatement2.setString(2,this.getFirstName());
                preStatement2.setString(3,this.getLastName());
                preStatement2.setString(4,this.getPhoneNumber());
                preStatement2.setString(5,this.getEmailId());
                preStatement2.setString(6,this.getPassword());
                preStatement2.setString(7,this.getDOB().toString());
                preStatement2.setString(8,this.getCustomerID());
                preStatement2.setString(9,this.getMembershipStatus());
                preStatement2.setString(10,this.getDateOfJoining().toString());
                preStatement2.executeUpdate();
                changeCustomerCSV.load_into_customer_csv(this.getFirstName(),this.getLastName(),this.getPhoneNumber(),this.getEmailId(),this.getLoginId(),this.getPassword(),this.getDOB(),this.getCustomerID());
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            finally
            {
                Connect.closeConnection();
            }
        }
        else
        {
            System.out.println("unsuccessfull");
        }
    }
}
