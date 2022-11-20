package CSVLoaders;

import Database.DBconnection.Connect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class ManagerLoader {
    private int batchSize = 20;
    static String csvFilePath="";
    Connection con= Connect.createConnection();
    public void LoadCSV(){
        try{
            Statement St = con.createStatement();
            con.setAutoCommit(false);
            String Query1="Drop table if exist Manager";
            String Query2="create table manager(" +
                    "FirstName text," +
                    "LastName text," +
                    "PhoneNumber INT,'" +
                    "emailID text," +
                    "LoginID int," +
                    "Password int)";

            St.executeQuery(Query1);
            St.executeQuery(Query2);

            String Query3 = "INSERT INTO review (course_name, student_name, timestamp, rating, comment) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(Query3);

            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String courseName = data[0];
                String studentName = data[1];
                String timestamp = data[2];
                String rating = data[3];
                String comment = data.length == 5 ? data[4] : "";

                statement.setString(1, courseName);
                statement.setString(2, studentName);

                Timestamp sqlTimestamp = Timestamp.valueOf(timestamp);
                statement.setTimestamp(3, sqlTimestamp);

                Float fRating = Float.parseFloat(rating);
                statement.setFloat(4, fRating);

                statement.setString(5, comment);

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
