package com.daniel.common.commands;

import com.daniel.common.person.Person;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Команда выводит сумму полей height всех элементов коллекции
 */
public class SumOfHeight {

    public void execute(LinkedHashMap<Integer, Person> map) {
        if (map.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        int sum = 0;
        for (Map.Entry<Integer, Person> entry: map.entrySet()) {
            sum += entry.getValue().getHeight();
        }
        System.out.println("Сумма значений поля height - " + sum);
    }

}
