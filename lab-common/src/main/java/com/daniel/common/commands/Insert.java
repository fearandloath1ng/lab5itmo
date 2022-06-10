package com.daniel.common.commands;

import com.daniel.common.person.Person;
import com.daniel.common.util.InputScanner;

import java.util.LinkedHashMap;

/**
 * Команда, добавляющая элемент в коллекцию по ключу
 */
public class Insert {

    private final InputScanner scanner = new InputScanner();

    public void execute(LinkedHashMap<Integer, Person> map, Integer arg) {
        if (map.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        if (map.containsKey(arg)) {
            System.out.println("Элемент с данным ключом уже существует!");
            return;
        }
        Person p = new Person(scanner.scanName(), scanner.scanCoordinates(), scanner.scanHeight(),
                scanner.scanBirthday(), scanner.scanWeight(), scanner.scanHairColor(), scanner.scanLocation());
        Person.setCount(Person.getCount() + 1);
        p.setId(Person.getCount());
        map.put(arg, p);
        System.out.println("Элемент успешно добавлен под ключом " + arg);
    }

}
