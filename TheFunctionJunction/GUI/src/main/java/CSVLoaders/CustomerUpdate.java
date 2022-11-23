package CSVLoaders;

import Database.DBconnection.Connect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class CustomerUpdate {
    private int batchSize = 50;
    static String csvFilePath="GUI/src/main/java/CSVLoaders/customer.csv";
    Connection con= Connect.createConnection();
    public void UpdateCustomerCSV(int Loginid,String NewPassword){
        try{
            Statement St = con.createStatement();
            con.setAutoCommit(false);
            String Query1="Drop table if exist customer";
            String Query2="create table customer(loginid TEXT, password TEXT, FirstName TEXT, LastName TEXT, PhoneNumber TEXT, EmailId TEXT, DOB DATE, CustomerID INT, MembershipStatus TEXT, DateOfJoining DATE)" ;
            St.executeUpdate(Query1);
            St.executeUpdate(Query2);

            String Query3 = "INSERT INTO customer (loginid, password, FirstName, LastName, PhoneNumber, EmailId, DOB, CustomerID, MembershipStatus, DateOfJoining ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(Query3);
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;
            int flag=0;

//            lineReader.readLine(); // skip header line
            FileWriter Writer= new FileWriter("tempCustomer.csv");

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

                String newPassword=password_data;
                if (Loginid==Integer.parseInt(loginid_data)) {
                    newPassword=NewPassword;
                }
                Writer.write(loginid_data+","+newPassword+","+FirstName_data+","+LastName_data+","+PhoneNumber_data+","+EmailId_data+","+DOB_data+","+CustomerID_data+","+MembershipStatus_data+","+DateOfJoining_data+"\n");
                if (flag != 0) {
                    statement.setString(1, loginid_data);
                    statement.setString(2, newPassword);
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

                flag++;
            }

            lineReader.close();
            statement.executeBatch();

            con.commit();
            con.close();
            FileWriter writer1=new FileWriter(csvFilePath);
            lineReader=new BufferedReader(new FileReader("tempCustomer.csv"));
            while ((lineText = lineReader.readLine()) != null) {
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

                writer1.write(loginid_data + "," + password_data + "," + FirstName_data + "," + LastName_data + "," + PhoneNumber_data + "," + EmailId_data + "," + DOB_data + "," + CustomerID_data + "," + MembershipStatus_data + "," + DateOfJoining_data + "\n");

            }
        }
        catch(SQLException | IOException e)
        {
            e.printStackTrace();
        }
    }

}
