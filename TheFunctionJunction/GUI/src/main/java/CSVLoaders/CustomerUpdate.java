package CSVLoaders;

import Database.DBconnection.Connect;

import java.io.*;
import java.sql.*;

public class CustomerUpdate {
    private static int batchSize = 50;
    static String csvFilePath="GUI/src/main/java/CSVLoaders/customer.csv";
    public static void UpdateCustomerCSV(String Loginid,String NewPassword) throws IOException {
        try{
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;
            int count = 0;
            int flag = 0;
//            lineReader.readLine(); // skip header line
            FileWriter Writer = new FileWriter("GUI/src/main/java/CSVLoaders/tempCustomer.csv");

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

                String newPassword = password_data;
                if (Loginid.compareTo(loginid_data) == 0) {
                    newPassword = NewPassword;
                }
                Writer.write(loginid_data + "," + newPassword + "," + FirstName_data + "," + LastName_data + "," + PhoneNumber_data + "," + EmailId_data + "," + DOB_data + "," + CustomerID_data + "," + MembershipStatus_data + "," + DateOfJoining_data + "\n");
            }
            Writer.close();
            lineReader.close();
            FileWriter writer1 = new FileWriter(csvFilePath);
            lineReader = new BufferedReader(new FileReader("GUI/src/main/java/CSVLoaders/tempCustomer.csv"));
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
            writer1.close();
            lineReader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
