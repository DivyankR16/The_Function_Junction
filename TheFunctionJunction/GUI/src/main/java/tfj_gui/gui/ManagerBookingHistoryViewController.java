package tfj_gui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import java.io.IOException;

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
    protected void GoToHome(ActionEvent event) throws IOException
    {
        ControllerFunctions.GoToHome(event);
    }
    @FXML
    protected void NewBookingButtonClicked(ActionEvent event) throws IOException
    {
        ControllerFunctions.NewBookingButtonClicked(event);
    }
    @FXML
    protected void MyAccountButtonClicked(ActionEvent event) throws IOException
    {
        ControllerFunctions.MyAccountButtonClicked(event);
    }
    @FXML
    protected void MyBookingsButtonClicked(ActionEvent event) throws IOException
    {
        ControllerFunctions.MyBookingsButtonClicked(event);
    }
    @FXML
    protected void ChangePasswordButtonClicked(ActionEvent event) throws IOException
    {
        ControllerFunctions.ChangePasswordButtonClicked(event);
    }
    @FXML
    protected void AboutUsButtonClicked(ActionEvent event) throws IOException
    {
        ControllerFunctions.AboutUsButtonClicked(event);
    }
    @FXML
    protected void HelpButtonClicked(ActionEvent event) throws IOException
    {
        ControllerFunctions.HelpButtonClicked(event);
    }
    @FXML
    protected void LogoutButtonClicked(ActionEvent event) throws IOException {
        ControllerFunctions.LogoutButtonClicked(event);
    }
    @FXML
    protected void ExitButtonClicked(ActionEvent event) throws IOException
    {
        ControllerFunctions.ExitButtonClicked(event);
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
}