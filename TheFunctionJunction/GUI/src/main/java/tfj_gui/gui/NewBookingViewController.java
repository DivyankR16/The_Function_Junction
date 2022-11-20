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
    public ChoiceBox Decoration_choicebox;
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
    private final String[] Venue_Choices = {"Lawn","Hall","Open Field","Conference room"};
    private final String[] Drinks_Choices = {"Coffee","Lemon Juice","Orange juice","Mixed fruit juice","Beer","---None---"};
    private final String[] Breakfast_Choices = {"breakfast1","breakfast2","breakfast3","---None---"};
    private final String[] Lunch_Choices = {"Lunch1","Lunch2","Lunch3","---None---"};
    private final String[] Snacks_Choices = {"Snacks1","Snacks2","Snacks3","---None---"};
    private final String[] Dinner_Choices = {"Dinner1","Dinner2","Dinner3","---None---"};

    @FXML
    private ChoiceBox<String> Event_choicebox;
    @FXML
    private ChoiceBox<String> Venue_choicebox;
    @FXML
    private ChoiceBox<String> Breakfast_choicebox;
    @FXML
    private ChoiceBox<String> Lunch_Choicebox;
    @FXML
    private ChoiceBox<String> Snacks_Choicebox;
    @FXML
    private ChoiceBox<String> Dinner_Choicebox;
    @FXML
    private ChoiceBox<String> Drinks_choicebox;
    @FXML
    private Label DisplayInformationLabel;

    @Override
    public void initialize(URL url,ResourceBundle resourceBundle) {
        Event_choicebox.getItems().addAll(Event_Choices);
        Event_choicebox.setOnAction(this::Choice_in_Choice_box);

        Venue_choicebox.getItems().addAll(Venue_Choices);
        Venue_choicebox.setOnAction(this::Choice_in_Choice_box_venue);

        Breakfast_choicebox.getItems().addAll(Breakfast_Choices);
        Breakfast_choicebox.setOnAction(this::Choice_in_Choice_box_breakfast);

        Lunch_Choicebox.getItems().addAll(Lunch_Choices);
        Lunch_Choicebox.setOnAction(this::Choice_in_Choice_box_Lunch);

        Snacks_Choicebox.getItems().addAll(Snacks_Choices);
        Snacks_Choicebox.setOnAction(this::Choice_in_Choice_box_Snacks);

        Dinner_Choicebox.getItems().addAll(Dinner_Choices);
        Dinner_Choicebox.setOnAction(this::Choice_in_Choice_box_Dinner);

        Drinks_choicebox.getItems().addAll(Drinks_Choices);
        Drinks_choicebox.setOnAction(this::Choice_in_Choice_box_drinks);

    }
    private String myChoice;
    private String myChoice_venue;
    private String myChoice_breakfast,myChoice_Drinks,myChoice_Lunch,myChoice_Snacks,myChoice_Dinner;
    protected void Choice_in_Choice_box(ActionEvent event)
    {
        myChoice=Event_choicebox.getValue();
        if ((myChoice.compareToIgnoreCase(Event_Choices[0]))==0)
        {
            DisplayInformationLabel.setText("Marriage Hall\n Capacity:1000people\n Cost per Day = 50,000 Rs.");
        }
        else if((myChoice.compareToIgnoreCase(Event_Choices[1]))==0)
        {
            DisplayInformationLabel.setText("Event Selected is Birthday Party.");
        }
        System.out.println(myChoice);
    }
    protected void Choice_in_Choice_box_venue(ActionEvent event)
    {
        myChoice_venue=Venue_choicebox.getValue();
        System.out.println(myChoice_venue);
    }
    protected void Choice_in_Choice_box_breakfast(ActionEvent event)
    {
        myChoice_breakfast=Breakfast_choicebox.getValue();
        System.out.println(myChoice_breakfast);
    }
    private void Choice_in_Choice_box_Lunch(ActionEvent event)
    {
        myChoice_Lunch=Lunch_Choicebox.getValue();
        System.out.println(myChoice_Lunch);
    }
    protected void Choice_in_Choice_box_drinks(ActionEvent event)
    {
        myChoice_Drinks=Drinks_choicebox.getValue();
        System.out.println(myChoice_Drinks);
    }
    protected void Choice_in_Choice_box_Snacks(ActionEvent event)
    {
        myChoice_Snacks=Snacks_Choicebox.getValue();
        System.out.println(myChoice_Snacks);
    }
    protected void Choice_in_Choice_box_Dinner(ActionEvent event)
    {
        myChoice_Dinner=Dinner_Choicebox.getValue();
        System.out.println(myChoice_Dinner);
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
    protected void save(ActionEvent event)
    {

    }
    @FXML
    protected void NextNewBooking(ActionEvent event) throws IOException {
        System.out.println(myChoice);
        System.out.println(myChoice_breakfast);
        System.out.println(myChoice_venue);
        System.out.println(myChoice_Lunch);
        System.out.println(myChoice_Drinks);
        System.out.println(myChoice_Snacks);
        System.out.println(myChoice_Dinner);
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
