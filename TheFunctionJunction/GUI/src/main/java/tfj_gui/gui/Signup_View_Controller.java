package tfj_gui.gui;

import Login.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

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
    private DatePicker DOBTF = new DatePicker();
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
        Customer c = new Customer(FirstNameTF.getText(), LastNameTF.getText(),PhoneNumberTF.getText(),EmailIdTF.getText(),LoginIdTF.getText(),PasswordTF.getText(),((TextField) DOBTF.getEditor()).getText());
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
    @FXML
    protected void getDateFromPicker(ActionEvent event)
    {
        LocalDate dob = DOBTF.getValue();
    }
    @FXML
    private void SignUpFinalButtonClicked()
    {
        Customer c1 = new Customer(FirstNameTF.getText(), LastNameTF.getText(),PhoneNumberTF.getText(),EmailIdTF.getText(),LoginIdTF.getText(),PasswordTF.getText(), ((TextField) DOBTF.getEditor()).getText());
        c1.Signup(FirstNameTF.getText(), LastNameTF.getText(),PhoneNumberTF.getText(),EmailIdTF.getText(),LoginIdTF.getText(),PasswordTF.getText(),((TextField) DOBTF.getEditor()).getText(),String.valueOf(custid));
        custid++;
        System.out.println(custid);
    }
}
