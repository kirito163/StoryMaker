/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.controller;

import com.mycompany.storymaker.model.AdvObject;
import com.mycompany.storymaker.model.CommandType;
import com.mycompany.storymaker.model.Level;
import com.mycompany.storymaker.model.Parser;
import com.mycompany.storymaker.model.ParserOutput;
import com.mycompany.storymaker.util.Printers;
import com.mycompany.storymaker.util.Utilities;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author sauru this class has the purpose of configuring the program to
 * execute the command in history, and to execute the command
 */
public class StoryBuilder extends GameDescription {

    final static int SEC_GIF = 8;

    // 
    File[] dirWins;
    File[] dirEnds;
    File[] dirNexts;

    CommandType lastMove = null;
    boolean exit;    // true if the story is conclused
    boolean descrFinish;  // true if the description and the title of the story have finished to going to output
    ListIterator<Level> lev;
    List<Level> levels;
    Level level;
    JLabel jLabelGif;
    JCheckBoxMenuItem checkAnimation;
    JTextArea textOutput;
    String storyTitle;
    String storyDescription;
    private Parser parser;
    private ParserOutput p;

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getStoryTitle() {
        return this.storyTitle;
    }

    public void setStoryDescription(String storyDescription) {
        this.storyDescription = storyDescription;
    }

    public String getStoryDescription() {
        return this.storyDescription;
    }

    public boolean isDescrFinish() {
        return descrFinish;
    }

    public void setDescrFinish(boolean descrFinish) {
        this.descrFinish = descrFinish;
    }

