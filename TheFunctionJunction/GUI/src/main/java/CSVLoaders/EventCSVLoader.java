package CSVLoaders;

import Database.DBconnection.Connect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EventCSVLoader {
    private static int batchSize = 20;
    static String csvFilePath="GUI/src/main/java/CSVLoaders/Event.csv";
    static Connection con= Connect.createConnection();
    public static void LoadCSV()
    {
        try{
            Statement St = con.createStatement();
            con.setAutoCommit(false);
            String Query1="Drop table if exists event";
            String Query2="create table event(" +
                    "BookingID int," +
                    "CustomerId text," +
                    "Event_Name text," +
                    "cfname text," +
                    "clname text," +
                    "Email text," +
                    "Venue text," +
                    "Start_Date date," +
                    "End_Date date," +
                    "Expected_Cost numeric(10,2)" +
                    "PhoneNumber text," +
                    "Status text)";

            St.executeUpdate(Query1);
            St.executeUpdate(Query2);

            String Query3 = "INSERT INTO event (BookingID, CustomerId,Event_Name,cfname,clname,Email,Venue,Start_Date,End_Date,Expected_Cost, PhoneNumber,Status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(Query3);

            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String BookingID = data[0];
                String CustomerId = data[1];
                String Event_Name=data[2];
                String cfname = data[3];
                String clname = data[4];
                String Email=data[5];
                String Venue = data[6];
                String Start_Date = data[7];
                String End_Date=data[8];
                String Expected_Cost = data[9];
                String PhoneNumber = data[10];
                String Status=data[11];

                statement.setString(1, BookingID);
                statement.setString(2, CustomerId);
                statement.setString(3, Event_Name);
                statement.setString(4, cfname);
                statement.setString(5, clname);
                statement.setString(6, Email);
                statement.setString(7, Venue);
                statement.setString(8, Start_Date);
                statement.setString(9, End_Date);
                statement.setString(10, Expected_Cost);
                statement.setString(11, PhoneNumber);
                statement.setString(12, Status);


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
