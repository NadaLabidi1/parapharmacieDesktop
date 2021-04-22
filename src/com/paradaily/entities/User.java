/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paradaily.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nada
 */

public class User {

   
    private Integer id;
    
    private String firstName;
    
    private String lastName;
    
    private Date dateBirth;
    
    private String email;
    
    private String adress;
    
    private String password;
    
    private String skinType;
    
    private int phoneNumber;
   
    private String username;
    
    private Collection<Routine> routineCollection;
   
    private Collection<ArticleLike> articleLikeCollection;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String firstName, String lastName, Date dateBirth, String email, String adress, String password, String skinType, int phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.email = email;
        this.adress = adress;
        this.password = password;
        this.skinType = skinType;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlTransient
    public Collection<Routine> getRoutineCollection() {
        return routineCollection;
    }

    public void setRoutineCollection(Collection<Routine> routineCollection) {
        this.routineCollection = routineCollection;
    }

    @XmlTransient
    public Collection<ArticleLike> getArticleLikeCollection() {
        return articleLikeCollection;
    }

    public void setArticleLikeCollection(Collection<ArticleLike> articleLikeCollection) {
        this.articleLikeCollection = articleLikeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.paradaily.entities.User[ id=" + id + " ]";
    }
    
}
