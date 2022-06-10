package com.daniel.common.commands;

import com.daniel.common.person.Person;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Команда выводит все элементы коллекции на экран
 */
public class Show {

    public void execute(LinkedHashMap<Integer, Person> map) {
        for (Map.Entry<Integer, Person> entry: map.entrySet()) {
            System.out.println(entry);
        }
    }

}
