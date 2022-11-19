package tfj_gui.gui;

import Database.DBconnection.Connect;
import Login.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Search {
    public static ObservableList<Customer> getCustNames(String userInput) throws SQLException {
        ObservableList<Customer>listNames= FXCollections.observableArrayList();
        Connection con= Connect.createConnection();
        Statement stmt= con.createStatement();
        String query="Select * from customer";
        ResultSet rs= stmt.executeQuery(query);
        while(rs.next()){
            if(isSubsequence(userInput,rs.getString(3)+rs.getString(4))){
                listNames.add(new Customer(rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(1),rs.getString(2),rs.getString(7),rs.getString(9)));
            }
        }
        return listNames;
    }
    public static boolean isSubsequence(String userInput,String custName){
        int i=0;
        int j=0;
        userInput= userInput.toLowerCase();
        while(i<userInput.length() && j<custName.length()){
            if(userInput.charAt(i)==custName.toLowerCase().charAt(j)){
                i++;
            }
            j++;
        }
        return i == userInput.length();
    }
}
