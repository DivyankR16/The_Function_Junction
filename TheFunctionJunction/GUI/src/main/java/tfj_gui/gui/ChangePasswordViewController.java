package tfj_gui.gui;

import Login.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Platform.exit;

public class ChangePasswordViewController {
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
    private Button ChangePasswordFinalButton;
    @FXML
    private TextField OldPasswordInput;
    @FXML
    private TextField NewPasswordInput;
    @FXML
    private TextField ConfirmNewPasswordInput;
    @FXML
    private Label Remarks;
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
    protected void ChangePasswordFinalButtonClicked()
    {
        String oldPassword = OldPasswordInput.getText();
        String newPassword = NewPasswordInput.getText();
        String confirmNewPassword = ConfirmNewPasswordInput.getText();
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
        if (newPassword.compareTo(confirmNewPassword)==0)
        {
              if (oldPassword.compareTo(p.getPass(LoginID))==0)
              {
                   if(p instanceof Manager){
                       //Manager m=new Manager();
                       p.changePass(LoginID,newPassword);
                   }
                   else if(p instanceof Customer){
                       //Customer c=new Customer();
                       p.changePass(LoginID,newPassword);
                   }
                  Remarks.setText("Password Updates Successfully!!");
             }
            else
            {
                Remarks.setText("Old Password does not match!!!");
            }
        }
        else
        {
            Remarks.setText("New Password and Confirmation Password do not match!!!");
        }

    }
}
