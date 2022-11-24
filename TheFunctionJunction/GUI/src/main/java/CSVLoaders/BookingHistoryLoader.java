package CSVLoaders;

import Database.DBconnection.Connect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingHistoryLoader
{
    private static int batchSize = 20;
    static String csvFilePath="GUI/src/main/java/CSVLoaders/bookinghistory.csv";
    static Connection con= Connect.createConnection();
    public static void LoadCSV()
    {
        try{
            Statement St = con.createStatement();
            con.setAutoCommit(false);
            String Query1="Drop table if exists bookinghistory";
            String Query2="create table bookinghistory(" +
                    "BookingID text," +
                    "Name text," +
                    "Email text," +
                    "PhoneNumber text," +
                    "Venue text," +
                    "StartDate date,"+
                    "EndDate date)";

            St.executeUpdate(Query1);
            St.executeUpdate(Query2);

            String Query3 = "INSERT INTO bookinghistory (BookingID, Name, Email, PhoneNumber,Venue, StartDate,EndDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(Query3);

            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String bid = data[0];
                String name_data = data[1];
                String email_data = data[2];
                String phno_data = data[3];
                String venue_data=data[4];
                String sd_data = data[5];
                String ed_data = data[6];

                statement.setString(1, bid);
                statement.setString(2, name_data);
                statement.setString(3, email_data);
                statement.setString(4, phno_data);
                statement.setString(5, venue_data);
                statement.setString(6, sd_data);
                statement.setString(7, ed_data);

                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }
            lineReader.close();
            statement.executeBatch();
            con.commit();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
