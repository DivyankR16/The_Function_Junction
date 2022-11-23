package CSVLoaders;

import Database.DBconnection.Connect;

import java.io.*;
import java.sql.*;

public class ManagerUpdate {
    private static int batchSize = 20;
    static String csvFilePath="GUI/src/main/java/CSVLoaders/manager.csv";
    public static void UpdateCSV(String loginid,String NewPassword){
        try{
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;
            int flag=0;
//            lineReader.readLine(); // skip header line
            FileWriter Writer= new FileWriter("GUI/src/main/java/CSVLoaders/tempManger.csv");
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String FirstName = data[0];
                String LastName = data[1];
                String PhoneNumber = data[2];
                String emailID = data[3];
                String LoginID = data[4];
                String Password = data[5];
                String newPassword=Password;
                String DOB=data[6];

                if (loginid.compareTo(LoginID)==0) {
                    newPassword=NewPassword;
                }
                Writer.write(FirstName+","+LastName+","+PhoneNumber+","+emailID+","+LoginID+","+newPassword+","+DOB+"\n");
            }
            Writer.close();
            lineReader.close();
            FileWriter writer1=new FileWriter(csvFilePath);
            lineReader=new BufferedReader(new FileReader("GUI/src/main/java/CSVLoaders/tempManger.csv"));
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String FirstName = data[0];
                String LastName = data[1];
                String PhoneNumber = data[2];
                String emailID = data[3];
                String LoginID = data[4];
                String Password = data[5];
                String DOB = data[6];
                writer1.write(FirstName+","+LastName+","+PhoneNumber+","+emailID+","+LoginID+","+Password+","+DOB+"\n");
            }
            writer1.close();
            lineReader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    }


