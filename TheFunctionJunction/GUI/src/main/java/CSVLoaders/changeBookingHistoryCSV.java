package CSVLoaders;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class changeBookingHistoryCSV
{
    public static void load_into_customer_csv(String BookingID,String fname,String lname,String email,String phno,String Venu,String sd,String ed,String status) throws IOException {
        String csvFilePath = "GUI/src/main/java/CSVLoaders/bookinghistory.csv";
        File custcsv = new File(csvFilePath);
        System.out.println(custcsv.exists());
        FileWriter fileWriter = new FileWriter(csvFilePath,true);
        fileWriter.write("\n%s,%s,%s,%s,%s,%s,%s,%s".formatted(BookingID,fname,email,phno,Venu,sd,ed,status));
        fileWriter.close();
    }
}
