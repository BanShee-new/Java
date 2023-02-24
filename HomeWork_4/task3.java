package HomeWork_4;

import java.util.Scanner;
import java.util.Vector;

public class task3 {

  private Scanner userInput = new Scanner(System.in);
  private boolean keepOn = true;
  private String yesOrNo;
  public Vector<Double> calculations = new Vector<>();
  
      public void start() {
      System.out.println("Вас привествует консольный калькулятор");
      while(keepOn == true) {
          calculate();
      }
  }

  public String chooseOperator() {
  System.out.println("Какое действие хотите произвести?" +
          "\n + для сложения" +
          "\n - для вычетания" +
          "\n * для умножения" +
          "\n / для деления");

  String operator = userInput.next();
  
  return operator;
}

public double getFirstNumber() {
  System.out.println("Введите первое число");
  return userInput.nextDouble();
}

public double getSecondNumber() {
  System.out.println("Введите второе число");
  return userInput.nextDouble();
}

public void addition(double a, double b){
  calculations.addElement(a + b);
  System.out.println("Результат: " + (a + b));
}

public void division(double a, double b){
  calculations.addElement(a / b);
  System.out.println("Результат: " + (a / b));
}

public void mult(double a, double b){
  calculations.addElement(a * b);
  System.out.println("Результат: " + (a * b));
}

public void sub(double a, double b){
  calculations.addElement(a - b);
  System.out.println("Результат: " + (a - b));
}

public void showMenu() {
  int z = 0;
  while (z != 1){ 
    System.out.println("Пожалуйста, введите соответствующий номер для операции, которую вы хотите выполнить.");
    System.out.println("1. Другая операция");
    System.out.println("2. Исторя операцй");
    System.out.println("3. Выход");
    
    yesOrNo = userInput.next();

    if(yesOrNo.equals("1")) {
      z = 1;
      calculate();
    }
    else if (yesOrNo.equals("3")) {
      z = 1;
      keepOn = false;
      exitMessage();
    }
    else if (yesOrNo.equals("2")){
      loadHistory();
    }
  }
}

public void loadHistory() {
  System.out.println("Вот сделанные расчеты: ");

  for (int i = 0; i < calculations.size(); i++){
    System.out.println(calculations.get(i));
  }
}

public void exitMessage() {
  System.out.println("Вот результаты вычислений, которые вы выполнили: ");

  for (int i = 0; i < calculations.size(); i++){
    System.out.println(calculations.get(i));
  }

  System.out.println("Спасибо, надеюсь все было ОК");
}

public void calculate() {
  int x = 0; 
  //int y = 0; 
  String operation;
  
  while (x < 1) {
    operation = chooseOperator();
    if(operation.equals("+")){
      double num1 = getFirstNumber();
      double num2 = getSecondNumber();
      addition(num1, num2);
      x = 1;
    }
    else if (operation.equals("-")) {
      double num1 = getFirstNumber();
      double num2 = getSecondNumber();
      sub(num1, num2);
      x = 1;
    }
    else if (operation.equals("/")) {
      double num1 = getFirstNumber();
      double num2 = getSecondNumber();
      division(num1, num2);
      x = 1;
    }
   
  else if (operation.equals("*")) {
    double num1 = getFirstNumber();
    double num2 = getSecondNumber();
    mult(num1, num2);
    x = 1;
  }
}
  if (x == 1) {
    showMenu();
  }
} 
}