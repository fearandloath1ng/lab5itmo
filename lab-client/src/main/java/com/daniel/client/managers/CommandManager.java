package com.daniel.client.managers;

import com.daniel.common.commands.Help;
import com.daniel.common.commands.Clear;
import com.daniel.common.commands.Exit;
import com.daniel.common.commands.Info;
import com.daniel.common.commands.Insert;
import com.daniel.common.commands.MaxByCoordinates;
import com.daniel.common.commands.PrintDescending;
import com.daniel.common.commands.RemoveGreater;
import com.daniel.common.commands.RemoveGreaterKey;
import com.daniel.common.commands.RemoveKey;
import com.daniel.common.commands.ReplaceIfLower;
import com.daniel.common.commands.Show;
import com.daniel.common.commands.SumOfHeight;
import com.daniel.common.commands.Update;
import com.daniel.common.person.Person;
import com.daniel.common.util.StringParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CommandManager {

    private final Date initDate;
    private final LinkedHashMap<Integer, Person> map;
    private final StringParser parser = new StringParser();
    private final FileManager fileManager;

    public CommandManager(LinkedHashMap<Integer, Person> map, FileManager fileManager) {
        this.map = map;
        this.fileManager = fileManager;
        initDate = new Date();
    }

    /**
     * Метод выполняет команду, введенную пользователем
     * @param line команда и возможные аргументы
     */
    public void execute(String[] line) {
        String command = line[0];
        if (line.length == 1) {
            noArgsExecute(command);
        } else {
            withArgExecute(command, line[1]);
        }
    }

    /**
     * Выполнение команд без аргументов
     * @param command команда
     */
    private void noArgsExecute(String command) {
        switch (command) {
            case "help":
                new Help().execute();
                break;
            case "clear":
                new Clear().execute(map);
                break;
            case "info":
                new Info().execute(map, initDate);
                break;
            case "max_by_coordinates":
                new MaxByCoordinates().execute(map);
                break;
            case "show":
                new Show().execute(map);
                break;
            case "exit":
                new Exit().execute();
                break;
            case "print_descending":
                new PrintDescending().execute(map);
                break;
            case "remove_greater":
                new RemoveGreater().execute(map);
                break;
            case "save":
                save();
                break;
            case "sum_of_height":
                new SumOfHeight().execute(map);
                break;
            default:
                System.out.println("Неверная команда!");
        }
    }

    /**
     * Выполнение команд, требующих аргумента
     * @param command команда
     * @param arg аргумент в строковом виде
     */
    private void withArgExecute(String command, String arg) {
        if ("execute_script".equals(command)) {
            executeScript(arg);
            return;
        }
        Integer n = parser.toInt(arg);
        if (n == null) {
            return;
        }
        switch (command) {
            case "insert":
                new Insert().execute(map, n);
                break;
            case "remove_greater_key":
                new RemoveGreaterKey().execute(map, n);
                break;
            case "remove_key":
                new RemoveKey().execute(map, n);
                break;
            case "replace_if_lower":
                new ReplaceIfLower().execute(map, n);
                break;
            case "update":
                new Update().execute(map, n);
                break;
            default:
                System.out.println("Неверная команда!");
        }
    }

    /**
     * Команда сохранения коллекции
     */
    private void save() {
        if (map.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        try {
            fileManager.toFile(map);
            System.out.println("Коллекция успешно сохранена в файл!");
        } catch (IOException | SecurityException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Команда для выполнения скрипта
     * @param filePath путь до файла со скриптом
     */
    private void executeScript(String filePath) {
        try {
            File script = new File(filePath);
            fileManager.checkFile(script);
            Scanner scanner = new Scanner(new FileInputStream(script));
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if (!"".equals(s)) {
                    String[] line = s.trim().split(" ");
                    if ("execute_script".equals(line[0])) {
                        System.out.println("Рекурсивное выполнение скриптов невозможно!");
                        continue;
                    }
                    execute(line);
                }
            }
        } catch (IOException | SecurityException e) {
            System.out.println(e.getMessage());
        }
    }


}
