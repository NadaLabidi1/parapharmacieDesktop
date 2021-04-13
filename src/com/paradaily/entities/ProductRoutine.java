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
public class ProductRoutine {
    
    private int id;
    private Routine routine_id;
    private Product product_id;

    public ProductRoutine() {
    }

    public ProductRoutine(int id, Routine routine_id, Product product_id) {
        this.id = id;
        this.routine_id = routine_id;
        this.product_id = product_id;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Routine getRoutine_id() {
        return routine_id;
    }

    public void setRoutine_id(Routine routine_id) {
        this.routine_id = routine_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "ProductRoutine{" + "id=" + id + ", routine_id=" + routine_id + ", product_id=" + product_id + '}';
    }
    
}
