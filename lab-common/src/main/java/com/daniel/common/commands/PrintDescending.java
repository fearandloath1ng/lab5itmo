package com.daniel.common.commands;

import com.daniel.common.person.Person;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Команда выводит коллекцию по убыванию
 */
public class PrintDescending {

    public void execute(LinkedHashMap<Integer, Person> map) {
        if (map.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        LinkedList<Person> sorted = new LinkedList<>(map.values());
        sorted.sort(Collections.reverseOrder());
        for (Person p: sorted) {
            System.out.println(p);
        }
    }

}
