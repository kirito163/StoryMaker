/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.controller;

import com.mycompany.storymaker.model.AdvObject;
import com.mycompany.storymaker.model.Figure;
import com.mycompany.storymaker.model.Room;
import com.mycompany.storymaker.model.Level;

import java.util.ArrayList;

import java.util.List;


/**
 * this class works as a buffer, every time a method is called the appropriate lists are validated. 
 * if a passive object has been inserted, another buffer method will be called for the passive object. therefore the buffer level is called twice.
 * 
 */
public class LevelInitializer {
    
    private List <Room> room;
    private List <Figure> fig;
    private List <AdvObject> obj;
    private AdvObject objPassive;
    
    private int count;
    
    public LevelInitializer(){
        room = new ArrayList<>();
        fig = new ArrayList<>();
        obj = new ArrayList<>();
        count = -1; // is used for the id
    }
    
    public void bufferRoomObjAct(String roomName, String roomDescr, String objNameActive, String objDescrActive, String objAliasActive){
        this.count += 1;
        room.add(new Room(count, roomName, roomDescr));
        obj.add(new AdvObject(count, objNameActive, objDescrActive, objAliasActive.split(",")));
    }
    
    public void bufferRoomFig(String roomName, String roomDescr, String figName, String figDescr){
        this.count += 1;
        room.add(new Room(count, roomName, roomDescr));
        fig.add(new Figure(count, figName, figDescr));
    }
    
    public void bufferRoom(String roomName, String roomDescr){
        this.count += 1;
        room.add(new Room(count, roomName, roomDescr));

    }
    
    public void bufferRoomObjActFig(String roomName, String roomDescr, String figName, String figDescr, String objNameActive, String objDescrActive, String objAliasActive){
        this.count += 1;
        room.add(new Room(count, roomName, roomDescr));
        fig.add(new Figure(count, figName, figDescr));
        obj.add(new AdvObject(count, objNameActive, objDescrActive, objAliasActive.split(",")));


    }
    
    public void bufferObjPas(String objNamePassive, String objDescrPassive, String objAliasPassive, String objCmdAliasPassive){
        objPassive = new AdvObject(count, objNamePassive, objDescrPassive, objAliasPassive.split(","));
        objPassive.setPickupable(false);
        objPassive.setCmdAlias(objCmdAliasPassive.split(","));

    }
        
        
      
    
    public Level createLevel(){
        return new Level(this.room, this.fig, this.obj, this.objPassive);
    }
    
    public void flushBufferLevel(){
        room = new ArrayList<>();
        fig = new ArrayList<>();
        obj = new ArrayList<>();
        objPassive = null;
        count = -1;
        
        
    }
   
}
