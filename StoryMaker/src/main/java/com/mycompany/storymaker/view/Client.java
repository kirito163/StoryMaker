/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.view;

import com.mycompany.storymaker.util.CheckConnection;
import com.google.gson.Gson;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.mycompany.storymaker.model.Story;
import com.mycompany.storymaker.model.StoryList;

/**
 *
 * @author sauru
 */
public class Client {

    public User signIn(User login)  {

        User user = new User();
        Gson gson = new Gson();
        try {
            javax.ws.rs.client.Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:4321");
            Response resp = target.path("storymaker/signIn").request(MediaType.APPLICATION_JSON).put(Entity.entity(gson.toJson(login), MediaType.APPLICATION_JSON));
            CheckConnection.checkStatus(resp.getStatus(), Response.Status.OK.getStatusCode());
            user = gson.fromJson(resp.readEntity(String.class), User.class);
        } catch (ClientException ex) {
            System.err.println(ex.signInMessage());
        }
        return user;

    }

    public boolean signUp(User login) {
        boolean log = false;
        Gson gson = new Gson();
        try {
            javax.ws.rs.client.Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:4321");
            Response resp = target.path("storymaker/signUp").request().put(Entity.entity(gson.toJson(login), MediaType.APPLICATION_JSON));
            CheckConnection.checkStatus(resp.getStatus(), Response.Status.OK.getStatusCode());
            log = true;
        } catch (ClientException ex) {
            System.err.println(ex.signUpMessage());
        }
        return log;

    }

    public boolean send(Story story)  { // send story to server
        boolean send = false;
        Gson gson = new Gson();
        try {
            javax.ws.rs.client.Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:4321");
            Response resp = target.path("storymaker/send").request().put(Entity.entity(gson.toJson(story), MediaType.APPLICATION_JSON));
            CheckConnection.checkStatus(resp.getStatus(), Response.Status.OK.getStatusCode());
            send = true;
        } catch (ClientException ex) {
            System.err.println(ex.sendStoryMessage());
        }
        return send;

    }

    public boolean sendScore(Story story) { // send score value to server
        boolean send = false;
        Gson gson = new Gson();
        try {
            javax.ws.rs.client.Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:4321");
            Response resp = target.path("storymaker/score").request().put(Entity.entity(gson.toJson(story), MediaType.APPLICATION_JSON));
            CheckConnection.checkStatus(resp.getStatus(), Response.Status.OK.getStatusCode());
            send = true;
        } catch (ClientException ex) {
            System.err.println(ex.sendScoreMessage());
        }
        return send;

    }

    public StoryList getStoryList() { // receives the information of the playable stories
        StoryList storyList = new StoryList();
        try {
            javax.ws.rs.client.Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:4321");
            Response resp = target.path("storymaker/getAll").request(MediaType.APPLICATION_JSON).get();
            CheckConnection.checkStatus(resp.getStatus(), Response.Status.OK.getStatusCode());
            Gson gson = new Gson();
            storyList = gson.fromJson(resp.readEntity(String.class), StoryList.class);
        } catch (ClientException ex) {
            System.err.println(ex.storyListMessage());
        }
        return storyList;
    }

    public Story getStory(int id) { // get a selected story from server
        Story story = new Story();
        try {
            javax.ws.rs.client.Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:4321");

            Response resp = target.path("storymaker/getStory").queryParam("storyId", id).request(MediaType.APPLICATION_JSON).get();
            CheckConnection.checkStatus(resp.getStatus(), Response.Status.OK.getStatusCode());
            Gson gson = new Gson();
            story = gson.fromJson(resp.readEntity(String.class), Story.class);
        } catch (ClientException ex) {
            System.err.println(ex.receveStoryMessage());
        }
        return story;
    }
}
