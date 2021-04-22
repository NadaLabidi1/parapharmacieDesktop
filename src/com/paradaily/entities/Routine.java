/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paradaily.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nada
 */

public class Routine  {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String nameRoutine;
    
    private String notification;
    
    private Collection<Product> productCollection;
  
    private User userId;

    public Routine() {
    }

    public Routine(Integer id) {
        this.id = id;
    }

    public Routine(Integer id, String nameRoutine, String notification) {
        this.id = id;
        this.nameRoutine = nameRoutine;
        this.notification = notification;
    }
    public Routine(String nameRoutine, String notification) {
        this.nameRoutine = nameRoutine;
        this.notification = notification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameRoutine() {
        return nameRoutine;
    }

    public void setNameRoutine(String nameRoutine) {
        this.nameRoutine = nameRoutine;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Routine)) {
            return false;
        }
        Routine other = (Routine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Routine{" + "id=" + id + ", nameRoutine=" + nameRoutine + ", notification=" + notification + ", productCollection=" + productCollection + ", userId=" + userId + '}';
    }

    
    
}
