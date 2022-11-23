package Database.TableView;

import javafx.application.Application;
import javafx.collections.FXCollections;
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

import java.sql.*;

import static Database.DBconnection.Connect.closeConnection;
import static Database.DBconnection.Connect.createConnection;


public class ManagerDatabase {
    private final TableView<BookingHistory>table=new TableView<BookingHistory>();
    private ObservableList<BookingHistory> data = FXCollections.observableArrayList();
    private ObservableList<BookingHistory> Cdata = FXCollections.observableArrayList();
    public ObservableList<BookingHistory> GetDetails() throws SQLException {

        try {
            Connection con1 = createConnection();
            String query = "Select * from bookingHistory";
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(query);
//            String d1=rs.getDate(6).toString();
//            String d2=rs.getDate(7).toString();
            while (rs.next()) {
                data.add(new BookingHistory(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getDate(6).toString(), rs.getDate(7).toString(),rs.getString(8)));
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
    public ObservableList<BookingHistory> GetCustomerDetails(String loginID) throws SQLException {

        try {
            Connection con1 = createConnection();
            String query1="select * from customer where loginid=?";
            String email="";
            PreparedStatement preStatement1=con1.prepareStatement(query1);
            preStatement1.setString(1,loginID);
            ResultSet rs1=preStatement1.executeQuery();
            if(rs1.next()){
                email=rs1.getString("emailid");
            }
            String query="select * from bookinghistory where email=?";
            PreparedStatement preStatement=con1.prepareStatement(query);
            preStatement.setString(1,email);
            ResultSet rs=preStatement.executeQuery();
            while (rs.next()) {
                Cdata.add(new BookingHistory(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getDate(6).toString(), rs.getDate(7).toString(),rs.getString(8)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return Cdata;
    }
//    @Override
//    public void start(Stage stage) throws Exception {
//        Scene scene = new Scene(new Group());
//        stage.setTitle("Table View Sample");
//        stage.setWidth(800);
//        stage.setHeight(500);
//
//        ObservableList<BookingHistory> data = GetDetails();
//
//        final Label label = new Label("Address Book");
//        label.setFont(new Font("Arial", 20));
//
//        table.setEditable(true);
//
//        TableColumn<BookingHistory,Integer> BID = new TableColumn<>("Booking ID");
//        BID.setMinWidth(100);
//        BID.setCellValueFactory(
//                new PropertyValueFactory<BookingHistory, Integer>("Booking_Id"));
//
//        TableColumn<BookingHistory,String> firstNameCol = new TableColumn<>("First Name");
//        firstNameCol.setMinWidth(100);
//        firstNameCol.setCellValueFactory(
//                new PropertyValueFactory<BookingHistory, String>("Name"));
//
//
//        TableColumn<BookingHistory,String> emailCol = new TableColumn<>("Email");
//        emailCol.setMinWidth(100);
//        emailCol.setCellValueFactory(
//                new PropertyValueFactory<BookingHistory, String>("email"));
//
//        TableColumn<BookingHistory,String> phonecol = new TableColumn<>("Phone Number");
//        phonecol.setMinWidth(100);
//        phonecol.setCellValueFactory(
//                new PropertyValueFactory<BookingHistory, String>("PhoneNumber"));
//
//        TableColumn<BookingHistory,String> hallname = new TableColumn<>("Hall Name");
//        hallname.setMinWidth(100);
//        hallname.setCellValueFactory(
//                new PropertyValueFactory<BookingHistory, String>("email"));
//
//        TableColumn<BookingHistory,Date> Sdate = new TableColumn<>("Start Date");
//        Sdate.setMinWidth(100);
//        Sdate.setCellValueFactory(
//                new PropertyValueFactory<BookingHistory, Date>("StartDate"));
//
//        TableColumn<BookingHistory,Date> Edate = new TableColumn<>("End Date");
//        Edate.setMinWidth(100);
//        Edate.setCellValueFactory(
//                new PropertyValueFactory<BookingHistory, Date>("EndDate"));
//
//        TableColumn<BookingHistory,String> Status = new TableColumn<>("Status");
//        Status.setMinWidth(100);
//        Status.setCellValueFactory(
//                new PropertyValueFactory<BookingHistory, String>("Status"));
//
//        table.setItems(data);
//        table.getColumns().addAll(firstNameCol, emailCol,hallname, Sdate,Edate,Status);
//
//        final VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(label, table);
//
//        ((Group) scene.getRoot()).getChildren().addAll(vbox);
//
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
}
