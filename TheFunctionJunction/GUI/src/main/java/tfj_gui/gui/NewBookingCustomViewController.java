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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class NewBookingCustomViewController implements Initializable
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
    private Button Next1;
    @FXML
    protected void GoToHome(ActionEvent event) throws IOException
    {
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
    {
        Send_Data_Between inst=Send_Data_Between.getInstance();
        if(inst.getCheck()==1){
            ManagerControllerFunctions.MyAccountButtonClicked(event);}
        else{
            ControllerFunctions.MyAccountButtonClicked(event);
        }
    }
    @FXML
    protected void MyBookingsButtonClicked(ActionEvent event) throws IOException
    {
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
        Send_Data_Between inst=Send_Data_Between.getInstance();
        if(inst.getCheck()==1){
            ManagerControllerFunctions.HelpButtonClicked(event);}
        else{
            ControllerFunctions.HelpButtonClicked(event);
        }
    }
    @FXML
    protected void LogoutButtonClicked(ActionEvent event) throws IOException
    {
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
        Send_Data_Between inst=Send_Data_Between.getInstance();
        if(inst.getCheck()==1){
            ManagerControllerFunctions.ExitButtonClicked(event);}
        else{
            ControllerFunctions.ExitButtonClicked(event);
        }
    }
    private final String[] Event_Choices = {"Wedding","Birthday Party","New Year's Party","Conference","--Custom--"};
    private final String[] Drinks_Choices = {"Tea","Coffee","Orange juice","Mixed fruit juice","Beer"};
    private final String[] Venue_Choices = {"Lawn","Hall","Open Field","Conference room-1","Auditorium",""};
    @FXML
    private ChoiceBox<String> EventChoicebox;
    @FXML
    private ChoiceBox<String> Breakfast_choicebox;
    @FXML
    private ChoiceBox<String> Drinks_choicebox;
    @FXML
    private ChoiceBox<String> Venue_choicebox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EventChoicebox.getItems().addAll(Event_Choices);
        EventChoicebox.setOnAction(this::Choice_in_Choice_box);

//        Breakfast_choicebox.getItems().addAll();
//        Breakfast_choicebox.setOnAction(this::Choice_in_Choice_box_breakfast);

        Drinks_choicebox.getItems().addAll(Drinks_Choices);
        Drinks_choicebox.setOnAction(this::Choice_in_Choice_box_drinks);

        Venue_choicebox.getItems().addAll(Venue_Choices);
        Venue_choicebox.setOnAction(this::Choice_in_Choice_box_drinks);

    }
    private String myChoice,myChoice_breakfast,myChoice_Drinks,myChoice_venue;
    protected void Choice_in_Choice_box(ActionEvent event)
    {
        myChoice=EventChoicebox.getValue();
        System.out.println(myChoice);
    }
    //    protected void Choice_in_Choice_box_breakfast(ActionEvent event)
//    {
//        myChoice_bf=Breakfast_choicebox.getValue();
//        System.out.println(myChoice_bf);
//    }
    protected void Choice_in_Choice_box_drinks(ActionEvent event)
    {
        myChoice_Drinks=Drinks_choicebox.getValue();
        System.out.println(myChoice_Drinks);
    }
    protected void Choice_in_Choice_box_venue(ActionEvent event)
    {
        myChoice=EventChoicebox.getValue();
        System.out.println(myChoice_venue);
    }
    @FXML
    private DatePicker Start_Date = new DatePicker();
    protected void getStartDate(ActionEvent event)
    {
        LocalDate SD = Start_Date.getValue();
    }

    @FXML
    private DatePicker End_Date = new DatePicker();
    protected void getEndDate(ActionEvent event)
    {
        LocalDate ED = End_Date.getValue();
    }
    @FXML
    protected void NextNewBooking(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewBookingBirthday_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1080,720);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
}
