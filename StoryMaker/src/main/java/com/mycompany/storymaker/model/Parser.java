/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storymaker.model;

import com.mycompany.storymaker.util.Utilities;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 *
 * @author sauru
 */
public class Parser {

    private final Set<String> stopwords;

    public Parser(Set<String> stopwords) {
        this.stopwords = stopwords;

    }

    private boolean checkForObjPassive(String token, AdvObject objPassive) {
        return objPassive.getName().equals(token) || objPassive.getAlias().contains(token);
    }

   

    private int checkForCommand(String token, List<Command> commands) {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getName().equals(token) || commands.get(i).getAlias().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    private int checkForObject(String token, List<AdvObject> obejcts) {
        for (int i = 0; i < obejcts.size(); i++) {
            if (obejcts.get(i).getName().equals(token) || obejcts.get(i).getAlias().contains(token)) {
                
                return i;
            }
        }
        return -1;
    }

    public ParserOutput parse(String command, List<Command> commands, List<AdvObject> objects, List<Figure> figure, AdvObject objPassive) {
        List<String> tokens = Utilities.parseString(command, stopwords);
        int io;
        ParserOutput parserOutput = new ParserOutput();
        if (!tokens.isEmpty()) {
            int ic = checkForCommand(tokens.get(0), commands);
            if (ic != -1) {
                parserOutput.setCommand(commands.get(ic));
                if (tokens.size() > 1) {

                    ListIterator<String> lit = tokens.listIterator(1);
                    while (lit.hasNext()) {
                        String token = lit.next();
                        io = checkForObject(token, objects);
                        if (io != -1) {
                            parserOutput.aggObject(objects.get(io));
                        } else if (checkForObjPassive(token, objPassive)) {
                            parserOutput.setObjPassive(objPassive);
                        }

                    }
                }
            }
        }
        return parserOutput;
    }
}
