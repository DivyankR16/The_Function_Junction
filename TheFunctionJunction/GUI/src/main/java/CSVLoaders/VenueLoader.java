package CSVLoaders;

import Database.DBconnection.Connect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class VenueLoader
{
    private static int batchSize = 10;
    static String csvFilePath="GUI/src/main/java/CSVLoaders/venue.csv";
    static Connection con= Connect.createConnection();
    public static void LoadCSV(){
        try{
            Statement St = con.createStatement();
            con.setAutoCommit(false);
            String Query1="Drop table if exists venue";
            String Query2="create table venue(venuid TEXT, name TEXT, capacity INT, price_per_day INT, description TEXT)" ;
            St.executeUpdate(Query1);
            St.executeUpdate(Query2);

            String Query3 = "INSERT INTO venue(venuid, name, capacity, price_per_day, description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(Query3);
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null)
            {
                String[] data = lineText.split(",");
                String venuid_data = data[0];
                String name_data = data[1];
                String capacity_data = data[2];
                String price_per_day_data = data[3];
                String description_data = data[4];

                String comment = data.length == 5 ? data[4] : "";

                statement.setInt(1, Integer.parseInt(venuid_data));
                statement.setString(2, name_data);
                statement.setInt(3, Integer.parseInt(capacity_data));
                statement.setInt(4, Integer.parseInt(price_per_day_data));
                statement.setString(5, description_data);

                statement.addBatch();
//                if (count % batchSize == 0)
//                {
                statement.executeBatch();
//                }
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
