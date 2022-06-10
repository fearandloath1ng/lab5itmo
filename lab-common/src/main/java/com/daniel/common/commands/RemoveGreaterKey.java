package com.daniel.common.commands;

import com.daniel.common.person.Person;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Команда удаляет все элементы коллекции, чей ключ превышает заданный пользователем
 */
public class RemoveGreaterKey {

    public void execute(LinkedHashMap<Integer, Person> map, Integer key) {
        if (map.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        LinkedList<Integer> keys = new LinkedList<>();
        for (Map.Entry<Integer, Person> entry: map.entrySet()) {
            if (entry.getKey() > key) {
                keys.add(entry.getKey());
            }
        }
        if (!keys.isEmpty()) {
            for (Integer i: keys) {
                map.remove(i);
            }
            System.out.println("Удалены все элементы, чей ключ превышает " + key);
        } else {
            System.out.println("Элементов с превышающим ключом не существует!");
        }
    }

}
