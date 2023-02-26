/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sauru
 */
public class Level implements Serializable{
    private List <Room> room = new ArrayList<>();
    private List <Figure> fig = new ArrayList<>();
    private List <AdvObject> obj = new ArrayList<>();
    private AdvObject objPassive;
    
    public Level(){}
    
    public Level(List<Room> room, List<Figure> fig, List<AdvObject> obj, AdvObject objPassive){
        this.room = room;
        this.fig = fig;
        this.obj = obj;
        this.objPassive = objPassive;
        
    }
    
    public List<Room> getRoom(){
        return this.room;
    }
    public void setRoom(List<Room> room){
        this.room = room;
    }
    public List<Figure> getFigure(){
        return this.fig;
    }
    public void setFigure(List<Figure> fig){
        this.fig = fig;
    }
    public List<AdvObject> getObjActive(){
        return this.obj;
    }
    public void setObjActive(List<AdvObject> obj){
        this.obj = obj;
    }
    public void setObjPassive(AdvObject objPassive){
        this.objPassive = objPassive;
    }
    public AdvObject getObjPassive(){
        return this.objPassive;
    }
   
}
