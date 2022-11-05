package tfj_gui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Login.*;
public class Login_View_Controller implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private ChoiceBox<String> Login_View_Choice_Box;
    @FXML
    private Label Login_View_ChoiceBox_Label;
    private final String [] Choice_I_am = {"Customer","Manager"};
    private String myChoice;
    @FXML
    private Button Login_View_Login_Button;
    @FXML
    private Button Login_View_SignUp_Button;
    @FXML
    private TextField Login_Page_Input_LoginId;
    @FXML
    private PasswordField Login_Page_Input_Password;
    @FXML
    protected void Login_View_Clicked_On_Login(ActionEvent event) throws IOException {
        if (Login_View_Choice_Box.getValue().compareToIgnoreCase("manager")==0)
        {
            Login_As_Manager(Login_Page_Input_LoginId.getText(),Login_Page_Input_Password.getText(),event);
        }
        else
        {
            Login_As_Customer(Login_Page_Input_LoginId.getText(),Login_Page_Input_Password.getText(),event);
        }
    }
    public void Login_As_Customer(String LoginID, String Password,ActionEvent event) throws IOException {
        //System.out.printf("Login Successful!!\nCustomer LoginId: %s\nPassword: %s",LoginID,Password);
        Customer c1=new Customer();
         if (c1.Login(LoginID,Password,"Customer")==1)
         {
            Go_to_Home(event);
         }
         else if(c1.Login(LoginID,Password,"Customer")==0){
             //Incorrect user or password
         }
         else if(c1.Login(LoginID,Password,"Customer")==2){
             //LogId cannot be empty
         }
         else{
             //Password cannot be empty OR return is 3
         }
    }
    protected void Go_to_Home(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),720,540);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    public void Login_As_Manager(String LoginId,String Password,ActionEvent event) throws IOException {
        //System.out.printf("Manager LoginID: %s \nPassword: %s",LoginId,Password);
        Manager m1=new Manager();
        if (m1.Login(LoginId,Password,"Manager")==1)
        {
            Go_to_Manager_Home(event,LoginId);
        }
        else if(m1.Login(LoginId,Password,"Manager")==0){
            //Incorrect user or password
        }
        else if(m1.Login(LoginId,Password,"Manager")==2){
            //LogId cannot be empty
        }
        else{
            //Password cannot be empty OR return is 3
        }
    }
    protected void Go_to_Manager_Home(ActionEvent event,String ID) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ManagerHome_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),720,540);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onSignUpButtonClick(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Signup_View.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(),720,540);
        stage.setTitle("THE FUNCTION JUNCTION");
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Login_View_Choice_Box.getItems().addAll(Choice_I_am);
        Login_View_Choice_Box.setOnAction(this::Choice_in_ChoiceBox);
    }
    protected void Choice_in_ChoiceBox(ActionEvent event)
    {
        myChoice = Login_View_Choice_Box.getValue();
    }


}