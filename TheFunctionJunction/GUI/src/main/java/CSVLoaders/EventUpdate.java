package CSVLoaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class EventUpdate {
    public static void load_into_event_csv(String BookingID,String  CustomerId,String Event_Name,String cfname,String clname,String Email,String Venue,String Start_Date,String End_Date,String Expected_Cost,String PhoneNumber,String Status)
    {
        try {
            String csvFilePath = "GUI/src/main/java/CSVLoaders/Event.csv";
            FileWriter fileWriter = new FileWriter(csvFilePath,true);
            fileWriter.write("\n%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s".formatted(BookingID, CustomerId,Event_Name,cfname,clname,Email,PhoneNumber,Venue,Start_Date,End_Date,Expected_Cost,Status));
            fileWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void CancelEvent(String bookingID)
    {
        try {
            String csvFilePath = "GUI/src/main/java/CSVLoaders/Event.csv";;
            FileWriter Writer= new FileWriter("GUI/src/main/java/CSVLoaders/tempevent.csv");
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                System.out.println(Arrays.toString(data));
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
                Writer.write(BookingID+ "," +  CustomerId+ "," + Event_Name+ "," + cfname+ "," + clname+ "," + Email+ ","+PhoneNumber+"," + Venue+ "," + Start_Date+ "," + End_Date+ "," + Expected_Cost+ ","  + Status+"\n");
            }
            lineReader.close();
            Writer.close();
            FileWriter writer1=new FileWriter(csvFilePath);
            lineReader=new BufferedReader(new FileReader("GUI/src/main/java/CSVLoaders/tempevent.csv"));
            while ((lineText = lineReader.readLine()) != null)
            {
                String[] data = lineText.split(",");
                System.out.println(Arrays.toString(data));
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
                if (bookingID.compareTo(BookingID)!=0)
                {
                    writer1.write(BookingID+ "," +  CustomerId+ "," + Event_Name+ "," + cfname+ "," + clname+ "," + Email+ ","+PhoneNumber+"," + Venue+ "," + Start_Date+ "," + End_Date+ "," + Expected_Cost+ ","+"cancelled" +"\n");
                }
                else
                {
                    writer1.write(BookingID+ "," +  CustomerId+ "," + Event_Name+ "," + cfname+ "," + clname+ "," + Email+ ","+PhoneNumber+"," + Venue+ "," + Start_Date+ "," + End_Date+ "," + Expected_Cost+ ","  + Status+"\n");
                }
            }
            writer1.close();
            lineReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        }

}
