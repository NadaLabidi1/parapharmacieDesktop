/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paradaily.views;

import com.paradaily.entities.Article;
import com.paradaily.services.ArticleService;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.swing.SwingUtilities;

/**
 * FXML Controller class
 *
 * @author Nada
 */
public class GestionArticlesController implements Initializable {

    @FXML
    private Button btn_add;
    @FXML
    private TableView<Article> articles;
    @FXML
    private TableColumn<?, ?> col_id;
    @FXML
    private TableColumn<?, ?> col_title;
    @FXML
    private TableColumn<?, ?> col_description;
    @FXML
    private TableColumn<?, ?> col_image;
    @FXML
    private TableColumn<?, ?> col_created_at;
    @FXML
    private AnchorPane ajoutarticle;
    @FXML
    private TextArea input_desc;
    @FXML
    private Text text_titre;
    @FXML
    private ImageView imageview;
    @FXML
    private Button imageloader;
    @FXML
    private DatePicker input_date;
    @FXML
    private TextField input_titre;
    private FileChooser fileChooser;
    private File file;
    private final Desktop desktop = Desktop.getDesktop();
    private Image image;
    
    private FileInputStream fis;
    @FXML
    private Button btn_ajout;
    @FXML
    private Button btn_list;

    /**
     * Initializes the controller class.
     */
    public void showarticles(){
        
        ArticleService as = new ArticleService();
        ObservableList<Article> listeArticles =  as.readAll();
        this.col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        this.col_image.setCellValueFactory(new PropertyValueFactory<>("image"));
        this.col_created_at.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        
        this.articles.setItems(listeArticles);
    
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        articles.setVisible(true);
        ajoutarticle.setVisible(false);
        showarticles();
    }    

    @FXML
    private void ajouter_article(ActionEvent event) { 
        
        articles.setVisible(false);
        ajoutarticle.setVisible(true);
        imageview.setImage(new Image("logo.png"));
        text_titre.setText("Ajouter un article");
        
        
    }

    @FXML
    private void show_articles(ActionEvent event) {
        
        
        ajoutarticle.setVisible(false);
        articles.setVisible(true);
        showarticles();
        text_titre.setText("Mes Articles");
        
        
    }

    @FXML
    private void handleimageloader(ActionEvent event) {
        
    }

    @FXML
    private void add_article(ActionEvent event) {
        
        Article a =new Article(input_titre.getText(), input_desc.getText(),"image.jpeg" ,java.sql.Date.valueOf(input_date.getValue()));
        ArticleService as  =new ArticleService();
        as.ajouterArticle(a);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Article ");
        alert.setHeaderText(null);
        alert.setContentText("Article Ajouté");
        alert.show();
        input_titre.setText("");
        input_desc.setText("");
        input_date.setValue(LocalDate.MAX);
                       
    }
    
    
}
    
    

