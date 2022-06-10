package com.daniel.client.managers;

import com.daniel.common.person.Person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CollectionManager {

    private final String path;
    private CommandManager commandManager;
    private LinkedHashMap<Integer, Person> map;

    public CollectionManager(String filePath) {
        if (filePath == null) {
            System.out.println("Путь к файлу должен передаваться через переменную окружения!");
            System.exit(0);
        }
        path = filePath;
    }

    /**
     * Метод загружает коллекцию из файла и активирует интерактивное приложение
     */
    public void run() {
        FileManager fileManager = new FileManager(path);
        try {
            map = fileManager.fromFile();
        } catch (SecurityException | FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        commandManager = new CommandManager(map, fileManager);
        readInput();
    }

    /**
     * Метод реализует чтение команд с консоли
     */
    private void readInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду или help для вывода справки:");
            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if (!"".equals(s)) {
                    String[] line = s.trim().split(" ");
                    commandManager.execute(line);
                }
            }
        }
    }

}
