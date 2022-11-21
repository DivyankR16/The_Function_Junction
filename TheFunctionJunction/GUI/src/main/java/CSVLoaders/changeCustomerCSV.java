package CSVLoaders;

import java.io.*;
import java.time.LocalDate;
public class changeCustomerCSV {
        public static void load_into_customer_csv(String FirstName,String LastName,String PhNo,String EmailID,String LoginId,String Password, String Dob,String CustID) throws IOException {
        String csvFilePath = "GUI/src/main/java/CSVLoaders/customer.csv";
        FileWriter fileWriter = new FileWriter(csvFilePath,true);
        fileWriter.write("\n%s,%s,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",%s,\"%s\",\"%s\"".formatted(LoginId, Password,FirstName,LastName,PhNo,EmailID,Dob,CustID,"new", LocalDate.now()));
        fileWriter.close();
    }
}