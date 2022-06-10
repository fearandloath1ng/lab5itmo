package com.daniel.common.commands;

import com.daniel.common.person.Person;
import com.daniel.common.util.InputScanner;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Команда обновляет поля элемента по его id
 */
public class Update {

    private final InputScanner scanner = new InputScanner();

    public void execute(LinkedHashMap<Integer, Person> map, int arg) {
        if (map.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        Person p = null;
        for (Map.Entry<Integer, Person> entry: map.entrySet()) {
            if (entry.getValue().getId() == arg) {
                p = entry.getValue();
            }
        }
        if (p == null) {
            System.out.println("Элемента с заданным id не существует!");
            return;
        }
        p.setName(scanner.scanName());
        p.setCoordinates(scanner.scanCoordinates());
        p.setHeight(scanner.scanHeight());
        p.setBirthday(scanner.scanBirthday());
        p.setWeight(scanner.scanWeight());
        p.setHairColor(scanner.scanHairColor());
        p.setLocation(scanner.scanLocation());
        System.out.println("Вы успешно обновили поля элемента!");
    }

}
