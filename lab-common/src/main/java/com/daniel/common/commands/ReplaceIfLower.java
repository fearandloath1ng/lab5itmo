package com.daniel.common.commands;

import com.daniel.common.person.Person;
import com.daniel.common.util.InputScanner;

import java.util.LinkedHashMap;

/**
 * Команда обновляет элемент по ключу, если он меньше старого элемента
 */
public class ReplaceIfLower {

    private final InputScanner scanner = new InputScanner();

    public void execute(LinkedHashMap<Integer, Person> map, Integer key) {
        if (map.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        if (!map.containsKey(key)) {
            System.out.println("Элемента с данным ключом не существует!");
            return;
        }
        Person p = new Person(scanner.scanName(), scanner.scanCoordinates(), scanner.scanHeight(),
                scanner.scanBirthday(), scanner.scanWeight(), scanner.scanHairColor(), scanner.scanLocation());
        Person upd = map.get(key);
        if (upd.compareTo(p) > 0) {
            upd.setName(p.getName());
            upd.setCoordinates(p.getCoordinates());
            upd.setHeight(p.getHeight());
            upd.setBirthday(p.getBirthday());
            upd.setWeight(p.getWeight());
            upd.setHairColor(p.getHairColor());
            upd.setLocation(p.getLocation());
            System.out.println("Вы успешно обновили поля элемента!");
        } else {
            System.out.println("Новое значение не меньше старого! Элемент не будет изменен.");
        }
    }

}
