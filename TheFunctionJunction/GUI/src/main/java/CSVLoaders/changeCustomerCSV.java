package CSVLoaders;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class changeCustomerCSV {
        public static void load_into_customer_csv(String FirstName,String LastName,String PhNo,String EmailID,String LoginId,String Password, String Dob,String CustID) throws IOException
        {
            String csvFilePath = "GUI/src/main/java/CSVLoaders/customer.csv";
            FileWriter fileWriter = new FileWriter(csvFilePath,true);
            fileWriter.write("\n%s,%s,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",%s,\"%s\",\"%s\"".formatted(LoginId, Password,FirstName,LastName,PhNo,EmailID,Dob,CustID,"new", LocalDate.now()));
            fileWriter.close();
        }
        public static void load_outof_customer_csv(String lgid) throws IOException
        {
//            String csvFilePath = "GUI/src/main/java/CSVLoaders/customer.csv";;
//            FileWriter Writer= new FileWriter("tempCustomer.csv");
//            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
//            String lineText = null;
//            while ((lineText = lineReader.readLine()) != null) {
//                String[] data = lineText.split(",");
//                String loginid_data = data[0];
//                String password_data = data[1];
//                String FirstName_data = data[2];
//                String LastName_data = data[3];
//                String PhoneNumber_data = data[4];
//                String EmailId_data = data[5];
//                String DOB_data = data[6];
//                String CustomerID_data = data[7];
//                String MembershipStatus_data = data[8];
//                String DateOfJoining_data = data[9];
////                Writer.write("\n%s,%s,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",%s,\"%s\",\"%s\"".formatted(loginid_data, password_data,FirstName_data,LastName_data,PhoneNumber_data,EmailId_data,DOB_data,CustomerID_data,MembershipStatus_data, DateOfJoining_data));
//                Writer.write(loginid_data+","+password_data+","+FirstName_data+","+LastName_data+","+PhoneNumber_data+","+EmailId_data+","+DOB_data+","+CustomerID_data+","+MembershipStatus_data+","+DateOfJoining_data+"\n");
//            }
//            lineReader.close();
//            Writer.close();
//            FileWriter writer1=new FileWriter(csvFilePath);
//            lineReader=new BufferedReader(new FileReader("tempCustomer.csv"));
//            while ((lineText = lineReader.readLine()) != null)
//            {
//                String[] data = lineText.split(",");
//                System.out.println(Arrays.toString(data));
//                String loginid_data = data[0];
//                String password_data = data[1];
//                String FirstName_data = data[2];
//                String LastName_data = data[3];
//                String PhoneNumber_data = data[4];
//                String EmailId_data = data[5];
//                String DOB_data = data[6];
//                String CustomerID_data = data[7];
//                String MembershipStatus_data = data[8];
//                String DateOfJoining_data = data[9];
//                if ((loginid_data.compareTo(lgid))!=0)
//                {
//                    writer1.write(loginid_data + "," + password_data + "," + FirstName_data + "," + LastName_data + "," + PhoneNumber_data + "," + EmailId_data + "," + DOB_data + "," + CustomerID_data + "," + MembershipStatus_data + "," + DateOfJoining_data + "\n");
//                }
//                else
//                {
//                    continue;
//                }
//            }
//            writer1.close();
//            lineReader.close();
            String csvFilePath = "GUI/src/main/java/CSVLoaders/customer.csv";;
            FileWriter Writer= new FileWriter("GUI/src/main/java/CSVLoaders/tempcustomer.csv");
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                System.out.println(Arrays.toString(data));
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
                Writer.write(loginid_data+","+password_data+","+FirstName_data+","+LastName_data+","+PhoneNumber_data+","+EmailId_data+","+DOB_data+","+CustomerID_data+","+MembershipStatus_data+","+DateOfJoining_data+"\n");
            }
            lineReader.close();
            Writer.close();
            FileWriter writer1=new FileWriter(csvFilePath);
            lineReader=new BufferedReader(new FileReader("GUI/src/main/java/CSVLoaders/tempcustomer.csv"));
            while ((lineText = lineReader.readLine()) != null)
            {
                String[] data = lineText.split(",");
                System.out.println(Arrays.toString(data));
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
                if (loginid_data.compareTo(lgid)!=0)
                {
                    writer1.write(loginid_data + "," + password_data + "," + FirstName_data + "," + LastName_data + "," + PhoneNumber_data + "," + EmailId_data + "," + DOB_data + "," + CustomerID_data + "," + MembershipStatus_data + "," + DateOfJoining_data + "\n");
                }
                else
                {
                    continue;
                }
            }
            writer1.close();
            lineReader.close();
        }
}