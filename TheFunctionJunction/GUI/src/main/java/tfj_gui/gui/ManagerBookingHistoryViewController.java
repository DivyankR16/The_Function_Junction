package tfj_gui.gui;

import Database.DBconnection.Connect;
import Database.TableView.BookingHistory;
import Database.TableView.ManagerDatabase;
import Database.TableView.Venue;
import Login.Manager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManagerBookingHistoryViewController implements Initializable {
    @FXML
    private Button HomeButton;
    @FXML
    private Button NewBookingButton;
    @FXML
    private Button MyAccountButton;
    @FXML
    private Button MyBookingsButton;
    @FXML
    private Button ChangePasswordButton;
    @FXML
    private Button AboutUsButton;
    @FXML
    private Button HelpButton;
    @FXML
    private Button LogoutButton;
    @FXML
    private Button ExitButton;
    @FXML
    private TableColumn<BookingHistory,String> BookingIdColumn;
    @FXML
    private TableColumn<BookingHistory,String> NameColumn;
    @FXML
    private TableColumn<BookingHistory,String> EmailColumn;
    @FXML
    private TableColumn<BookingHistory,String> PhoneNumberColumn;
    @FXML
    private TableColumn<BookingHistory,String> VenueColumn;
    @FXML
    private TableColumn<BookingHistory,String> StartDateColumn;
    @FXML
    private TableColumn<BookingHistory,String> EndDateColumn;
    @FXML
    private TableColumn<BookingHistory,String> StatusColumn;
//    @FXML
//    private TableView tableview = new TableView();

    @FXML
    protected void GoToHome(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.GoToHome(event);
    }
    @FXML
    protected void NewBookingButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.NewBookingButtonClicked(event);
    }
    @FXML
    protected void MyAccountButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.MyAccountButtonClicked(event);
    }
    @FXML
    private TableView<BookingHistory> tableview;
    @FXML
    protected void MyBookingsButtonClicked(ActionEvent event) throws IOException
    {
//        buildData();
//        ManagerControllerFunctions.MyBookingsButtonClicked(event);
////        Scene scene2 = new Scene(tableview);
////        Stage stage2 = new Stage();
////        stage2.setScene(scene2);
////        stage2.show();
    }
    @FXML
    protected void ChangePasswordButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.ChangePasswordButtonClicked(event);
    }
    @FXML
    protected void AboutUsButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.AboutUsButtonClicked(event);
    }
    @FXML
    protected void HelpButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.HelpButtonClicked(event);
    }
    @FXML
    protected void LogoutButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.LogoutButtonClicked(event);
    }
    @FXML
    protected void ExitButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.ExitButtonClicked(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BookingIdColumn.setCellValueFactory(new PropertyValueFactory<>("BookinID"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        EmailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
        PhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        VenueColumn.setCellValueFactory(new PropertyValueFactory<>("HallName"));
        StartDateColumn.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
        EndDateColumn.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
        ManagerDatabase m=new ManagerDatabase();
        try {
            tableview.setItems(m.GetDetails());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    @FXML
//    protected void BH() throws SQLException {
//        TableView<BookingHistory> table = new TableView<BookingHistory>();
//
//        table.setEditable(true);
//
//        ObservableList<BookingHistory> data = (ObservableList<BookingHistory>) ManagerDatabase.GetDetails();
//        NameColumn = new TableColumn("Name");
//        NameColumn.setMinWidth(100);
//        NameColumn.setCellValueFactory(new PropertyValueFactory<BookingHistory, String>("Name"));
//
//        EmailColumn = new TableColumn("Email");
//        EmailColumn.setMinWidth(100);
//        EmailColumn.setCellValueFactory(new PropertyValueFactory<BookingHistory, String>("email"));
//
//        PhoneNumberColumn = new TableColumn("Phone Number");
//        PhoneNumberColumn.setMinWidth(100);
//        PhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<BookingHistory, String>("PhoneNumber"));
//
//        VenueColumn = new TableColumn("Hall Name");
//        VenueColumn.setMinWidth(100);
//        VenueColumn.setCellValueFactory(new PropertyValueFactory<BookingHistory, String>("email"));
//
//        StartDateColumn = new TableColumn("Start Date");
//        StartDateColumn.setMinWidth(100);
//        StartDateColumn.setCellValueFactory(new PropertyValueFactory<BookingHistory, String>("StartDate"));
//
//        EndDateColumn = new TableColumn("End Date");
//        EndDateColumn.setMinWidth(100);
//        EndDateColumn.setCellValueFactory(new PropertyValueFactory<BookingHistory, String>("EndDate"));
//
//        table.setItems(data);
//        table.getColumns().addAll(NameColumn, EmailColumn, PhoneNumberColumn, VenueColumn, StartDateColumn,EndDateColumn);
//    }

//    private ObservableList<ObservableList> data;
////    private TableView tableview;
//    public void buildData()
//    {
//        Connection c ;
//        data = FXCollections.observableArrayList();
//        try{
//            c = Connect.createConnection();
//            //SQL FOR SELECTING ALL OF CUSTOMER
//            String SQL = "SELECT * from BookingHistory";
//            //ResultSet
//            ResultSet rs = c.createStatement().executeQuery(SQL);
//
//            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++)
//            {
//                //We are using non property style for making dynamic table
//                final int j = i;
//                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
//                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>()
//                    {public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param)
//                        {return new SimpleStringProperty(param.getValue().get(j).toString());}
//                    }
//                );
//                tableview.getColumns().addAll(col);
//                System.out.println("Column ["+i+"] ");
//            }
//
//            while(rs.next()){
//                //Iterate Row
//                ObservableList<String> row = FXCollections.observableArrayList();
//                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
//                    //Iterate Column
//                    row.add(rs.getString(i));
//                }
//                System.out.println("Row [1] added "+row );
//                data.add(row);
//            }
//            //FINALLY ADDED TO TableView
//            tableview.setItems(data);
//            System.out.println(tableview.getItems());
//        }catch(Exception e){
//            e.printStackTrace();
//            System.out.println("Error on Building Data");
//        }
//        finally {
//            Connect.closeConnection();
//        }
//    }
}