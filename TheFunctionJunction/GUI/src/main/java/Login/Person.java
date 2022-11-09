package Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import Database.DBconnection.Connect;

import static Database.DBconnection.Connect.createConnection;

public class Person implements Login{
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String EmailId;
    private String LoginId;
    private String Password;
    private LocalDate DOB;

    public String getFirstName(){return this.FirstName;}
    public void setFirstName(String firstName){this.FirstName = firstName;}
    public String getLastName(){return this.LastName;}
    public void setLastName(String lastName){this.LastName = lastName;}
    public LocalDate getDOB(){return this.DOB;}
    public void setDOB(LocalDate DOB){this.DOB = DOB;}
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

    public Person(String firstName, String lastName, String phoneNumber, String emailId, String loginId, String password, LocalDate DOB) {
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        EmailId = emailId;
        LoginId = loginId;
        Password = password;
        this.DOB = DOB;
    }

    @Override
    public int Login(String LoginID, String password,String TableName) {
        LoginID=LoginID.trim();
        int validity=0;
        Connection conn= Connect.createConnection();
        try{if(LoginID.isEmpty()){
            validity=2;
        }
        else if(password.isEmpty()){
            validity=3;
        }
        else{
            String query="Select * from "+(TableName)+" where loginid=? and password=?";
            PreparedStatement preStatement=conn.prepareStatement(query);
            preStatement.setString(1,LoginID);
            preStatement.setString(2,password);
            ResultSet rs=preStatement.executeQuery();
            if(rs.next()){
                validity=1;
            }
            else{
                validity=0;
            }
        }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            Connect.closeConnection();
        }
        return validity;
    }

    @Override
    public String getPass(String loginID){
        Connection conn=Connect.createConnection();
        String password="";
        try{String query="Select password from where loginid=?";
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
    public void changePass(String LoginID,String newPassword){
        Connection conn=Connect.createConnection();
        try{String query="update set password=? where loginid=?";
            PreparedStatement preparedStatement=conn.prepareStatement(query);
            preparedStatement.setString(1,newPassword);
            preparedStatement.setString(2,LoginID);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Connect.closeConnection();
        }
    }
    }
