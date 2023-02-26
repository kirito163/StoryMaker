/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author sauru
 */
public class ParserOutput {
    
    private Command command;
    private List<AdvObject> object = new ArrayList<>();
    private AdvObject objectPassive = new AdvObject(0);
    

   

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public List<AdvObject> getObject() {
        return object;
    }

    public void setObject(List<AdvObject> objectj) {
        this.object = objectj;
        
    }
    public void setObjPassive(AdvObject objPassive){
            this.objectPassive = objPassive;
    }
    public AdvObject getObjPassive(){
        return this.objectPassive;
    }
   public void aggObject(AdvObject obj) {
        this.object.add(obj);
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.command);
        hash = 37 * hash + Objects.hashCode(this.object);
        hash = 37 * hash + Objects.hashCode(this.objectPassive);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ParserOutput other = (ParserOutput) obj;
        if (!Objects.equals(this.command, other.command)) {
            return false;
        }
        if (!Objects.equals(this.object, other.object)) {
            return false;
        }
        return Objects.equals(this.objectPassive, other.objectPassive);
    }
   

}

