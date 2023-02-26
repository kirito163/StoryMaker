/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.controller;

import com.mycompany.storymaker.model.AdvObject;
import com.mycompany.storymaker.model.Command;
import com.mycompany.storymaker.model.CommandType;
import com.mycompany.storymaker.model.Level;
import com.mycompany.storymaker.model.Room;
import com.mycompany.storymaker.util.Utilities;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * 
 */
public abstract class GameDescription {

    List<Command> commands = new ArrayList<>();
    Level clonedLevel; // it is used to remove objects with the take command, without losing them 
    ListIterator<Room> room;
    List<AdvObject> inventory;
    Room currentRoom;

    public void setCommands() {
        Command speak = new Command(CommandType.SPEAK, "parla");
        speak.setAlias(new String[]{"ascolta", "discuti", "dialoga"});
        commands.add(speak);
        Command menù = new Command(CommandType.MENU, "menù");
        menù.setAlias(new String[]{"menu", "comandi", "mosse"});
        commands.add(menù);
        Command next = new Command(CommandType.NEXT, "next");
        next.setAlias(new String[]{"avanti", "su", "prossima"});
        commands.add(next);
        Command previous = new Command(CommandType.PREVIOUS, "previous");
        previous.setAlias(new String[]{"indietro", "giu", "precedente"});
        commands.add(previous);
        Command iventory = new Command(CommandType.INVENTORY, "inventario");
        iventory.setAlias(new String[]{"inv","inventory"});
        commands.add(iventory);
        Command end = new Command(CommandType.END, "end");
        end.setAlias(new String[]{"end", "fine", "esci", "quit", "exit"});
        commands.add(end);
        Command look = new Command(CommandType.LOOK_AT, "osserva");
        look.setAlias(new String[]{"guarda", "vedi", "look", "cerca", "trova"});
        commands.add(look);
        Command pickup = new Command(CommandType.PICK_UP, "raccogli");
        pickup.setAlias(new String[]{"prendi","take"});
        commands.add(pickup);
        Command push = new Command(CommandType.PUSH, "premi");
        commands.add(push);
    }

    public void resetLevel(Level level) {
        
        for(Command push : commands){
            if(push.getType() == CommandType.PUSH){
                push.setAlias(level.getObjPassive().getCmdAlias());
            }
        }
        
        this.room = level.getRoom().listIterator();
        this.clonedLevel = Utilities.levelClone(level); // clone the level
        inventory = new ArrayList<>();
        if (room.hasNext()) {
            this.currentRoom = room.next();
        }
    }
}
