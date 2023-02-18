package HomeWork_2;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String StrokaConsole = sc.nextLine();
        sc.close();
        System.out.println("Ответ: " + Palindrome(StrokaConsole));
    }
    public static Boolean Palindrome(String stroka) 
    {
        return stroka.equals((new StringBuilder(stroka)).reverse().toString());
    }
}