/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.view;

/**
 *
 * @author sauru
 */
public class ClientException extends Exception{

    public String signInMessage(){
        return "login not done correctly";
    }
    
     public String signUpMessage(){
        return "registration not done correctly";
    }
     
     public String sendStoryMessage(){
        return "Story send failed.";
    }
      public String sendScoreMessage(){
        return "Score send failed.";
    }
      public String receveStoryMessage(){
        return "Story receved failed.";
    }
      public String storyListMessage(){
        return "Story list receved failed.";
    }
}
