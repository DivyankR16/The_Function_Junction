package tfj_gui.gui;

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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),720,540);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void NewBookingButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewBooking_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),720,540);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void MyAccountButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InfoOfAccount_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),720,540);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void MyBookingsButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MyBookings_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),720,540);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void ChangePasswordButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ChangePassword_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),720,540);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void AboutUsButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AboutUs_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),720,540);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void HelpButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Help_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),720,540);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void LogoutButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),720,540);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void ExitButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Exit_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),720,540);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void ChangePasswordFinalButtonClicked()
    {
        String oldPassword = OldPasswordInput.getText();
        String newPassword = NewPasswordInput.getText();
        String confirmNewPassword = ConfirmNewPasswordInput.getText();
        if (newPassword.compareTo(confirmNewPassword)==0)
        {
//            if (oldPassword.compareTo(Person.getPassword())==0)
//            {
//
//            }
//            else
//            {
//                Remarks.setText("Old Password does not match!!!");
//            }
        }
        else
        {
            Remarks.setText("New Password and Confirmation Password do not match!!!");
        }

    }
}
