package CSVLoaders;

import Database.DBconnection.Connect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class ManagerLoader {
    private static int batchSize = 20;
    static String csvFilePath="GUI/src/main/java/CSVLoaders/manager.csv";
    static Connection con= Connect.createConnection();
    public static void LoadCSV()
    {
        try{
            Statement St = con.createStatement();
            con.setAutoCommit(false);
            String Query1="Drop table if exists manager";
            String Query2="create table manager(" +
                    "FirstName text," +
                    "LastName text," +
                    "PhoneNumber text," +
                    "emailID text," +
                    "LoginID text," +
                    "Password text"+
                    "DOB date)";

            St.executeUpdate(Query1);
            St.executeUpdate(Query2);

            String Query3 = "INSERT INTO manager (FirstName, LastName, PhoneNumber, emailID,LoginID, Password) VALUES (?, ?, ?, ?, ?,?)";
            PreparedStatement statement = con.prepareStatement(Query3);

            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String FirstName = data[0];
                String LastName = data[1];
                String PhoneNumber = data[2];
                String emailID = data[3];
                String LoginID=data[4];
                String Password = data[5];

                statement.setString(1, FirstName);
                statement.setString(2, LastName);
                statement.setString(3, PhoneNumber);
                statement.setString(4, emailID);
                statement.setString(5, LoginID);
                statement.setString(6, Password);

                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }

            lineReader.close();

            // execute the remaining queries
            statement.executeBatch();

            con.commit();
            con.close();

        }
        catch(SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
