package tfj_gui.gui;

import Database.TableView.ManagerDatabase;
import Login.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Manager_search_ViewController implements Initializable {
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
    private TableColumn<Customer,String> Fname;
    @FXML
    private TableColumn<Customer,String> Lname;
    @FXML
    private TableColumn<Customer,String> EmailId;
    @FXML
    private TableColumn<Customer,String> PhoneNo;
    @FXML
    private TableColumn<Customer,String> Loginid;
    @FXML
    private TableColumn <Customer,String>Password;
    @FXML
    private TableColumn<Customer,String> DoB;
    @FXML
    private TableColumn<Customer,String> Mstatus;
    @FXML
    private TableView<Customer> tableview;

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
    protected void MyBookingsButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.MyBookingsButtonClicked(event);
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
        Fname.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        Lname.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        EmailId.setCellValueFactory(new PropertyValueFactory<>("EmailId"));
        PhoneNo.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        Loginid.setCellValueFactory(new PropertyValueFactory<>("LoginId"));
        Password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        DoB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        Mstatus.setCellValueFactory(new PropertyValueFactory<>("MembershipStatus"));
        try {
            Send_Data_Between need=Send_Data_Between.getInstance();
            tableview.setItems(Search.getCustNames(need.getSearchInput()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
