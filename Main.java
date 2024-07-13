import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        db.fillingDatabase();
        userInterface(db);
    }

    public static void userInterface(Database db) {
        Map<String, String> ansewers = new HashMap<>();
        int command;
        String parameter = "";
        Scanner scanCommand = new Scanner(System.in);
        Scanner scanParameter = new Scanner(System.in);
        boolean flagGlobal = true;
        boolean flagInner = true;

        while (flagGlobal) {
            while (flagInner) {
                System.out.println("Выберите характеристику/характеристики для поиска: \n" +
                        "1 - Операционная система\n" +
                        "2 - Цвет ноутбука\n" +
                        "3 - Диагональ экрана\n" +
                        "4 - Объем ОЗУ\n" +
                        "5 - Объем SSD\n" +
                        "6 - Объем видеопамяти\n" +
                        "7 - Завершить выбор и вывести список ноутбуков");

                command = scanCommand.nextInt();

                if (command == 1) {
                    System.out.println("Введите название операционной системы: ");
                    parameter = scanParameter.nextLine();
                    ansewers.put("Operation system", parameter);
                } else if (command == 2) {
                    System.out.println("Введите цвет: ");
                    parameter = scanParameter.nextLine();
                    ansewers.put("Color", parameter);
                } else if (command == 3) {
                    System.out.println("Введите диагональ в дюймах: ");
                    parameter = scanParameter.nextLine();
                    ansewers.put("Screen Diagonal", parameter);
                } else if (command == 4) {
                    System.out.println("Введите объем ОЗУ: ");
                    parameter = scanParameter.nextLine();
                    ansewers.put("RAM", parameter);
                } else if (command == 5) {
                    System.out.println("Введите объем SSD: ");
                    parameter = scanParameter.nextLine();
                    ansewers.put("SSD", parameter);
                } else if (command == 6) {
                    System.out.println("Введите объем памяти видеокарты: ");
                    parameter = scanParameter.nextLine();
                    ansewers.put("Video card", parameter);
                } else {
                    if (ansewers.size() == 0) {
                        System.out.println("Не введено ни одного параметра для поиска");
                    } else {
                        db.outputDatabase(db.filteringDatabase(ansewers));
                    }
                    flagInner = false;
                }
            }
            System.out.println("Повторить ввод параметров и поиск?\n" +
                    "1 - Да\n" +
                    "2 - Нет (завершить программу)");
            command = scanCommand.nextInt();
            if (command == 1) {
                flagInner = true;
            } else if (command == 2) {
                flagGlobal = false;
            }
        }
        scanCommand.close();
        scanParameter.close();
    }
}