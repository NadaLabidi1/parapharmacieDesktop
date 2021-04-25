/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paradaily.services;

import com.paradaily.entities.ArtLike;
import com.paradaily.entities.Article;
import com.paradaily.entities.ArticleLike;
import com.paradaily.entities.User;
import com.paradaily.utils.DataSource;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;


/**
 *
 * @author Nada
 */
public class ArticleService {
    
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    private Connection connection;
    private boolean update;
    String query;
    int ArticleId;
    

    public ArticleService() {
        connection=DataSource.getInstance().getCnx();
    }
    
    /*public void ajouterPersonne(Article a){
        String req="insert into personne (nom,prenom) values ('"+a.getNom()+"','"+a.getPrenom()+"')";
        try {
            ste=connection.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
    
        }
        
    }*/
    
     private void getQuery() {

        if (update == false) {
            
            query = "INSERT INTO `article`( `title`, `description`, `image`, `created_at`) VALUES (?,?,?,?)";

        }else{
            query = "UPDATE `student` SET "
                    + "`title`=?,"
                    + "`description`=?,"
                    + "`image`=?,"
                    + "`created_at`= ? WHERE id = '"+ArticleId+"'";
        }

    }
      void setUpdate(boolean b) {
        this.update = b;
    }
    public void ajouterArticle(Article a){
                String req="insert into article(title,description,image,created_at) values (?,?,?,?)";
                
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, a.getTitle());
            pst.setString(2, a.getDescription());
            pst.setString(3, a.getImage());
            pst.setDate(4, new java.sql.Date(a.getCreatedAt().getTime()));
            
            
            pst.executeUpdate();
            System.out.println("ajout");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
     public void DeleteArticle(Article a){
                String req="delete from article where id = ?";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1, a.getId());
            
            
            pst.executeUpdate();
            System.out.println("Suppression");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void modifier(Article a ,int id) {
        try {
            String requete = "UPDATE article SET title=?, description=?, image=?, created_at=?  WHERE id=?";
            
            pst = connection.prepareStatement(requete);
            pst.setInt(5, id);
            pst.setString(1, a.getTitle());
            pst.setString(2, a.getDescription());
            pst.setString(3, a.getImage());
            pst.setDate(4, new java.sql.Date(a.getCreatedAt().getTime()));
            pst.executeUpdate();
            System.out.println("Article modifié !");
            System.out.println(a.toString());

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }
    
    public ObservableList<Article> readAll(){
        String req="select * from Article";
        ObservableList<Article> list = FXCollections.observableArrayList();
        try {
            ste=connection.createStatement();
            rs =  ste.executeQuery(req);
            while (rs.next()){
                list.add(new Article(rs.getInt("id"),rs.getString("title"), rs.getString("description"),rs.getString("image"), rs.getDate("created_at")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  list;        
    }
    public ObservableList<Article> recherche(String rech ) {
        ObservableList<Article> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT * FROM article where title LIKE '%"+rech+"%'";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                list.add(new Article (rs.getInt("id"),rs.getString("title"), rs.getString("description"),rs.getString("image"), rs.getDate("created_at")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    public List<ArticleLike> listejaime(int id) {
        List<ArticleLike> myList = new ArrayList<ArticleLike>();

        try { 
            String requete = "SELECT * from article_like where article_id=" + id;  
            pst = connection.prepareStatement(requete); 
            rs = pst.executeQuery(requete);
            while (rs.next()) {
                
                ArticleLike p2 = new ArticleLike();
                p2.setId(rs.getInt(1));
                Article a = new Article(rs.getInt(2));
                p2.setArticleId(a);
                User u = new User(rs.getInt(3));
                p2.setUserId(u);
//               User u = new User(rs.getString(3));
//              p2.setUsername(u);
                myList.add(p2);

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;

    }
    public ObservableList<XYChart.Data<String, Number>> articletop5() {
        ObservableList<XYChart.Data<String, Number>> answer = FXCollections.observableArrayList();

        try { 
            String requete = "SELECT title , count(*) \n" +
                            "from article, article_like\n" +
                            "where article_like.article_id = article.id \n" +
                            "GROUP by (article_like.article_id)\n" +
                            "order by COUNT(*) desc LIMIT 5" ;  
            pst = connection.prepareStatement(requete); 
            rs = pst.executeQuery(requete);
            while (rs.next()) {
                
               String item= rs.getString("title");
                int count = rs.getInt(2);

                answer.add(new XYChart.Data<>(item, count));

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return answer;

    }
    
    public int countLikes(int id) {
        int a = 0;
        try { 
            String requete = "SELECT count(*) from article_like where article_id=" + id; 
            pst = connection.prepareStatement(requete); 
            rs = pst.executeQuery(requete);
            while (rs.next()) {

                a = rs.getInt(1);

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return a;

    }
    public void Like(ArticleLike a, User u) {
       
            try {
                String requete = "INSERT INTO article_like(article_id,user_id) VALUES(?,?) where user_id != ? ";
                pst = connection.prepareStatement(requete);
                a.getUserId();
                pst.setInt(2, a.getUserId().getId());
                pst.setInt(1, a.getArticleId().getId());
                pst.setInt(3, u.getId());
                
                pst.executeUpdate();
                System.out.println("j'aime");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
           
        }
    }
    
    
    
    
    
}
