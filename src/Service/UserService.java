/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.User;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;

/**
 *
 * @author manel
 */
public class UserService {

    public static UserService getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Statement ste;
    private PreparedStatement pst;
    
    private ResultSet rs;
    
    private Connection connection;
    
    public UserService(){
        connection=DataSource.getInstance().getcnx();

    }
    
    public void ajouterUser(User u){
        String req="insert into user (first_name,last_name,age,email,adress,username,password,skin_type,phone_number) values ( ?,?,?,?,?,?,?,?,?)";
        try {
            pst=connection.prepareStatement(req);
            pst.setString(1, u.getFirst_name());
            pst.setString(2, u.getLast_name());
            pst.setInt(3, u.getAge() );
            pst.setString(4, u.getEmail());
            pst.setString(5, u.getAdress());
            pst.setString(6, u.getUsername());
            pst.setString(7, u.getPassword());
            pst.setString(8, u.getSkin_type());
            pst.setString(9, u.getPhone_number());
            
            
            pst.executeUpdate();
            System.out.println("ajout");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

  public ObservableList<User> readAll(){
    
    String req="select* from user";
    ObservableList<User> users = FXCollections.observableArrayList();
    
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            
            while (rs.next()){
               users.add(new User(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getInt("age"),rs.getString("email"),rs.getString("adress"),rs.getString("username"),rs.getString("password"),rs.getString("skin_type"),rs.getString("phone_number"),rs.getString("role")));
               
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return users;
}
      public void ModifierUser(User u){
     String req = " update user set first_name = ?, last_name = ?, age =?, email = ?, adress = ?, username =?, password = ?, skin_type= ?, phone_number = ? where id = ?";
        
        try {
            pst=connection.prepareStatement(req);
            pst.setString(1, u.getFirst_name());
            pst.setString(2, u.getLast_name());
            pst.setInt(3, u.getAge());
            pst.setString(4, u.getEmail());
            pst.setString(5, u.getAdress());
            pst.setString(6, u.getUsername());
            pst.setString(7, u.getPassword());
            pst.setString(8, u.getSkin_type());
            pst.setString(9, u.getPhone_number());
            
            pst.executeUpdate();
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

      }
        public User displayById(int id){
             String req="select* from user where id ="+id;
             User u=new User();
             
        try {
            pst=connection.prepareStatement(req);
            pst.executeQuery(req);
           
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
      return u;
            
        }

    

   
      
      
}




