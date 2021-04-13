/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paradaily.services;

import com.paradaily.entities.Article;
import com.paradaily.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nada
 */
public class ArticleService {
    
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    private Connection connection;

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
    public void ajouterArticlePST(Article a){
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
     public void DeleteArticlePST(Article a){
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
    
    public List<Article> readAll(){
        String req="select * from article";
        List<Article> list = new ArrayList<>();
        try {
            ste = connection.createStatement();
            rs=ste.executeQuery(req);
            while (rs.next()){
                list.add(new Article(rs.getString(3), rs.getString(4),rs.getString(5),rs.getDate(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;        
    }
    
    
    
    
    
}
