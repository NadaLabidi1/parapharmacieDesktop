/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
import java.text.SimpleDateFormat;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;

/**
 *
 * @author manel
 */
public class User {
    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private String email;
    private String adress;
    private String username;
    private String password;
    private String skin_type;
    private String phone_number;
    private String role;
    
    
  public User(){
      
  }
   
  public User(int id, String first_name, String last_name ,int age , String email ,String adress, String username ,String password , String skin_type ,String phone_number , String role){
    
      this.id=id;
      this.first_name=first_name;
      this.last_name=last_name;
      this.age=age;
      this.email=email;
      this.adress=adress;
      this.username=username;
      this.password=password;
      this.skin_type=skin_type;
      this.phone_number=phone_number;
      this.role=role;
      
      
  }
  public User( String first_name, String last_name ,int age, String email ,String adress, String username ,String password , String skin_type ,String phone_number ,String role){
    
      this.first_name=first_name;
      this.last_name=last_name;
      this.age=age;
      this.email=email;
      this.adress=adress;
      this.username=username;
      this.password=password;
      this.skin_type=skin_type;
      this.phone_number=phone_number;
      this.role=role;
  }

    public User(String text, String text0, Callback<DatePicker, DateCell> dayCellFactory, String text1, String text2, String text3, String text4, String typeSelector, String text5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSkin_type() {
        return skin_type;
    }

    public void setSkin_type(String skin_type) {
        this.skin_type = skin_type;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age + ", email=" + email + ", adress=" + adress + ", username=" + username + ", password=" + password + ", skin_type=" + skin_type + ", phone_number=" + phone_number + ", role=" + role + '}';
    }

  

   


    
}
 