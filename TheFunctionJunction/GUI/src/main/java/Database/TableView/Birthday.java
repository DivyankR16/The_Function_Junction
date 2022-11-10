package Database.TableView;

import Database.DBconnection.Connect;

import java.sql.*;
import java.util.ArrayList;

public class Birthday extends Event{
    private int age;
    private String cake;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCake() {
        return cake;
    }

    public void setCake(String cake) {
        this.cake = cake;
    }

    public Birthday() {
    }

    public Birthday(int age, String cake) {
        this.age = age;
        this.cake = cake;
    }

    public Birthday(Date startDate, Date endDate, Venue venue, String bookingStatus, ArrayList<Menu> menus, int age, String cake) {
        super(startDate, endDate, venue, bookingStatus, menus);
        this.age = age;
        this.cake = cake;
    }

    public double getCostCake(){
        Connection con= Connect.createConnection();
        double cost=0;
        try {
            Statement St= con.createStatement();
            String query="select * from cakes";
            ResultSet rs=St.executeQuery(query);
            while (rs.next()){
                if (this.cake == rs.getString(1)) {
                    cost=rs.getDouble(2);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            Connect.closeConnection();
        }
        return cost;
    }
    @Override
    double CalculateCost() {
        return 0;
    }
}
