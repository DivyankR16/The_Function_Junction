package CSVLoaders;

import java.io.*;
import java.time.LocalDate;
public class changeCustomerCSV {
        public static void load_into_customer_csv(String FirstName,String LastName,String PhNo,String EmailID,String LoginId,String Password, String Dob,String CustID) throws IOException {
//    public static void main(String[] args) throws IOException {
        String csvFilePath = "GUI/src/main/java/CSVLoaders/customer.csv";
        File custcsv = new File(csvFilePath);
        System.out.println(custcsv.exists());
        FileWriter fileWriter = new FileWriter(csvFilePath,true);
        fileWriter.write("\n%s,%s,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",%s,\"%s\",\"%s\"".formatted(LoginId, Password,FirstName,LastName,PhNo,EmailID,Dob,CustID,"new", LocalDate.now()));
//        fileWriter.write("\n%s,%s,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",%s,\"%s\",\"%s\"".formatted("4567", "4567","Divyanshu","Jha","7878787878","DivyanshuJha@gmail.com","2003-11-17","1007","new", "2022-11-20"));
        fileWriter.close();
    }
}