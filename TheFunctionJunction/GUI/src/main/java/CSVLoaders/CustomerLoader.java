package CSVLoaders;

import Database.DBconnection.Connect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class CustomerLoader
{
    private int batchSize = 50;
    static String csvFilePath="customer.csv";
    Connection con= Connect.createConnection();
    public void LoadCSV(){
        try{
            Statement St = con.createStatement();
            con.setAutoCommit(false);
            String Query1="Drop table if exist customer";
            String Query2="create table customer(loginid INT, password INT, FirstName TEXT, LastName TEXT, PhoneNumber INT, EmailId TEXT, DOB DATE, CustomerID INT, MembershipStatus TEXT, DateOfJoining DATE)" ;
            St.executeQuery(Query1);
            St.executeQuery(Query2);

            String Query3 = "INSERT INTO customer (loginid, password, FirstName, LastName, PhoneNumber, EmailId, DOB, CustomerID, MembershipStatus, DateOfJoining ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(Query3);
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null)
            {
                String[] data = lineText.split(",");
                String loginid_data = data[0];
                String password_data = data[1];
                String FirstName_data = data[2];
                String LastName_data = data[3];
                String PhoneNumber_data = data[4];
                String EmailId_data = data[5];
                String DOB_data = data[6];
                String CustomerID_data = data[7];
                String MembershipStatus_data = data[8];
                String DateOfJoining_data = data[9];

                String comment = data.length == 5 ? data[4] : "";

                statement.setInt(1, Integer.parseInt(loginid_data));
                statement.setInt(2, Integer.parseInt(password_data));
                statement.setString(3, FirstName_data);
                statement.setString(4, LastName_data);
                statement.setString(5, PhoneNumber_data);
                statement.setString(6, EmailId_data);
                statement.setDate(7, Date.valueOf(DOB_data));
                statement.setInt(8, Integer.parseInt(CustomerID_data));
                statement.setString(9, MembershipStatus_data);
                statement.setDate(10, Date.valueOf(DateOfJoining_data));

                statement.addBatch();

                if (count % batchSize == 0)
                {
                    statement.executeBatch();
                }
            }

            lineReader.close();
            statement.executeBatch();

            con.commit();
            con.close();
        }
        catch(SQLException | IOException e)
        {
            e.printStackTrace();
        }
    }

}
