package tfj_gui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Platform.exit;

public class LogoutViewController {
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
    private CheckBox ConfirmLogoutCheckbox;
    @FXML
    private Button FinalLogoutButton;

    @FXML
    protected void FinalLogoutButtonClicked(ActionEvent event) throws IOException {
        if (ConfirmLogoutCheckbox.isSelected()) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login_View.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
            stage.setTitle("THE FUNCTION JUNCTION");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    protected void GoToHome(ActionEvent event) throws IOException {
        Send_Data_Between inst = Send_Data_Between.getInstance();
        if (inst.getCheck() == 1) {
            ManagerControllerFunctions.GoToHome(event);
        } else {
            ControllerFunctions.GoToHome(event);
        }
    }

    @FXML
    protected void NewBookingButtonClicked(ActionEvent event) throws IOException {

    }

    @FXML
    protected void MyAccountButtonClicked(ActionEvent event) throws IOException {
        Send_Data_Between inst = Send_Data_Between.getInstance();
        if (inst.getCheck() == 1) {
            ManagerControllerFunctions.MyAccountButtonClicked(event);
        } else {
            ControllerFunctions.MyAccountButtonClicked(event);
        }
    }

    @FXML
    protected void MyBookingsButtonClicked(ActionEvent event) throws IOException {
        Send_Data_Between inst = Send_Data_Between.getInstance();
        if (inst.getCheck() == 1) {
            ManagerControllerFunctions.MyBookingsButtonClicked(event);
        } else {
            ControllerFunctions.MyBookingsButtonClicked(event);
        }
    }

    @FXML
    protected void ChangePasswordButtonClicked(ActionEvent event) throws IOException {
        Send_Data_Between inst = Send_Data_Between.getInstance();
        if (inst.getCheck() == 1) {
            ManagerControllerFunctions.ChangePasswordButtonClicked(event);
        } else {
            ControllerFunctions.ChangePasswordButtonClicked(event);
        }
    }

    @FXML
    protected void AboutUsButtonClicked(ActionEvent event) throws IOException {
        Send_Data_Between inst = Send_Data_Between.getInstance();
        if (inst.getCheck() == 1) {
            ManagerControllerFunctions.AboutUsButtonClicked(event);
        } else {
            ControllerFunctions.AboutUsButtonClicked(event);
        }
    }

    @FXML
    protected void HelpButtonClicked(ActionEvent event) throws IOException {
        Send_Data_Between inst = Send_Data_Between.getInstance();
        if (inst.getCheck() == 1) {
            ManagerControllerFunctions.HelpButtonClicked(event);
        } else {
            ControllerFunctions.HelpButtonClicked(event);
        }
    }

    @FXML
    protected void LogoutButtonClicked(ActionEvent event) throws IOException {
        Send_Data_Between inst = Send_Data_Between.getInstance();
        if (inst.getCheck() == 1) {
            ManagerControllerFunctions.LogoutButtonClicked(event);
        } else {
            ControllerFunctions.LogoutButtonClicked(event);
        }
    }

    @FXML
    protected void ExitButtonClicked(ActionEvent event) throws IOException {
        Send_Data_Between inst = Send_Data_Between.getInstance();
        if (inst.getCheck() == 1) {
            ManagerControllerFunctions.ExitButtonClicked(event);
        } else {
            ControllerFunctions.ExitButtonClicked(event);
        }
    }
}