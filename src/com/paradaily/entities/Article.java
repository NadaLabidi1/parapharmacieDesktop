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

public class Article {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String title;
    
    private String description;
    
    private String image;
    
    private Date createdAt;
    
    private Collection<ArticleLike> articleLikeCollection;
   
    private User adminId;

    public Article() {
    }

    public Article(Integer id) {
        this.id = id;
    }

    public Article(Integer id, String title, String description, String image,Date createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.createdAt = createdAt;
    }
    public Article( String title, String description,String image ,Date createdAt) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @XmlTransient
    public Collection<ArticleLike> getArticleLikeCollection() {
        return articleLikeCollection;
    }

    public void setArticleLikeCollection(Collection<ArticleLike> articleLikeCollection) {
        this.articleLikeCollection = articleLikeCollection;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", title=" + title + ", description=" + description + ", image=" + image + ", createdAt=" + createdAt + ", articleLikeCollection=" + articleLikeCollection + ", adminId=" + adminId + '}';
    }

        
}
