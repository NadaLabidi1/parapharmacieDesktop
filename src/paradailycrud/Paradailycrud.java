/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paradailycrud;

import com.paradaily.entities.Article;
import com.paradaily.services.ArticleService;
import com.paradaily.utils.DataSource;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Nada
 */
public class Paradailycrud extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
           Article p1 = new Article("Article1","ksgf sqgvqlv iqshviq hqvgdeu duvgsi duvgkw kwsduvg wgvkjs kcjdvgksu jdvgsiu wjdvghcw jdvguy wdkjvg","ff05a37611eab6d96ba99e992da7aac5.jpeg",simpleDateFormat.parse("2021-02-22 12:54:44"));
       
        ArticleService ps = new ArticleService();
        //Article p2 = new Article(24,"Article1","ksgf sqgvqlv iqshviq hqvgdeu duvgsi duvgkw kwsduvg wgvkjs kcjdvgksu jdvgsiu wjdvghcw jdvguy wdkjvg","ff05a37611eab6d96ba99e992da7aac5.jpeg",simpleDateFormat.parse("2021-02-22 12:54:44"));
       //ps.ajouterArticle(p2);
       
        //Article p2 = new Article();
        //p2.setId(23);
        
       //ps.DeleteArticle(p2);
       
       
       //ps.readAll().forEach(e->System.out.println(e));
       //ps.listejaime(1).forEach(e->System.out.println(e));
        launch(args);     
    }
    
}
