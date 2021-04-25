/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paradaily.entities;

/**
 *
 * @author Nada
 */
public class ArtLike {
    
        String title;
        int nbr_like;

    public ArtLike(String title, int nbr_like) {
        this.title = title;
        this.nbr_like = nbr_like;
    }

    public ArtLike() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNbr_like() {
        return nbr_like;
    }

    public void setNbr_like(int nbr_like) {
        this.nbr_like = nbr_like;
    }

    @Override
    public String toString() {
        return "ArtLike{" + "title=" + title + ", nbr_like=" + nbr_like + '}';
    }
        
        
    
}
