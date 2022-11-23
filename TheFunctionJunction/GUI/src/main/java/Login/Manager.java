package Login;

import CSVLoaders.ManagerUpdate;
import Database.DBconnection.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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

    public Manager(String firstName, String lastName, String phoneNumber, String emailId, String loginId, String password, String DOB) {
        super(firstName, lastName, phoneNumber, emailId, loginId, password, DOB);
        DateOfJoining = Calendar.getInstance();
        this.DateOfJoining.set(Calendar.HOUR_OF_DAY,0);
    }
    @Override
    public String getPass(String loginID){
        Connection conn= Connect.createConnection();
        String password="";
        try{String query="Select password from manager where loginid=?";
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
        try{String query="update manager set password=? where loginid=?";
            PreparedStatement preparedStatement=conn.prepareStatement(query);
            preparedStatement.setString(1,newPassword);
            preparedStatement.setString(2,LoginID);
            preparedStatement.executeUpdate();
            ManagerUpdate.UpdateCSV(LoginID,newPassword);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Connect.closeConnection();
        }
    }

}
