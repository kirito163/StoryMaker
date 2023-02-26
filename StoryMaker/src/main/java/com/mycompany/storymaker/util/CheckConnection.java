/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.util;

import com.mycompany.storymaker.view.ClientException;

/**
 *
 * @author sauru
 */
public class CheckConnection {
    
    public static void checkStatus(int statusCode1, int statusCode2) throws ClientException{
        if(statusCode1 != statusCode2){
            throw new ClientException();
        }
    }
}
