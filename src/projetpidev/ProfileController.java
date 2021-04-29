/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpidev;

import Entity.Contact;
import Service.ContactService;
import Service.UserService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import utils.DataSource;


/**
 * FXML Controller class
 *
 * @author manel
 */
public class ProfileController implements Initializable {

    private AnchorPane id_profil;
    @FXML
    private AnchorPane acceuil;
    @FXML
    private AnchorPane contactus;
    @FXML
    private TextField mail_msg;
    @FXML
    private TextField sb_msg;
    @FXML
    private TextArea msg_msg;
    @FXML
    private Button send_msg;
    @FXML
    private Button btn_cont_us;
    @FXML
    private Button btn_profil;
    @FXML
    private Button btn_accueil;
    @FXML
    private Button logout;
    @FXML
    private AnchorPane log_out;
    @FXML
    private ImageView id_photo;
    @FXML
    private Button login_again;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.acceuil.setVisible(true);
        this.contactus.setVisible(false);
        this.log_out.setVisible(false);
       

              
    }   
    
      @FXML
    private void log_out(ActionEvent event) {
         this.acceuil.setVisible(false);
        this.contactus.setVisible(false);
        this.log_out.setVisible(true);
    }

    
    
     @FXML
    private void inbox(ActionEvent event) {
        this.contactus.setVisible(true);
         this.acceuil.setVisible(true);
         this.id_profil.setVisible(false);
          
    }
    
   
    private void accueil (ActionEvent event) {
        this.contactus.setVisible(false);
         this.acceuil.setVisible(true);
         this.id_profil.setVisible(false);
        
    }

    
    @FXML
    public void Contactus (){
        Connection connection = DataSource.getInstance().getcnx();
        
         String req="insert into contact(email,subject,message)values (?,?,?)";
         
         
        try { 
            PreparedStatement pst=connection.prepareStatement(req);
           
            pst.setString(1,mail_msg.getText() );
           pst.setString(2,sb_msg.getText() );
           pst.setString(3,msg_msg.getText() );
            pst.execute();
           
              Notifications notificationBuilder= Notifications.create()
                .title("Message")
                .text("Your Message has been sent")
                .hideAfter(Duration.seconds(6))
                        .position(Pos.TOP_RIGHT);
                 notificationBuilder.showInformation();

        } catch (SQLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

  

 @FXML     
       private void login_again(ActionEvent event) throws IOException, SQLException {
        Stage stage = new Stage();
        stage.setTitle("welcome");
        
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view.fxml"))));
        stage.show();
       login_again.getScene().getWindow().hide();
    }

    @FXML
    private void profil(ActionEvent event) {
    }

    @FXML
    private void myvideo(ActionEvent event) {
    }

    
    
}
