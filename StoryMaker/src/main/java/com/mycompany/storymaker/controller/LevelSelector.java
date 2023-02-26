/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.controller;

import com.mycompany.storymaker.model.Level;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * this class checks the inserted elements and puts them in the respective buffer.
 * when a passive object is inserted its buffer is called and the layer is created
 */
public class LevelSelector {
    String roomName;
    String roomDescr;
    String figName;
    String figDescr;
    String objNameActive;
    String objDescrActive;
    String objAliasActive;
    String objNamePassive;
    String objDescrPassive;
    String objAliasPassive;
    String objCommandAliasPassive;
    
    private final List<Level> level = new ArrayList<>();

    private final LevelInitializer levelInitializer = new LevelInitializer();
    
   
    public void init(String roomName, String roomDescr, String figName, String figDescr, String objNameActive, String objDescrActive, String objAliasActive, String objNamePassive, String objDescrPassive, String objAliasPassive, String objCommandAliasPassive){
        
        
        if(figName.isEmpty() && figDescr.isEmpty() && !objNameActive.isEmpty() && !objDescrActive.isEmpty() && !objAliasActive.isEmpty()){
            levelInitializer.bufferRoomObjAct(roomName, roomDescr, objNameActive, objDescrActive, objAliasActive);
        }
        else if(objNameActive.isEmpty() && objDescrActive.isEmpty() && objAliasActive.isEmpty() && !figName.isEmpty() && !figDescr.isEmpty()){
            levelInitializer.bufferRoomFig(roomName, roomDescr, figName, figDescr);
        }
        else if(objNameActive.isEmpty() && objDescrActive.isEmpty() && objAliasActive.isEmpty() && figName.isEmpty() && figDescr.isEmpty()){
            levelInitializer.bufferRoom(roomName, roomDescr);
        }
        else{
            levelInitializer.bufferRoomObjActFig(roomName, roomDescr, figName, figDescr, objNameActive, objDescrActive, objAliasActive);
            
        }
        
          if(!objNamePassive.isEmpty() && !objDescrPassive.isEmpty() && !objAliasPassive.isEmpty() && !objCommandAliasPassive.isEmpty()){
            levelInitializer.bufferObjPas(objNamePassive, objDescrPassive, objAliasPassive, objCommandAliasPassive);
            level.add(levelInitializer.createLevel());
            
            levelInitializer.flushBufferLevel();
          }

   }
   public List<Level> getLevel(){
           
       return this.level;
               
   }
   
  
   
   
}



