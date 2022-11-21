package tfj_gui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class NewBookingViewController implements Initializable {
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
    private Button Next1;

    @FXML
    protected void GoToHome(ActionEvent event) throws IOException
    {
        //ControllerFunctions.GoToHome(event);
        Send_Data_Between inst=Send_Data_Between.getInstance();
        if(inst.getCheck()==1){
            ManagerControllerFunctions.GoToHome(event);}
        else{
            ControllerFunctions.GoToHome(event);
        }
    }
    @FXML
    protected void NewBookingButtonClicked(ActionEvent event) throws IOException
    {

    }
    @FXML
    protected void MyAccountButtonClicked(ActionEvent event) throws IOException
    {   Send_Data_Between inst=Send_Data_Between.getInstance();
        if(inst.getCheck()==1){
        ManagerControllerFunctions.MyAccountButtonClicked(event);}
        else{
            ControllerFunctions.MyAccountButtonClicked(event);
        }
    }
    @FXML
    protected void MyBookingsButtonClicked(ActionEvent event) throws IOException
    {
        //ControllerFunctions.MyBookingsButtonClicked(event);
        Send_Data_Between inst=Send_Data_Between.getInstance();
        if(inst.getCheck()==1){
            ManagerControllerFunctions.MyBookingsButtonClicked(event);}
        else{
            ControllerFunctions.MyBookingsButtonClicked(event);
        }
    }
    @FXML
    protected void ChangePasswordButtonClicked(ActionEvent event) throws IOException
    {
        //ControllerFunctions.ChangePasswordButtonClicked(event);
        Send_Data_Between inst=Send_Data_Between.getInstance();
        if(inst.getCheck()==1){
            ManagerControllerFunctions.ChangePasswordButtonClicked(event);}
        else{
            ControllerFunctions.ChangePasswordButtonClicked(event);
        }
    }
    @FXML
    protected void AboutUsButtonClicked(ActionEvent event) throws IOException
    {
        //ControllerFunctions.AboutUsButtonClicked(event);
        Send_Data_Between inst=Send_Data_Between.getInstance();
        if(inst.getCheck()==1){
            ManagerControllerFunctions.AboutUsButtonClicked(event);}
        else{
            ControllerFunctions.AboutUsButtonClicked(event);
        }
    }
    @FXML
    protected void HelpButtonClicked(ActionEvent event) throws IOException
    {
        //ControllerFunctions.HelpButtonClicked(event);
        Send_Data_Between inst=Send_Data_Between.getInstance();
        if(inst.getCheck()==1){
            ManagerControllerFunctions.HelpButtonClicked(event);}
        else{
            ControllerFunctions.HelpButtonClicked(event);
        }
    }
    @FXML
    protected void LogoutButtonClicked(ActionEvent event) throws IOException {
        //ControllerFunctions.LogoutButtonClicked(event);
        Send_Data_Between inst=Send_Data_Between.getInstance();
        if(inst.getCheck()==1){
            ManagerControllerFunctions.LogoutButtonClicked(event);}
        else{
            ControllerFunctions.LogoutButtonClicked(event);
        }
    }
    @FXML
    protected void ExitButtonClicked(ActionEvent event) throws IOException
    {
        //ControllerFunctions.ExitButtonClicked(event);
        Send_Data_Between inst=Send_Data_Between.getInstance();
        if(inst.getCheck()==1){
            ManagerControllerFunctions.ExitButtonClicked(event);}
        else{
            ControllerFunctions.ExitButtonClicked(event);
        }
    }
    private final String[] Event_Choices = {"Marriage","Birthday party","NewYear Party","Conference","Custom"};

    @FXML
    private ChoiceBox<String> Event_choicebox;

    @Override
    public void initialize(URL url,ResourceBundle resourceBundle) {
        Event_choicebox.getItems().addAll(Event_Choices);
        Event_choicebox.setOnAction(this::Choice_in_Choice_box);
    }
    private String myChoice;
    protected void Choice_in_Choice_box(ActionEvent event)
    {
        myChoice=Event_choicebox.getValue();
        System.out.println(myChoice);
    }

    protected void save(ActionEvent event)
    {

    }
    @FXML
    protected void NextNewBooking(ActionEvent event) throws IOException{
        Send_Data_Between need=Send_Data_Between.getInstance();
        need.setLoginIDCust(need.getCustomer().getLoginId());
        if (myChoice.compareToIgnoreCase(Event_Choices[0])==0) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewBookingMarriage_View.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
            stage.setTitle("THE FUNCTION JUNCTION");
            stage.setScene(scene);
            stage.show();
        }
        else if (myChoice.compareToIgnoreCase(Event_Choices[1])==0) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewBookingBirthday_View.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
            stage.setTitle("THE FUNCTION JUNCTION");
            stage.setScene(scene);
            stage.show();
        }
        else if (myChoice.compareToIgnoreCase(Event_Choices[2])==0)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewBookingNewYear_View.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
            stage.setTitle("THE FUNCTION JUNCTION");
            stage.setScene(scene);
            stage.show();
        }
        else if (myChoice.compareToIgnoreCase(Event_Choices[3])==0)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewBookingConference_View.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
            stage.setTitle("THE FUNCTION JUNCTION");
            stage.setScene(scene);
            stage.show();
        }
        else if (myChoice.compareToIgnoreCase(Event_Choices[4])==0)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewBookingCustom_View.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
            stage.setTitle("THE FUNCTION JUNCTION");
            stage.setScene(scene);
            stage.show();
        }
    }
}
