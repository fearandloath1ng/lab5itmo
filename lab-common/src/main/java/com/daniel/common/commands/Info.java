package com.daniel.common.commands;

import com.daniel.common.person.Person;

import java.util.Date;
import java.util.LinkedHashMap;

/**
 * Команда, выводящая информацию о коллекции
 */
public class Info {

    public void execute(LinkedHashMap<Integer, Person> map, Date init) {
        System.out.println("Тип коллекции: " + map.getClass()
                + "\nРазмер коллекции: " + map.size()
                + "\nДата инициализации: " + init);
    }

}
