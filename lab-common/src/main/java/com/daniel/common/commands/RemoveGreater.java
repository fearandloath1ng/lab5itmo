package com.daniel.common.commands;

import com.daniel.common.person.Person;
import com.daniel.common.util.InputScanner;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Команда удаляет все элементы коллекции, превышающий заданный пользователем
 */
public class RemoveGreater {

    private final InputScanner scanner = new InputScanner();

    public void execute(LinkedHashMap<Integer, Person> map) {
        if (map.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        Person p = new Person(scanner.scanName(), scanner.scanCoordinates(), scanner.scanHeight(),
                scanner.scanBirthday(), scanner.scanWeight(), scanner.scanHairColor(), scanner.scanLocation());
        LinkedList<Integer> keys = new LinkedList<>();
        for (Map.Entry<Integer, Person> entry: map.entrySet()) {
            if (entry.getValue().compareTo(p) > 0) {
                keys.add(entry.getKey());
            }
        }
        if (!keys.isEmpty()) {
            for (Integer i: keys) {
                map.remove(i);
            }
            System.out.println("Удалены все элементы, превышающие заданный");
        } else {
            System.out.println("Элементов, превышающих заданный, не существует!");
        }
    }

}
