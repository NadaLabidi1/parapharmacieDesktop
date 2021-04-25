/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paradaily.controllers;

import com.paradaily.entities.Article;
import com.paradaily.services.ArticleService;
import com.sun.javafx.charts.Legend;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Callback;
import javax.swing.SwingUtilities;

/**
 * FXML Controller class
 *
 * @author Nada
 */
public class GestionArticlesController implements Initializable {
    Article art = null;
    private boolean update;
    int ArticleId;
    public static int idl;
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
    private TableColumn<?, ?> col_created_at;
    @FXML
    private TableColumn<Article, String> col_action;
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
    private Button btn_modifier;
    private Button btn_supprimer;
    @FXML
    private Button btn_recherche;
    @FXML
    private TextField champs;
    @FXML
    private Button btn_modify;
    private String Image = "image.jpeg";
    @FXML
    private Button btn_stat;
    @FXML
    private BarChart<String, Number> barchart;
    @FXML
    private NumberAxis AxisY;
    @FXML
    private CategoryAxis AxisX;
    @FXML
    private AnchorPane graphhandler;
    @FXML
    private Pane titlepane;
    
  

    
    
     void setTextField(int id,String titre, String Description, String image) {
        ArticleId = id;
        input_titre.setText(titre);
        input_desc.setText(Description);
        
        //input_date.setValue(LocalDate);
        Image= image;
        
        

    }

    void setUpdate(boolean b) {
        this.update = b;
    }

    /**
     * Initializes the controller class.
     */
    public void showarticles(){
        
        champs.setVisible(true);
        ArticleService as = new ArticleService();
        ObservableList<Article> listeArticles =  as.readAll();
        this.col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        this.col_created_at.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        Callback<TableColumn<Article, String>, TableCell<Article, String>> cellFoctory = (TableColumn<Article, String> param) -> {
            // make cell containing buttons
            final TableCell<Article, String> cell = new TableCell<Article, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                           
                                art = articles.getSelectionModel().getSelectedItem();
                                ArticleService as = new ArticleService();
                                as.DeleteArticle(art);
                                articles.refresh();
                                
                    
                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                            art = articles.getSelectionModel().getSelectedItem();
                            System.out.println(art.toString());
                            articles.setVisible(false);
                            ajoutarticle.setVisible(true);
                            imageview.setImage(new Image("logo.png"));
                            text_titre.setText("Modifier un article");
                            btn_recherche.setVisible(false);
                            btn_ajout.setVisible(false);
                            btn_recherche.setVisible(false);
                                                        
                            setTextField( idl,art.getTitle(),art.getDescription(),art.getImage());
                            
                             if (articles.getSelectionModel().getSelectedItem()!=null){
            articles.setVisible(false);
            ajoutarticle.setVisible(true);
            imageview.setImage(new Image("logo.png"));
            text_titre.setText("Modifier un article");
            btn_modifier.setVisible(false);
            btn_supprimer.setVisible(false);
            btn_recherche.setVisible(false);
            btn_ajout.setVisible(false);
            barchart.setVisible(false);
            int idl=articles.getSelectionModel().getSelectedItem().getId();
           
        }
                            
                       });

                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
         col_action.setCellFactory(cellFoctory);
        
        this.articles.setItems(listeArticles);
    
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        articles.setVisible(true);
        champs.setVisible(true);
        ajoutarticle.setVisible(false);
         barchart.setVisible(false);
         btn_recherche.setVisible(true);
         graphhandler.setVisible(false);
        showarticles();
    }    

    @FXML
    private void ajouter_article(ActionEvent event) { 
        
        articles.setVisible(false);
        ajoutarticle.setVisible(true);
        imageview.setImage(new Image("logo.png"));
        text_titre.setText("Ajouter un article");
        //btn_modifier.setVisible(false);
        //btn_supprimer.setVisible(false);
        btn_recherche.setVisible(false);
        champs.setVisible(false);
        btn_modify.setVisible(false);
        barchart.setVisible(false);
        btn_ajout.setVisible(true);
        titlepane.setVisible(true);
        
        
        
    }

    @FXML
    private void show_articles(ActionEvent event) {
        
        
        ajoutarticle.setVisible(false);
        articles.setVisible(true);
        showarticles();
        text_titre.setText("Mes Articles");
        btn_recherche.setVisible(true);
        titlepane.setVisible(true);
        graphhandler.setVisible(false);
        articles.refresh();
        
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

    private void modifier(ActionEvent event) {
        if (articles.getSelectionModel().getSelectedItem()!=null){
            articles.setVisible(false);
            ajoutarticle.setVisible(true);
            imageview.setImage(new Image("logo.png"));
            text_titre.setText("Modifier un article");
            //btn_modifier.setVisible(false);
            //btn_supprimer.setVisible(false);
            titlepane.setVisible(true);
            btn_recherche.setVisible(false);
            btn_ajout.setVisible(false);
            barchart.setVisible(false);
            int idl=articles.getSelectionModel().getSelectedItem().getId();
           // modifier_article();
        }
        
    
    }
    @FXML
    public void modifier_article(){
            
            int idn=articles.getSelectionModel().getSelectedItem().getId();                                                       
            ArticleService as = new ArticleService();
            Article a = new Article(idn ,input_titre.getText(), input_desc.getText(),"image.jpeg" ,java.sql.Date.valueOf(input_date.getValue()));
            as.modifier(a, idn);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Article ");
        alert.setHeaderText(null);
        alert.setContentText("Article Modifié!");
        alert.show();
        
            
            System.out.println(a.toString());
        
    }


    @FXML
    private void recherche(ActionEvent event) {
        String rech = champs.getText();
        ArticleService as = new ArticleService();
        as.recherche(rech);
        articles.setItems(as.recherche(rech));
    }

    @FXML
    private void show_stats(ActionEvent event) {
        
        btn_recherche.setVisible(false);
            btn_ajout.setVisible(false);
            barchart.setVisible(true);
            articles.setVisible(false);
            btn_modify.setVisible(false);
            titlepane.setVisible(false);
            graphhandler.setVisible(true);
        ArticleService as =new ArticleService();
        
        ObservableList<XYChart.Data<String, Number>> answer = as.articletop5();
         
        XYChart.Series<String, Number> series = new XYChart.Series<>("Articles" ,answer);

        barchart.getData().setAll(series);
        
            barchart.lookupAll(".default-color0.chart-bar")
                    .forEach(n -> n.setStyle("-fx-bar-fill: #f59ad4; "));
             Legend legend = (Legend)barchart.lookup(".chart-legend");
        Legend.LegendItem li1=new Legend.LegendItem("Top 5 articles", new Rectangle(10,10,Color.rgb(245, 154, 212)));
        legend.getItems().setAll(li1);
    
        
        
    }

    
    
}
    
    

