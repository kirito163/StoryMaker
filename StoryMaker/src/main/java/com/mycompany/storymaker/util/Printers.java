/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.util;

import com.mycompany.storymaker.model.AdvObject;
import com.mycompany.storymaker.model.Command;
import com.mycompany.storymaker.model.Figure;
import java.util.List;

/**
 *
 * @author sauru
 */
public class Printers {
    public static String printerStoryDescription(String title, String description) {
        return "title: " + title + "\ndescription: " + description + "\n\n press enter to continue";
    }
    
    public static String printerRoomDescription(String roomName, String roomDescription) {
        return "place: " + roomName + "\ndescription: " + roomDescription;
    }

    public static String printerInventory(List<AdvObject> inventory) {
        if (inventory.isEmpty()) {
            return "inventory is empty";

        } else {
            StringBuffer string = new StringBuffer();
            for (AdvObject o : inventory) {
                string.append(o.getName() + "\n");
            }
            return "in the inventory there are:\n" + string.toString();
        }

    }

    public static String printerLookAround(List<AdvObject> objectActive, AdvObject objectPassive, int id) {
        for (AdvObject o : objectActive) {

            if (o.getId() == id && objectPassive.getId() == id) {
                return "mmmh there seems to be something important here...\n" + o.getDescription() + "\nmmmh here it seems there is more\n" + objectPassive.getDescription();
            } else if (o.getId() == id) {
                return "mmmh there seems to be something important here...\n" + o.getDescription();
            } 
        } if (objectPassive.getId() == id) {
                return "mmmh there seems to be something important here...\n" + objectPassive.getDescription();
            }

        return "there is nothing here";
    }

    public static String printerSpeak(List<Figure> figure, int id) {

        for (Figure o : figure) {
            if (o.getId() == id) {
                return "i am: " + o.getName() + "\n" + o.getDescription();
            }
        }
        return "there is no one to talk to";
    }

    public static String printerMenù(List<Command> command) {
        StringBuffer string = new StringBuffer();
        for (Command o : command) {
            string.append(o.getName() + "\n");
        } 
        return "COMMAND LIST:\n" + string.toString();
    }

    

}
