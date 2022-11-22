package tfj_gui.gui;

import Login.Customer;
import Login.Manager;
import Login.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteCustomerAccountViewController
{
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
    private Button DeleteAccountFinalButton;
    @FXML
    private CheckBox DelYesCheckbox;
    @FXML
    private TextField DelAccPassTextField;
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
    @FXML
    private Label emptlabel;
    @FXML
    protected void DeleteAccountFinal(ActionEvent event) throws IOException {
        if (DelYesCheckbox.isSelected())
        {
            String LoginID="";
            Send_Data_Between need=Send_Data_Between.getInstance();
            Person p;
            if(need.getCheck()==1){
                Manager m1=need.getManager();
                LoginID=m1.getLoginId();
                p=new Manager();
            }
            else{
                Customer c1=need.getCustomer();
                LoginID=c1.getLoginId();
                p=new Customer();
            }
            if((DelAccPassTextField.getText().compareTo(p.getPass(LoginID)))==0)
            {
                Customer.DeleteMe(LoginID);
                emptlabel.setText("Deleted Account Successfully.");
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login_View.fxml"));
                Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(fxmlLoader.load(),1080,720);
                stage.setTitle("THE FUNCTION JUNCTION");
                stage.setScene(scene);
                stage.show();
            }
            else
            {
                emptlabel.setText("Incorrect Password.");
            }
        }
        else
        {
            emptlabel.setText("Confirm deletion by selecting Checkbox.");
        }
    }

}
