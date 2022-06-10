package com.daniel.common.commands;

import com.daniel.common.person.Person;

import java.util.LinkedHashMap;

/**
 * Команда очищения коллекции
 */
public class Clear {

    public void execute(LinkedHashMap<Integer, Person> map) {
        map.clear();
        System.out.println("Коллекция очищена!");
    }

}
