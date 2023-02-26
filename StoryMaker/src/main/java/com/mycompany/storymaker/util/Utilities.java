/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.util;

import com.mycompany.storymaker.model.AdvObject;
import com.mycompany.storymaker.model.Figure;
import com.mycompany.storymaker.model.Level;
import com.mycompany.storymaker.model.Room;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.mycompany.storymaker.model.StoryList;

/**
 *
 * @author sauru
 */
public class Utilities {

    public static Set<String> loadFileListInSet(File file) throws IOException {
        Set<String> set = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            set.add(reader.readLine().trim().toLowerCase());
        }
        reader.close();
        return set;
    }

    public static List<String> parseString(String string, Set<String> stopwords) {
        List<String> tokens = new ArrayList<>();
        String[] split = string.toLowerCase().split("\\s+");
        for (String t : split) {
            if (!stopwords.contains(t)) {
                tokens.add(t);
            }
        }
        return tokens;
    }

    public static <T> Set<T> listToSet(List<T> list) {
        Set<T> set = new LinkedHashSet<>();
        for (T o : list) {
            set.add(o);
        }
        return set;
    }

    public static int isThere(List<AdvObject> list, int id) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                System.out.println("issthere ha trovato id");
                return i;
            }
        }
        return -1;
    }

    public static Level levelClone(Level level) {
        Level clonedLevel = new Level();
        List<AdvObject> listObject = new ArrayList<>();
        for (AdvObject o : level.getObjActive()) {
            listObject.add(new AdvObject(o.getId(), o.getName(), o.getDescription(), o.getAlias()));
        }
        clonedLevel.setObjActive(listObject);
        List<Figure> listFigure = new ArrayList<>();
        for (Figure o : level.getFigure()) {
            listFigure.add(new Figure(o.getId(), o.getName(), o.getDescription()));
        }
        clonedLevel.setFigure(listFigure);
        List<Room> listRoom = new ArrayList<>();
        for (Room o : level.getRoom()) {
            listRoom.add(new Room(o.getId(), o.getName(), o.getDescription()));
        }
        clonedLevel.setRoom(listRoom);
        clonedLevel.setObjPassive(new AdvObject(level.getObjPassive().getId(), level.getObjPassive().getName(), level.getObjPassive().getDescription(), level.getObjPassive().getAlias()));
        return clonedLevel;
    }

    public static StoryList twoSortStr(List<String> listString, StoryList storyList) {
        for (int i = 0; i < listString.size(); i++) {
            for (int j = i + 1; j < listString.size(); j++) {
                if (listString.get(i).compareToIgnoreCase(listString.get(j)) > 0) {
                    Collections.swap(listString, i, j);
                    Collections.swap(storyList.getStory(), i, j);

                }
            }
        }
        return storyList;

    }

    public static StoryList twoSortStrReverse(List<String> listString, StoryList storyList) {
        for (int i = 0; i < listString.size(); i++) {
            for (int j = i + 1; j < listString.size(); j++) {
                if (listString.get(i).compareToIgnoreCase(listString.get(j)) < 0) {
                    Collections.swap(listString, i, j);
                    Collections.swap(storyList.getStory(), i, j);

                }
            }
        }
        return storyList;

    }

    public static StoryList twoSortDou(List<Double> listDouble, StoryList storyList) {
        for (int i = 0; i < listDouble.size(); i++) {
            for (int j = i + 1; j < listDouble.size(); j++) {
                if (listDouble.get(i) < listDouble.get(j)) {
                    Collections.swap(listDouble, i, j);
                    Collections.swap(storyList.getStory(), i, j);

                }
            }
        }
        return storyList;
    }

}