    public void config(List<Level> levels, JTextArea textOutput, JLabel jLabelGif, JCheckBoxMenuItem checkAnimation) {
        this.checkAnimation = checkAnimation;
        this.jLabelGif = jLabelGif;
        this.exit = false;
        this.descrFinish = false; // description finish when press enter
        this.levels = levels;
        this.textOutput = textOutput;
        this.inventory = new ArrayList<>();
        this.lev = levels.listIterator();
        if (lev.hasNext()) {
            this.level = lev.next();
        }
        resetLevel(level); // set the level for playng
        try {
            Set<String> stopwords = Utilities.loadFileListInSet(new File("./resources/stopwords"));
            this.parser = new Parser(stopwords);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        textOutput.setText(Printers.printerStoryDescription(storyTitle, storyDescription));
        setCommands();
        gifDir();

    }

    public void printRoom() {
        textOutput.setText(Printers.printerRoomDescription(currentRoom.getName(), currentRoom.getDescription()));
    }

    private void gifDir() {
        File dirWin = new File("./resources/img/gif/gif_win");
        this.dirWins = dirWin.listFiles();
        File dirEnd = new File("./resources/img/gif/gif_end");
        this.dirEnds = dirEnd.listFiles();
        File dirNext = new File("./resources/img/gif/gif_next");
        this.dirNexts = dirNext.listFiles();
    }

    //this methods print random gif from directory for tot second
    private void printerWin() {
        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                Long startTime = System.currentTimeMillis();
                Long endTime = System.currentTimeMillis();
                Random rand = new Random();
                Icon icon = new ImageIcon(dirWins[rand.nextInt(dirWins.length)].getPath());
                jLabelGif.setSize(icon.getIconWidth(), icon.getIconHeight());
                jLabelGif.setIcon(icon);
                jLabelGif.setVisible(true);
                while (((endTime - startTime) / 1000) <= SEC_GIF) {
                    endTime = System.currentTimeMillis();
                }
                jLabelGif.setIcon(null);
            }
        }
        );
        animation.start();
    }

    private void printerEnd() {
        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                Long startTime = System.currentTimeMillis();
                Long endTime = System.currentTimeMillis();
                Random rand = new Random();
                Icon icon = new ImageIcon(dirEnds[rand.nextInt(dirEnds.length)].getPath());
                jLabelGif.setSize(icon.getIconWidth(), icon.getIconHeight());
                jLabelGif.setIcon(icon);
                jLabelGif.setVisible(true);
                while (((endTime - startTime) / 1000) <= SEC_GIF) {
                    endTime = System.currentTimeMillis();
                }
                jLabelGif.setIcon(null);
            }
        }
        );
        animation.start();
    }

    private void printerNextLvl() {
        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                Long startTime = System.currentTimeMillis();
                Long endTime = System.currentTimeMillis();
                Random rand = new Random();
                Icon icon = new ImageIcon(dirNexts[rand.nextInt(dirNexts.length)].getPath());
                jLabelGif.setSize(icon.getIconWidth(), icon.getIconHeight());
                jLabelGif.setIcon(icon);
                jLabelGif.setVisible(true);
                while (((endTime - startTime) / 1000) <= SEC_GIF) {
                    endTime = System.currentTimeMillis();
                }
                jLabelGif.setIcon(null);
            }
        }
        );
        animation.start();
    }

    public boolean game(String command) {

        p = parser.parse(command, commands, level.getObjActive(), level.getFigure(), level.getObjPassive());
        if (p.getCommand() == null) {
            textOutput.setText("try another command");
        } else {
            switch (p.getCommand().getType()) {

                case END:
                    if (checkAnimation.isSelected()) {
                        printerEnd();
                    } else {
                        textOutput.setText("bye bye\n\npress Enter to continue");

                    }
                    return exit = true;

                case NEXT:
                    if (lastMove == CommandType.NEXT || lastMove == null) {
                        lastMove = CommandType.NEXT;
                        if (room.hasNext()) {
                            currentRoom = room.next();
                            textOutput.setText(Printers.printerRoomDescription(currentRoom.getName(), currentRoom.getDescription()));
                        } else {
                            textOutput.setText("you can not pass");
                        }
                    } else if (lastMove == CommandType.PREVIOUS) {
                        lastMove = CommandType.NEXT;
                        if (room.hasNext()) {
                            currentRoom = room.next();
                        }
                        if (room.hasNext()) {
                            currentRoom = room.next();
                            textOutput.setText(Printers.printerRoomDescription(currentRoom.getName(), currentRoom.getDescription()));
                        } else {
                            textOutput.setText("you can not pass");
                        }
                    }
                    break;

                case PREVIOUS:
                    if (lastMove == CommandType.PREVIOUS || lastMove == null) {
                        lastMove = CommandType.PREVIOUS;
                        if (room.hasPrevious()) {
                            currentRoom = room.previous();
                            textOutput.setText(Printers.printerRoomDescription(currentRoom.getName(), currentRoom.getDescription()));
                        } else {
                            textOutput.setText("you can not pass");
                        }
                    } else if (lastMove == CommandType.NEXT) {
                        lastMove = CommandType.PREVIOUS;
                        if (room.hasPrevious()) {
                            currentRoom = room.previous();
                        }
                        if (room.hasPrevious()) {
                            currentRoom = room.previous();
                            textOutput.setText(Printers.printerRoomDescription(currentRoom.getName(), currentRoom.getDescription()));
                        } else {
                            textOutput.setText("you can not pass");
                        }
                    }
                    break;

                case INVENTORY:
                    textOutput.setText(Printers.printerInventory(inventory));
                    break;

                case LOOK_AT:
                    textOutput.setText(Printers.printerLookAround(clonedLevel.getObjActive(), level.getObjPassive(), currentRoom.getId()));
                    break;

                case PICK_UP:
                    if (p.getObject() != null) {
                        if (Utilities.isThere(clonedLevel.getObjActive(), currentRoom.getId()) != -1) {
                            if (Utilities.isThere(p.getObject(), currentRoom.getId()) != -1) {

                                int listIndex = Utilities.isThere(clonedLevel.getObjActive(), currentRoom.getId());
                                AdvObject objInv = clonedLevel.getObjActive().get(listIndex);
                                inventory.add(objInv);
                                clonedLevel.getObjActive().remove(objInv);
                                textOutput.setText("you collected: " + objInv.getName());
                            } else {
                                textOutput.setText("collect what?!");
                            }
                        } else if (p.getObjPassive() != null) {
                            if (p.getObjPassive().equals(level.getObjPassive())) {
                                textOutput.setText("you cannot pick up this item.");
                            }
                        } else {
                            textOutput.setText("there is nothing to collect.");
                        }
                    }
                    break;

                case SPEAK:
                    if (level.getFigure() != null) {
                        textOutput.setText(Printers.printerSpeak(level.getFigure(), currentRoom.getId()));
                    }
                    break;

                case PUSH:
                    Set<AdvObject> setInvObj = Utilities.listToSet(inventory);
                    Set<AdvObject> setParserObj = Utilities.listToSet(p.getObject());
                    Set<AdvObject> setObjActive = Utilities.listToSet(level.getObjActive());
                    
                    
                    
                    if (setObjActive.equals(setInvObj) && p.getObjPassive().equals(level.getObjPassive())) {

                        if (lev.hasNext()) {
                            if (checkAnimation.isSelected()) {
                                printerNextLvl();
                            }
                            this.level = lev.next();
                            resetLevel(level);
                            printRoom();
                        } else {
                            if (checkAnimation.isSelected()) {
                                printerWin();
                            } else {
                                textOutput.setText("you win\n\npress Enter to continue.");
                            }
                            return exit = true;
                        }
                    } else if (setObjActive.isEmpty() && setParserObj.isEmpty() && p.getObjPassive().equals(level.getObjPassive())) {

                        if (lev.hasNext()) {
                            if (checkAnimation.isSelected()) {
                                printerNextLvl();
                            }
                            this.level = lev.next();
                            resetLevel(level);
                            printRoom();
                        } else {
                            if (checkAnimation.isSelected()) {
                                printerWin();
                            } else {
                                textOutput.setText("you win\n\npress Enter to continue.");
                            }
                            return exit = true;
                        }
                    } else if(!setObjActive.equals(setInvObj) && p.getObjPassive().equals(level.getObjPassive())){
                        textOutput.setText("sorry.. but you forgot to take something.");
                    } else {
                        textOutput.setText("you are acting on something wrong.");
                    }
                    break;

                case MENU:
                    textOutput.setText(Printers.printerMenù(commands));
                    break;
            }
        }
        return false;
    }

}
