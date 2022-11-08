package tfj_gui.gui;

import Database.DBconnection.Connect;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

public class ManagerBookingHistoryViewController {
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
    private TableColumn BookingIdColumn;
    @FXML
    private TableColumn NameColumn;
    @FXML
    private TableColumn EmailColumn;
    @FXML
    private TableColumn PhoneNumberColumn;
    @FXML
    private TableColumn VenueColumn;
    @FXML
    private TableColumn StartDateColumn;
    @FXML
    private TableColumn EndDateColumn;
    @FXML
    private TableColumn StatusColumn;
    @FXML
    private TableView tableview = new TableView();

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
//    TableView tableview = new TableView();
    @FXML
    protected void MyBookingsButtonClicked(ActionEvent event) throws IOException
    {
//        buildData();
        ManagerControllerFunctions.MyBookingsButtonClicked(event);
//        Scene scene = new Scene(tableview);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
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