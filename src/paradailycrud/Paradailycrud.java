/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paradailycrud;

import com.paradaily.entities.Article;
import com.paradaily.entities.Product;
import com.paradaily.entities.ProductRoutine;
import com.paradaily.entities.Routine;
import com.paradaily.services.ArticleService;
import com.paradaily.services.RoutineService;
import com.paradaily.utils.DataSource;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Nada
 */
public class Paradailycrud extends Application {
    
    @Override
    public void start(Stage PrimaryStage) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("GestionArticles.fxml"));
        Scene scene = new Scene(root);
        Image icon = new Image("logo.png");
        PrimaryStage.getIcons().add(icon);      
        PrimaryStage.setTitle("Welcome");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
    
    
    public static void main(String[] args) throws ParseException {
        
        
        
        launch(args);
        
        
    }    
    
   
}
