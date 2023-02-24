package HomeWork_4;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.*;

public class task3ver2 {
    public static void main(String[] args) throws SecurityException, IOException {
        System.out.println("Ну, давайте считать!\n");
        
        Logger log = Logger.getLogger(task3ver2.class.getName());
        FileHandler handlers = new FileHandler("./HomeWork_4/File_logger_calc.txt");
        SimpleFormatter s_format = new SimpleFormatter();
        handlers.setFormatter(s_format);
        log.addHandler(handlers);
    
        Stack<String> stack = new Stack<>();
        double input_number = 0;
        double input_number_two = 0;
        double res = 0;
        boolean flag = true;

        Scanner iScanner = new Scanner(System.in, "Cp866");
        System.out.print("Введите первое число: ");
        if (iScanner.hasNextDouble()) {
            input_number = iScanner.nextDouble();
            stack.push(Double.toString(input_number));

            System.out.print("Доступные операции: '+' сложение  |  '-' вычитание  |  '/' деление  |  '*' умножене \nКакую операцию хотите выполнить? ");
            String input_operant = iScanner.next();

            while (flag) {
                if (input_operant.equals("+") || input_operant.equals("-") 
                || input_operant.equals("*") || input_operant.equals("/")) {
                    System.out.print("Введите второе число: ");

                    if (iScanner.hasNextDouble()) {
                        input_number_two = iScanner.nextDouble();

                        if (input_operant.equals("+")) res = input_number + input_number_two;
                        else if (input_operant.equals("-")) res = input_number - input_number_two;
                        else if (input_operant.equals("/")) res = input_number / input_number_two;
                        else if (input_operant.equals("*")) res = input_number * input_number_two;

                        String result = input_number + " " + input_operant + " " + input_number_two + " = " + res;
                        System.out.println("\nРезультат выполнения -> " + result + "\n");
                       

                        log.info("\tОператор пользователя - " + input_operant +
                                "\n\tПервое число пользователя - " + input_number +
                                "\n\tВторое число пользователя - " + input_number_two +
                                "\n\tРезультат выполненной операции - " + res);

                        System.out.println("\nДоступные операции: '+'  |  '-'  |  '/'  |  '*'" +
                                            "\nДля продолжения введите операцию\nДля отмены операции напишите 'отмена'" + 
                                            "\nДля завершения напишите 'стоп'");

                        input_operant = iScanner.next();

                        if (input_operant.equalsIgnoreCase("стоп")) {
                            flag = false;
                            log.info("Stop");
                        } else if (input_operant.equalsIgnoreCase("отмена")) {
                            log.info("\tОтмена");
                            System.out.println("\n" + stack + "\nДо какого числа отменить опрерацию? ");
                            
                            if (iScanner.hasNextDouble()) {
                                String temp = iScanner.next();

                                if (stack.search(temp) != 1) {
                                    input_number = Double.parseDouble(stack.pop());
                                    while (input_number != Double.parseDouble(temp)) {
                                        input_number = Double.parseDouble(stack.pop());
                                    }
                                    stack.push(Double.toString(input_number));
                                } else {
                                    System.out.println("Такого чила здесь нету");
                                    log.info("Выполнение прервано - некорректное число");
                                    flag = false;
                                }
                            } else {
                                System.out.println("Это не число. Перезапустите программу и попробуйте снова!");
                                log.info("Выполнение прервано - некорректное число");
                                flag = false;
                            }
                            
                            System.out.println("\nПервое число: " + input_number);
                            System.out.print("Доступные операции: '+'  |  '-'  |  '/'  |  '*'\nКакую операцию хотите выполнить? ");
                            input_operant = iScanner.next();
                            
                        } else {
                            stack.push(Double.toString(res));
                            input_number = Double.parseDouble(stack.peek());
                            System.out.println("\nПервое число: " + input_number);
                            System.out.println("Операция для выполнения: " + input_operant);
                        }
                    } else {
                        System.out.println("Это не число. Перезапустите программу и попробуйте снова!");
                        log.info("Выполнение прервано - некорректное число");
                        flag = false;
                    }
                } else {
                    System.out.println("К сожалению такой операции здесь нету");
                    log.info("Выполнение прервано - неверная операция");
                    flag = false;
                }
            } 
        } else {
            System.out.println("Это не число. Перезапустите программу и попробуйте снова!");
            log.info("Выполнение прервано - некорректное число");
        }
        iScanner.close();
    }
} 