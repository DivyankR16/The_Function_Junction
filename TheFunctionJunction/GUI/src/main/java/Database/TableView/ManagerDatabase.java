package Database.TableView;

import java.sql.*;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static Database.DBconnection.Connect.createConnection;

class BookingHistory{
    private String Name;
    private String Email;
    private String HallName;
    private Date StartDate;

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

    private Date EndDate;

    public BookingHistory(String name, String email, String hallName, Date startDate, Date endDate) {
        Name = name;
        Email = email;
        HallName = hallName;
        StartDate = startDate;
        EndDate = endDate;
    }
}

public class ManagerDatabase extends Application {
    private ObservableList<BookingHistory> data;
    private TableView<BookingHistory> table = new TableView<BookingHistory>();

    public void GetDetails() throws SQLException {
        Connection con1= createConnection();
        String query="Select * from bookingHistory";
        Statement st=con1.createStatement();
        ResultSet rs=st.executeQuery(query);
        while (rs.next()){
            data.add(new BookingHistory(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getDate(5)));
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(700);
        stage.setHeight(500);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<BookingHistory, String>("Name"));


        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<BookingHistory, String>("email"));

        TableColumn hallname = new TableColumn("Hall Name");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<BookingHistory, String>("email"));

        TableColumn Sdate = new TableColumn("Start Date");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<BookingHistory, String>("StartDate"));

        TableColumn Edate = new TableColumn("End Date");
        emailCol.setMinWidth(200);
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
