/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.model;

import java.io.Serializable;

/**
 *
 * @author sauru
 */
public class Figure implements Serializable{
    
    private  int id;
    private String description;
    private String name;

    
     public Figure(int id) {
        this.id = id;
    }
    public Figure(int id, String name, String description){
        this.id = id;
        this.description = description;
        this.name = name;
        
       
    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
   
            
    
}
