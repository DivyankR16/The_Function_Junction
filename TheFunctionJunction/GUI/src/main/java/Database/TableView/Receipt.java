package Database.TableView;
import Database.DBconnection.Connect;

import java.io.*;
import java.sql.*;

public class Receipt {
    public void PrintReceipt(String bookingID){
        try{
            String Name="";
            String EventName="";
            Date SDate = null;
            Date EDate = null;
            double cost = 0;
            Connection con= Connect.createConnection();
            Statement St = con.createStatement();
            String query = "Select * from Event";
            ResultSet rs=St.executeQuery(query);
            while (rs.next()){
                if (rs.getString(1)==bookingID){
                    Name= rs.getString(2);
                    EventName=rs.getString(3);
                    SDate=rs.getDate(4);
                    EDate=rs.getDate(5);
                    cost= rs.getDouble(6);
                }
            }
            FileWriter Writer
                    = new FileWriter(bookingID+"_Recipt.txt");
            Writer.write("Booking ID:- "+bookingID+"\n");
            Writer.write("Booked by:- "+Name+"\n");
            Writer.write("Type:- "+EventName+"\n");
            Writer.write("Start Date:- "+SDate+"\n");
            Writer.write("End date:- "+EDate+"\n");
            Writer.write("Total cost:- "+cost+"\n");
            Writer.close();


        }
        catch(SQLException|IOException e){
            e.printStackTrace();
        }
    }

}
