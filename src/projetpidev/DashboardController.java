/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpidev;

import Entity.Contact;
import Entity.User;
import Service.ContactService;
import Service.UserService;
import Service.MailService;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author manel
 */
public class DashboardController implements Initializable {
    @FXML
    private TableView<User> user_list;
    @FXML
    private TableColumn<?, ?> id_list;
    @FXML
    private TableColumn<?, ?> fname_list;
    @FXML
    private TableColumn<?, ?> lname_list;
    @FXML
    private TableColumn<?, ?> age_list;
    @FXML
    private TableColumn<?, ?> mail_list;
    @FXML
    private TableColumn<?, ?> adr_list;
    @FXML
    private TableColumn<?, ?> uname_list;
    @FXML
    private TableColumn<?, ?> st_list;
    @FXML
    private TableColumn<?, ?> pn_list;
    @FXML
    private Button btn_user;
    @FXML
    private Button btn_homepage;
    @FXML
    private AnchorPane homepage;
    private AnchorPane listpage;
    @FXML
    private TableColumn<?, ?> id_inbox;
    private TableColumn<?, ?> us_inbox;
    @FXML
    private TableColumn<?, ?> mail_inbox;
    @FXML
    private TableColumn<?, ?> sb_inbox;
    @FXML
    private TableColumn<?, ?> msg_inbox;
    @FXML
    private TableView<Contact> table_inbox;
    @FXML
    private Button btn_inbox;
    @FXML
    private AnchorPane user_page;
    @FXML
    private AnchorPane inbox_page;
    @FXML
    private Button logout;
    @FXML
    private Button btn_mails;
    @FXML
    private AnchorPane mail_pane;
    @FXML
    private TextField id_mails;
    @FXML
    private TextField id_sbj;
    @FXML
    private TextArea id_msg;
    @FXML
    private Button btn_send;
    @FXML
    private AnchorPane log_out;
    @FXML
    private ImageView id_photo;
    @FXML
    private AnchorPane barmenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          this.homepage.setVisible(true);
        this.user_page.setVisible(false);
        this.inbox_page.setVisible(false);
        this.mail_pane.setVisible(false);
         this.log_out.setVisible(false);
    }    
    
     @FXML
    private void Homepage(ActionEvent event) {
        this.homepage.setVisible(true);
        this.user_page.setVisible(false);
        this.inbox_page.setVisible(false);
        this.mail_pane.setVisible(false);
         this.log_out.setVisible(false);
       
    }
  
    
    
    

    @FXML
     public void showusers (){
         UserService us=new UserService();
        ObservableList<User> List= us.readAll();
        this.id_list.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.fname_list.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        this.lname_list.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        this.age_list.setCellValueFactory(new PropertyValueFactory<>("Age"));
        this.mail_list.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.adr_list.setCellValueFactory(new PropertyValueFactory<>("adress"));
        this.uname_list.setCellValueFactory(new PropertyValueFactory<>("Username"));
        this.st_list.setCellValueFactory(new PropertyValueFactory<>("skin_type"));
        this.pn_list.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        
        this.user_list.setItems(List);
         this.homepage.setVisible(false);
        this.user_page.setVisible(true);
        this.inbox_page.setVisible(false);
         this.mail_pane.setVisible(false);
          this.log_out.setVisible(false);
    }
     
     
     
    @FXML
     public void showinbox (){
         ContactService cs=new ContactService();
        ObservableList<Contact> List= cs.readAll();
        this.id_inbox.setCellValueFactory(new PropertyValueFactory<>("id"));
       /* this.us_inbox.setCellValueFactory(new PropertyValueFactory<>("Username"));*/
        this.mail_inbox.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.sb_inbox.setCellValueFactory(new PropertyValueFactory<>("subject"));
        this.msg_inbox.setCellValueFactory(new PropertyValueFactory<>("message"));
       
        
        this.table_inbox.setItems(List);
         this.homepage.setVisible(false);
        this.user_page.setVisible(false);
        this.inbox_page.setVisible(true);
        this.mail_pane.setVisible(false);
         this.log_out.setVisible(false);
    }
     
     
   public  void sendMail(String recepient) throws MessagingException {
     
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
        String myAccountEmail = "manel.tabbeb@esprit.tn";
        //Your gmail password
        String password = "203JFT5462";

        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        //Prepare email message
        Message message = prepareMessage(session, myAccountEmail, recepient);

       //Send mail
       System.out.println("test");
       Transport.send(message);
       System.out.println("test2");
       
       /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Reservation insérée avec succés!");
                alert.show();
                */
                
                
             Notifications notificationBuilder= Notifications.create()
                .title("E-mail")
                .text("Your email has been sent")
                .hideAfter(Duration.seconds(6))
                        .position(Pos.TOP_RIGHT);
                 notificationBuilder.showInformation();
                  
         
                
    }

   private  Message prepareMessage(Session session, String myAccountEmail, String recepient) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(id_sbj.getText());
            String htmlCode = "<h1> '"+id_msg.getText()+"' </h1> ";
            message.setContent(htmlCode, "text/html");
            return message;
       
        
    
        
    }

    @FXML
    private void mail_pane(ActionEvent event) {
         this.homepage.setVisible(false);
        this.user_page.setVisible(false);
        this.inbox_page.setVisible(false);
        this.mail_pane.setVisible(true);
         this.log_out.setVisible(false);
    }

    @FXML
    private void mailling(ActionEvent event) throws Exception, MessagingException,SQLException{
        sendMail(id_mails.getText());
        
    }

    @FXML
    private void log_out(ActionEvent event) {
        this.log_out.setVisible(true);
         this.homepage.setVisible(false);
        this.user_page.setVisible(false);
        this.inbox_page.setVisible(false);
        this.mail_pane.setVisible(false);
        this.barmenu.setVisible(false);
    
        
       /* Scene scene = new Scene(logout);
         new animatefx.animation.BounceInUp(logout).play();*/
    }

   
}


