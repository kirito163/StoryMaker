/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 *
 * this class can contain the information of the story and its levels
 */
public class Story implements Serializable {

    private int userId = 0;
    private String username = "";
    private int id = 0;
    private List<Level> level;
    private String title = "";
    private String description = "";
    private double score = 0.0;
    private int nScore = 0;
    private String path = "";
    private Date date;

    public Story() {
    }

    public Story(List<Level> level, String title, String description) {
        this.level = level;
        this.title = title;
        this.description = description;

    }

    public Story(int id, String title, String description, double score, int nScore, Date date, String username) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.score = score;
        this.nScore = nScore;
        this.date = date;
        this.username = username;
    }

    public Story(int id, String title, String description, double score, Date date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.score = score;
        this.date = date;
    }

    public Story(int userId, List<Level> level, String title, String description) {
        this.userId = userId;
        this.level = level;
        this.title = title;
        this.description = description;
    }

    public Story(int id, double score) {
        this.id = id;
        this.score = score;
    }

    public Story(List<Level> level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Level> getStory() {
        return level;
    }

    public void setStory(List<Level> level) {
        this.level = level;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getnScore() {
        return nScore;
    }

    public void setnScore(int nScore) {
        this.nScore = nScore;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getScoreAvg() {
        return Math.round((this.score / this.nScore) * 100.0) / 100.0;
    }

    public Boolean isEmpty() {
        if(this.userId == 0 && this.title == "" && this.level.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
