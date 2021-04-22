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

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String nameProduct;
    
    private String reference;
    
    private String brand;
    
    private String supplier;
   
    private String timeUse;
    
    private double price;
    
    private String skinType;
    
    private String photoProduct;
    
    private Collection<Routine> routineCollection;
    
    private Category categoryId;
   
    private User adminId;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String nameProduct, String reference, String brand, String supplier, String timeUse, double price, String skinType) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.reference = reference;
        this.brand = brand;
        this.supplier = supplier;
        this.timeUse = timeUse;
        this.price = price;
        this.skinType = skinType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(String timeUse) {
        this.timeUse = timeUse;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public String getPhotoProduct() {
        return photoProduct;
    }

    public void setPhotoProduct(String photoProduct) {
        this.photoProduct = photoProduct;
    }

    @XmlTransient
    public Collection<Routine> getRoutineCollection() {
        return routineCollection;
    }

    public void setRoutineCollection(Collection<Routine> routineCollection) {
        this.routineCollection = routineCollection;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public User getAdminId() {
        return adminId;
    }

    public void setAdminId(User adminId) {
        this.adminId = adminId;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.paradaily.entities.Product[ id=" + id + " ]";
    }
    
}
