package Database.TableView;

import Database.DBconnection.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BreakFast extends Menu
{
    private int NumberOfGuests;
    private double cost;

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    private String bf_class;

    public String getBf_class() {
        return bf_class;
    }

    public void setBf_class(String bf_class) {
        this.bf_class = bf_class;
    }

    public int getNumberOfGuests() {
        return NumberOfGuests;
    }
    public void setNumberOfGuests(int numberOfGuests) {
        NumberOfGuests = numberOfGuests;
    }

    @Override
    public double calculateCost() {
        Connection con= Connect.createConnection();
        try {
            Statement St = con.createStatement();
            String query = "Select * from Menue where type='Breakfast'";
            ResultSet rs=St.executeQuery(query);
            while (rs.next()){
                if (rs.getString(3).compareToIgnoreCase( this.bf_class)==0){
                    this.cost=rs.getDouble(5);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            Connect.closeConnection();
        }
        return this.getNumberOfGuests()*this.cost;

    }
}
