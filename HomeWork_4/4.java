import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> operations = new ArrayList<>();

        while (true) {
            System.out.print("Введите операцию (+, -, *, /) или наберите 'q' для выхода: ");
            String operation = scanner.nextLine();

            if (operation.equals("q")) {
                break;
            }

            if (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")) {
                System.out.println("Неправильная операция!");
                continue;
            }

            System.out.print("Введите первое число: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Введите второе число: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            double result = 0;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Ошибка: деление на ноль!");
                        continue;
                    }
                    result = num1 / num2;
                    break;
            }

            System.out.println("Результат: " + result);
            operations.add(num1 + " " + operation + " " + num2 + " = " + result);
        }

        System.out.println("История операций:");
        for (String operation : operations) {
            System.out.println(operation);
        }

        scanner.close();
    }
}
