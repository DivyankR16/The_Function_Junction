package tfj_gui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerNewBookingViewController implements Initializable
{
    private final String[] Event_Choices={"Marriage","Conference","NewYear","Birthday","Custom"};
    public ChoiceBox<String> Venue_choicebox;
    @FXML
    private ChoiceBox<String> Event_choicebox;
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
    protected void GoToHome(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.GoToHome(event);
    }
    @FXML
    protected void NewBookingButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.NewBookingButtonClicked(event);
    }
    @FXML
    protected void MyAccountButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.MyAccountButtonClicked(event);
    }
    @FXML
    protected void MyBookingsButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.MyBookingsButtonClicked(event);
    }
    @FXML
    protected void ChangePasswordButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.ChangePasswordButtonClicked(event);
    }
    @FXML
    protected void AboutUsButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.AboutUsButtonClicked(event);
    }
    @FXML
    protected void HelpButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.HelpButtonClicked(event);
    }
    @FXML
    protected void LogoutButtonClicked(ActionEvent event) throws IOException {
        ManagerControllerFunctions.LogoutButtonClicked(event);
    }
    @FXML
    protected void ExitButtonClicked(ActionEvent event) throws IOException
    {
        ManagerControllerFunctions.ExitButtonClicked(event);
    }
    private String myChoice_Event;
    protected void Choice_in_Choice_box_Event(ActionEvent event)
{
    myChoice_Event=Event_choicebox.getValue();
}
@FXML
    public void NextNewBooking(ActionEvent event) throws IOException {
        Send_Data_Between need=Send_Data_Between.getInstance();
        need.setLoginIDCust(Venue_choicebox.getValue());
       if(myChoice_Event.compareToIgnoreCase("Marriage")==0){
           FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewBookingMarriage_View.fxml"));
           Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
           Scene scene = new Scene(fxmlLoader.load(),1080,720);
           stage.setTitle("THE FUNCTION JUNCTION");
           stage.setScene(scene);
           stage.show();
        }
       else  if(myChoice_Event.compareToIgnoreCase("Conference")==0){
           FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewBookingConference_View.fxml"));
           Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
           Scene scene = new Scene(fxmlLoader.load(),1080,720);
           stage.setTitle("THE FUNCTION JUNCTION");
           stage.setScene(scene);
           stage.show();
       }
       else  if(myChoice_Event.compareToIgnoreCase("NewYear")==0){

       }
       else  if(myChoice_Event.compareToIgnoreCase("Custom")==0){

       }
       else  if(myChoice_Event.compareToIgnoreCase("Birthday")==0){

       }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Event_choicebox.getItems().addAll(Event_Choices);
        Event_choicebox.setOnAction(this::Choice_in_Choice_box_Event);
    }
}
