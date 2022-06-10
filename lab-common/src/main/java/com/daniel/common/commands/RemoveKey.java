package com.daniel.common.commands;

import com.daniel.common.person.Person;

import java.util.LinkedHashMap;

/**
 * Команда удаляет элемент коллекции по ключу
 */
public class RemoveKey {

    public void execute(LinkedHashMap<Integer, Person> map, Integer key) {
        if (map.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        if (map.containsKey(key)) {
            map.remove(key);
            System.out.println("Удален элемент с ключом " + key);
        } else {
            System.out.println("Элемента с данным ключом не существует!");
        }
    }

}
