package HomeWork_2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.Date;

public class task4 {
    public static void main(String[] args) throws SecurityException, IOException 
    {
        int a; 
        int b;
        int res = 0;
        char op;

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите 1-е число: ");
        a = sc.nextInt();
        System.out.print("Введите 2-е число: ");
        b = sc.nextInt();
        System.out.print("\nВведите операцию (+, -, *, /): ");
        op = sc.next().charAt(0);
        sc.close();

        if (op == '+')     {res = a + b;}
        else if(op == '-') {res = a - b;}
        else if(op == '*') {res = a * b;}
        else if(op == '/') {res = a / b;}
        else System.out.printf("Неверный ввод !");

        System.out.print("\n   Ответ:\n");
        System.out.printf(a + " " + op + " " + b + " = " + res + "\n");

        Date date = new Date();
        
        Logger logger = Logger.getLogger(task4.class.getName());
        FileHandler fh = new FileHandler
        ("HomeWork_2/logTask4.txt"); 
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        logger.info(date.toString());
        logger.info("Пользователь ввел 1-е число = " + a  + "\nПользователь ввел 2-е число = " + b);
        logger.info("Пользователь ввел 2 число = " + b );
        logger.info("Пользователь ввел оператор '" + op + "'" );
        logger.info
        ("Пользователь получил ответ : " + a + " " + op + " " + b + " = " + res + "\n");

    }

}