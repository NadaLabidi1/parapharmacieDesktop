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
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.DataSource;
import java.text.SimpleDateFormat;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;



/**
 *
 * @author manel
 */
public class Projetpidev extends Application {
    
        
          @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        
        Scene scene = new Scene(root);
        Image icon = new Image ("Untitled design (1).png");
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
      
       new animatefx.animation.BounceIn(root).play();
    }
     
  
    
    
    
    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        launch(args);
        DataSource ds1= DataSource.getInstance();
       //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      //User u2=new User("sss","mmm",simpleDateFormat.parse("2021-02-22"),"man@manel.fr","mmmm","mmm","mlkjh","mixte","111");
      //  User u2=new User();
        
   // UserService us=new UserService();
      //us.ajouterUser(u2);
     //us.readAll().forEach(e->System.out.println(e));
       // Contact c1=new Contact("mano","manel@gmail.fr","hello","bonjour cv ?");
       // ContactService cs=new ContactService();
        //cs.ajouterContact(c1);
        //cs.readAll().forEach(e->System.out.println(e));
       // us.ModifierUser(u1);
        //cs.readAll().forEach(e->System.out.println(e));
        //LoginController lg=new LoginController();
       
     // us.ModifierUser(u2);
     // us.displayById(45);
     
        
    }

  
    
    
}
