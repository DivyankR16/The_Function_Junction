package tfj_gui.gui;

import Database.DBconnection.Connect;
import Database.TableView.Menu;
import Database.TableView.Venue;
import Database.TableView.Wedding;
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
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewBookingMarriageViewController implements Initializable
{
    @FXML
    public Label DisplayInformationLabel;
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
        ControllerFunctions.GoToHome(event);
    }
    @FXML
    protected void NewBookingButtonClicked(ActionEvent event) throws IOException
    {

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
    private final String[] Drinks_Choices = {"Lemon juice","Orange juice","Mixed fruit juice","Beer","---None---"};
    private final String[] Venue_Choices = {"Lawn","Hall","Open Field","Conference room-1","Auditorium",""};
    private final String[] Decoration_Choices = {"Basic","Premium","Royal"};
    private final String[] Lunch_Choices ={"Lunch 1","Lunch 2","Lunch 3"};
    private final String[] Snacks_Choices={"Snacks 1","Snacks 2","Snacks 3"};
    private final String[] Breakfast_Choices={"Breakfast 1","Breakfast 2","Breakfast 3"};

    @FXML
    private ChoiceBox<String> Decoration_choicebox;
    @FXML
    private ChoiceBox<String> Breakfast_choicebox;
    @FXML
    private ChoiceBox<String> Drinks_choicebox;
    @FXML
    private ChoiceBox<String> Venue_choicebox;
    //@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Breakfast_choicebox.getItems().addAll();
        Breakfast_choicebox.setOnAction(this::Choice_in_Choice_box_breakfast);

        Drinks_choicebox.getItems().addAll(Drinks_Choices);
        Drinks_choicebox.setOnAction(this::Choice_in_Choice_box_drinks);

        Venue_choicebox.getItems().addAll(Venue_Choices);
        Venue_choicebox.setOnAction(this::Choice_in_Choice_box_venue);

        Decoration_choicebox.getItems().addAll(Decoration_Choices);
        Decoration_choicebox.setOnAction(this::Choice_in_Choice_box_decoration);
    }
    private String myChoice_decoration,myChoice_breakfast,myChoice_Drinks,myChoice_venue;
    protected void Choice_in_Choice_box_decoration(ActionEvent event)
    {
        myChoice_decoration=Decoration_choicebox.getValue();
        System.out.println(myChoice_decoration);
    }
        protected void Choice_in_Choice_box_breakfast(ActionEvent event)
    {
        myChoice_breakfast=Breakfast_choicebox.getValue();
        System.out.println(myChoice_breakfast);
    }
    protected void Choice_in_Choice_box_drinks(ActionEvent event)
    {
        myChoice_Drinks=Drinks_choicebox.getValue();
        System.out.println(myChoice_Drinks);
    }
    protected void Choice_in_Choice_box_venue(ActionEvent event)
    {
        myChoice_venue=Venue_choicebox.getValue();
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
    private double Cost;
    @FXML
    protected void NextNewBooking(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewBookingBirthday_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),1080,720);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    protected double GetCost()
    {
        return 0;
    }

    private String Name;
    private String Email;
    private String PhNumber;
    public void getPass(String loginID){
        String password="";
        try{
            Connection conn= Connect.createConnection();
            String query="Select * from customer where loginid=?";
            PreparedStatement preStatement=conn.prepareStatement(query);
            preStatement.setString(1,loginID);
            ResultSet rs=preStatement.executeQuery();
            if(rs.next()){
                Name = rs.getString("Name");
                Email = rs.getString("Email");
                PhNumber = rs.getString("PhoneNumber");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Connect.closeConnection();
        }
    }
    protected String GetBookingID()
    {
        String bi="";
        Connection c = Connect.createConnection();
        try{
            String query="Select max(BookingID) from bookinghistory";
            Statement s1 = c.createStatement();
            ResultSet rs = s1.executeQuery(query);
            if(rs.next())
            {
                bi=rs.getString("BookingID");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bi;
    }
    ArrayList<Menu> menu;

    protected void SetBooking()
    {
        Wedding w1 = new Wedding();
        LocalDate startdate = Start_Date.getValue();
        LocalDate enddate = End_Date.getValue();
        Date sd = Date.valueOf(startdate);
        Date ed = Date.valueOf(enddate);
        String venue = Venue_choicebox.getValue();
        Venue v1 = new Venue(venue,"sample");
        String booking_status = v1.getBookingStatus(sd,ed);
        if(booking_status.compareToIgnoreCase("Available") == 0)
        {
            int next_booking_id = Integer.parseInt(GetBookingID());
            w1.setBookingStatus("Booked");
            w1.setStartDate(sd);
            w1.setEndDate(ed);
            w1.setVenue(v1);
        }
        else {
            DisplayInformationLabel.setText("Hall not available.");
        }
    }
}
