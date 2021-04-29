/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;

/**
 *
 * @author manel
 */
public class ContactService {
     private Statement ste;
    private PreparedStatement pst;
    
    private ResultSet rs;
    
    private Connection connection;
    
    public ContactService(){
         connection=DataSource.getInstance().getcnx();
    
}
    public void ajouterContact(Contact c){
        String req="insert into contact(email,subject,message)values (?,?,?)";
        
         try {
             pst=connection.prepareStatement(req);
             
             pst.setString(2, c.getEmail());
             pst.setString(3, c.getSubject());
             pst.setString(4, c.getMessage());
             
             pst.executeUpdate();
             System.out.println("ajoutcontact");
             
         } catch (SQLException ex) {
             Logger.getLogger(ContactService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public ObservableList<Contact> readAll(){
        String req="select* from contact";
        
         ObservableList<Contact> inbox= FXCollections.observableArrayList();
         
         try {
             ste=connection.createStatement();
              rs=ste.executeQuery(req);
              
              while (rs.next()){
               inbox.add(new Contact(rs.getInt("id"),rs.getString("email"),rs.getString("subject"),rs.getString("message")));
               
            }
            
         } catch (SQLException ex) {
             Logger.getLogger(ContactService.class.getName()).log(Level.SEVERE, null, ex);
         }
           
         return inbox;
    }
}
