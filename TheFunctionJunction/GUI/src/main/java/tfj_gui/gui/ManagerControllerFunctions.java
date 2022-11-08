package tfj_gui.gui;

import Database.DBconnection.Connect;
import Database.TableView.ManagerDatabase;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

public class ManagerControllerFunctions
{
    protected static void GoToHome(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1080,720);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    protected static void NewBookingButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewBooking_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1080,720);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    protected static void MyAccountButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InfoOfAccount_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1080,720);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    protected static void MyBookingsButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ManagerBookingHistory_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1080,720);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    protected static void ChangePasswordButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ChangePassword_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1080,720);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    protected static void AboutUsButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AboutUs_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1080,720);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    protected static void HelpButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Help_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1080,720);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    protected static void LogoutButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1080,720);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    protected static void ExitButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Exit_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1080,720);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
}
