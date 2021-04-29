/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpidev;

import Entity.User;
import Service.UserService;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import utils.DataSource;
import utils.UserHolder;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author manel
 */
public class MyViewController implements Initializable {

    @FXML
    private Button btnlogin;
    @FXML
    private Button btnsignup;
    @FXML
    private AnchorPane panelogin;
    @FXML
    private PasswordField passwordlogin;
    @FXML
    private TextField maillogin;
    @FXML
    private AnchorPane panesignup;
    @FXML
    private TextField username;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField address;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField emailup;
    @FXML
    private PasswordField passwordup;
    @FXML
    private ComboBox skintype;
    @FXML
    private Button signup;
    @FXML
    private TextField age;
    @FXML
    private Label erreurfn;
    @FXML
    private Label erreurlstn;
    @FXML
    private Label erreurusr;
    @FXML
    private Label erreuradr;
    @FXML
    private Label erreurpwd;
    @FXML
    private Label erreurnumber;
    @FXML
    private Label erreurage;
    @FXML
    private Label erreurmail;
    @FXML
    private Label erreurchoice;
    @FXML
    private AnchorPane menu_log;
    @FXML
    private AnchorPane welcome;
    @FXML
    private Button btn_welcome;
    @FXML
    private ImageView id_photo;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          
         this.panelogin.setVisible(false);
         this.panesignup.setVisible(false);
          
       ObservableList<String> list = FXCollections.observableArrayList("Oily Skin" ," Mixed Skin","Dry Skin" , "Normal Skin","Sensitive Skin");
       skintype.setItems(list);
       
      
       
    }    
    
    @FXML
    private void select(ActionEvent event){
        String s= skintype.getSelectionModel().getSelectedItem().toString();
        
    }
    
     /* public void image (ActionEvent event){
           Image myimage =new Image("/projetmanel/Image/loggo.png");
  
          id_photo.setImage(myimage);
      }
    */
            
            
     @FXML
    private void menu_log(ActionEvent event) {
        this.menu_log.setVisible(true);
        this.welcome.setVisible(false);
        this.panelogin.setVisible(false);
         this.panesignup.setVisible(false);
    }
    
    private void welcome(ActionEvent event) {
        this.welcome.setVisible(true);
        this.panelogin.setVisible(false);
         this.panesignup.setVisible(false);
          this.menu_log.setVisible(true);
    }

    @FXML
    private void paneloginShow(ActionEvent event) {
        this.panelogin.setVisible(true);
         this.menu_log.setVisible(true);
         this.panesignup.setVisible(false);
          this.welcome.setVisible(false);
    }

    @FXML
    private void panesignupShow(ActionEvent event) {
         this.panelogin.setVisible(false);
         this.panesignup.setVisible(true);
          this.menu_log.setVisible(true);
         this.welcome.setVisible(false);

    }
    
    @FXML
    private void login(ActionEvent event)throws Exception{
      
        Connection connection = DataSource.getInstance().getcnx();
        try {
           String req="Select * from user where email = ? and password = ?";
       
            PreparedStatement pst=connection.prepareStatement(req);
            pst.setString(1,maillogin.getText() );
            pst.setString(2,passwordlogin.getText());
           ResultSet rs=pst.executeQuery();
           if (rs.next()){
             JOptionPane.showMessageDialog(null, " email and password is correct");
            
    
           }else {
               JOptionPane.showMessageDialog(null, " Your email or you password are invalid");
           }
           if (rs.getString(11).equals("admin")){
        User u = new User (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
               Stage stage = new Stage();
                
               stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("dashboard.fxml"))));          
                    UserHolder holder = UserHolder.getInstance();
                    holder.setUser(u);
                stage.show();
                btnlogin.getScene().getWindow().hide();
           }
            else {
               User u = new User (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
                    UserHolder holder = UserHolder.getInstance();
                    holder.setUser(u);
                    Stage stage = new Stage();
                 
                 
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Profile.fxml"))));
                stage.show();
                 btnlogin.getScene().getWindow().hide();
                
            }
                
    
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
      
        }
           
    }
    @FXML
    private void Signup(ActionEvent event){
        Connection connection = DataSource.getInstance().getcnx();
              String req="insert into user (first_name,last_name,age,email,adress,username,password,skin_type,phone_number) values ( ?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst=connection.prepareStatement(req);
            pst.setString(1, firstname.getText());
            pst.setString(2,lastname.getText());
            pst.setString(3, age.getText());
            pst.setString(4, emailup.getText());
            pst.setString(5,address.getText());
            pst.setString(6, username.getText());
            pst.setString(7, passwordup.getText());
            pst.setString(8, (String) skintype.getValue());
            pst.setString(9, phonenumber.getText());
           
            
            if (firstname.getText().equals("")) {
            erreurfn.setText("please fill this box");  
            
        }if 
               (lastname.getText().equals("")){
            erreurlstn.setText("please fill this box"); 
        } if 
             (emailup.getText().equals("")){
            erreurmail.setText("please fill this box");
            
        } 
            if (address.getText().equals("")){
            erreuradr.setText("please fill this box");

        }
            if ( username.getText().equals("") ){
            erreurusr.setText("please fill this box");

        } 
            if ( passwordup.getText().equals("") ){
           erreurpwd.setText("please fill this box");
           
           
        } 
            if ( age.getText().equals("") ){
           erreurage.setText("please write your age ");

        }if (phonenumber.getText().length()!=8){
           erreurnumber.setText("please write your phone number correctly"); 
            
        }else
         
            JOptionPane.showMessageDialog(null, "Saved");
            pst.execute(); 
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        
        }

    

        
    }


