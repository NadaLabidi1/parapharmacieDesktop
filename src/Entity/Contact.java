/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author manel
 */
public class Contact {
    private int id;
    private String email;
    private String subject;
    private String message;
    
    public Contact(){
        
    }
    
    public Contact (int id , String email, String subject, String message){
        this.id=id;
       
        this.email=email;
        this.subject=subject;
        this.message=message;
        
    }
    public Contact ( String email, String subject, String message){
       
        this.email=email;
        this.subject=subject;
        this.message=message;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        final Contact other = (Contact) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", email=" + email + ", subject=" + subject + ", message=" + message + '}';
    }

   
    
}
