package HomeWork_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task1 {

    public static void main(String[] args) 
    {
        Map<String, List<String>> book = new HashMap<>();
        book.put("Andrey", List.of("8 901 111 22 33", "8 902 444 55 66"));
        book.put("Oleg", List.of("8 901 333 22 11", "8 902 666 55 44"));
        book.put("Ivan", List.of("8 911 777 66 55"));
        book.put("Olga", List.of("8 910 999 88 77", "8 920 444 33 22"));
        book.put("Maria", List.of("8 913 123 45 67", "8 914 987 65 43"));

        menu(book);
    }

    public static String scan() 
    {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        // scanner.close(); 
        return scan;
    }

    public static void find(Map<String, List<String>> phoneBook)
    // Поиск абонента
    {
        System.out.print("Имя абонента: ");
        String name = scan();
        System.out.println("Имя: "+ name +"\nТелефон(ы): "+ phoneBook.get(name));
    }

    public static void allBook(Map<String, List<String>> AllBook) 
    // Печать телефонной книги
    {
        for (var item : AllBook.entrySet()) 
        {
            System.out.println("Имя: " + item.getKey() + "\nНомер" + item.getValue());
        }
    }

    public static Map<String, List<String>> add(Map<String, List<String>> book) 
    // Добавление в телелефонную книгу
    {
        System.out.print("Имя абонента: ");
        String name = scan();
        List<String> data = new ArrayList<>();
        while (true) {
            System.out.println("Если номеров больше нет, введите '5'");
            System.out.print("Введите номер: ");
            String nomer = scan();
            if (nomer.equals("5")) {
                break;
            } else {
                data.add(nomer);
            }
        }
        book.put(name, data);

        return book;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> book) {
        while (true) {
            System.out.println( " -------------------- \n   Телефонная Книга\n -------------------- \n" +
                "   Меню: \n  \n1. Найти контакт \n2. Добавить контакт"+
                " \n3. Печать телефонной книги \n4. Выход");
            System.out.print("\n Введите пункт меню: ");
            String comands = scan();
            if (comands.equals("4")) {
                break;
            } else {
                switch (comands) {
                    case "1":
                        find(book);
                        break;
                    case "2":
                        add(book);
                        break;
                    case "3":
                        allBook(book);
                        break;
                    default:
                        break;
                }
            }
        }
        return book;
    }
}