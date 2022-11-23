package tfj_gui.gui;

import Database.TableView.BookingHistory;
import Database.TableView.ManagerDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyBookingsViewController implements Initializable {
    @FXML
    private TableColumn<BookingHistory,String> BookingID;
    @FXML
    private TableColumn<BookingHistory,String> Status;
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
    private TableView<BookingHistory> tableview;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        EmailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
        PhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        VenueColumn.setCellValueFactory(new PropertyValueFactory<>("HallName"));
        StartDateColumn.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
        EndDateColumn.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        BookingID.setCellValueFactory(new PropertyValueFactory<>("BookinID"));
        ManagerDatabase m=new ManagerDatabase();
        Send_Data_Between need=Send_Data_Between.getInstance();
        try {
            tableview.setItems(m.GetCustomerDetails(need.getCustomer().getLoginId()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
