package Database.TableView;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static Database.DBconnection.Connect.closeConnection;
import static Database.DBconnection.Connect.createConnection;

class BookingHistory{
    private String Name;
    private String Email;
    private String PhoneNumber;
    private String HallName;
    private Date StartDate;
    private Date EndDate;

    public BookingHistory(String name, String email, String phoneNumber, String hallName, Date startDate, Date endDate) {
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
        HallName = hallName;
        StartDate = startDate;
        EndDate = endDate;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getHallName() {
        return HallName;
    }

    public void setHallName(String hallName) {
        HallName = hallName;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }


}

public class ManagerDatabase extends Application {

    private TableView<BookingHistory> table = new TableView<BookingHistory>();

    public ArrayList<BookingHistory> GetDetails() throws SQLException {
        ArrayList<BookingHistory> data = new ArrayList<>();
        try {
            Connection con1 = createConnection();
            String query = "Select * from bookingHistory";
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                data.add(new BookingHistory(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getDate(5), rs.getDate(6)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return data;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(700);
        stage.setHeight(500);

        ObservableList<BookingHistory> data = (ObservableList<BookingHistory>) GetDetails();

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<BookingHistory, String>("Name"));


        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(100);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<BookingHistory, String>("email"));

        TableColumn phonecol = new TableColumn("Phone Number");
        emailCol.setMinWidth(100);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<BookingHistory, String>("PhoneNumber"));

        TableColumn hallname = new TableColumn("Hall Name");
        emailCol.setMinWidth(100);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<BookingHistory, String>("email"));

        TableColumn Sdate = new TableColumn("Start Date");
        emailCol.setMinWidth(100);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<BookingHistory, String>("StartDate"));

        TableColumn Edate = new TableColumn("End Date");
        emailCol.setMinWidth(100);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<BookingHistory, String>("EndDate"));

        table.setItems(data);
        table.getColumns().addAll(firstNameCol, emailCol,hallname, Sdate,Edate);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

}
