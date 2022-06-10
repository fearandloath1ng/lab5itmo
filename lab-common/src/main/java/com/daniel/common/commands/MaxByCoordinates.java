package com.daniel.common.commands;

import com.daniel.common.person.Person;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Команда, выводящая максимальное значение поля coordinates
 */
public class MaxByCoordinates {

    public void execute(LinkedHashMap<Integer, Person> map) {
        if (map.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        LinkedList<Person> sorted = new LinkedList<>(map.values());
        sorted.sort(Collections.reverseOrder());
        Person p = sorted.getFirst();
        System.out.println("Элемент с максимальным coordinates:\n" + p);
    }

}
