/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paradaily.services;

import com.paradaily.entities.Article;
import com.paradaily.entities.Product;
import com.paradaily.entities.ProductRoutine;
import com.paradaily.entities.Routine;
import com.paradaily.utils.DataSource;
import java.sql.Connection;
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
public class RoutineService {
    
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    private Connection connection;

    public RoutineService() {
        connection=DataSource.getInstance().getCnx();
    }
    
    public void ajouterRoutine(Routine r ){
                String req="insert into Routine(user_id,name_routine,notification) values (?,?,?)";
        try {
            pst = connection.prepareStatement(req);
            r.getUserId().setId(22);
            pst.setInt(1, r.getUserId().getId());
            pst.setString(2, r.getNameRoutine());
            pst.setString(3, r.getNotification());
           
            
            
            pst.executeUpdate();
            System.out.println("ajout Routine");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void DeleteRoutine(Routine r){
                String req="delete from routine where id = ?";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1, r.getId());
            
            
            pst.executeUpdate();
            System.out.println("Suppression routine");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void modifier(Routine a) {
        try {
            String requete = "UPDATE routine SET name_routine=?, notification=?  WHERE id=?";
            pst = connection.prepareStatement(requete);
            pst.setInt(3, a.getId());
            pst.setString(1, a.getNameRoutine());
            pst.setString(2, a.getNotification());
            pst.executeUpdate();
            System.out.println("Routine modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }
    public List<Routine> readAll(){
        String req="select * from routine";
        List<Routine> list = new ArrayList<>();
        try {
            ste = connection.createStatement();
            rs=ste.executeQuery(req);
            while (rs.next()){
                list.add(new Routine(rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;        
    }
    public void AjouterPR(ProductRoutine pr, Product p, Routine r){
        
        String req = "insert into routine_product(routine_id, product_id) values (?,?)";
        try {
            pst = connection.prepareStatement(req);
            p.getId();
            pst.setInt(1, pr.getProduct_id().getId());
            r.getId();
            pst.setInt(2, pr.getRoutine_id().getId());
           
            pst.executeUpdate();
            System.out.println("ajout Produit à la routine");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void DeletePR(ProductRoutine pr){
                String req="delete from routineproduct where id = ?";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1, pr.getId());
            
            
            pst.executeUpdate();
            System.out.println("Suppression routine");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
