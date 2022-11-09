package tfj_gui.gui;

import Database.DBconnection.Connect;
import Login.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.Callable;

public class Signup_View_Controller
{
    static int custid=1000;
    @FXML
    private TextField FirstNameTF;
    @FXML
    private TextField LastNameTF;
    @FXML
    private TextField EmailIdTF;
    @FXML
    private TextField PhoneNumberTF;
    @FXML
    private Button SignUpFinalButton;
    @FXML
    private CheckBox ConfirmDetailsCheckbox;
    @FXML
    private DatePicker DOBTF;
    @FXML
    private PasswordField PasswordTF;
    @FXML
    private TextField LoginIdTF;
    @FXML
    private Button AvailableButton;
    @FXML
    private Button LoginButton;
    @FXML
    private Label AvailabilityLabel;
    @FXML
    protected void AvailableButtonClicked()
    {
        Customer c = new Customer(FirstNameTF.getText(), LastNameTF.getText(),PhoneNumberTF.getText(),EmailIdTF.getText(),LoginIdTF.getText(),PasswordTF.getText(),dob);
        if (c.Availability(LoginIdTF.getText()))
        {
            AvailabilityLabel.setText("Available!!!");
        }
        else AvailabilityLabel.setText("Not Available!!!");
    }
    @FXML
    private void LoginButtonClicked(ActionEvent event) throws IOException {
        ManagerControllerFunctions.LogoutButtonClicked(event);
    }
    LocalDate dob;
    @FXML
    protected void getDateFromPicker(ActionEvent event)
    {
        dob = DOBTF.getValue();
    }
    @FXML
    private void SignUpFinalButtonClicked()
    {
        Customer c1 = new Customer(FirstNameTF.getText(), LastNameTF.getText(),PhoneNumberTF.getText(),EmailIdTF.getText(),LoginIdTF.getText(),PasswordTF.getText(),dob);
        c1.Signup(FirstNameTF.getText(), LastNameTF.getText(),PhoneNumberTF.getText(),EmailIdTF.getText(),LoginIdTF.getText(),PasswordTF.getText(),dob,String.valueOf(custid));
        custid++;
    }
}
