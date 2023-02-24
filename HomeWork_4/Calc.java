package HomeWork_4;

import java.util.Scanner;
 
public class Calc {
    public static void main(String[]args){
            MyOpFactory myOpFactory = new MyOpFactory();
        Calculator calc = new Calculator(myOpFactory);
        calc.exec();
    }
}
interface Operation{
     double exec( double valueOne, double valueTwo );
   } 

   class OpPlus implements Operation{

    @Override
    public double exec(double valueOne, double valueTwo ) {
        return (valueOne + valueTwo );
    }
}

class OpMinus implements Operation{
 
    @Override
    public double exec(double valueOne, double valueTwo ) {
        return (valueOne - valueTwo );
    }
}

class OpMultiply implements Operation{
 
    @Override
    public double exec(double valueOne, double valueTwo ) {
        return (valueOne * valueTwo );
    }
}

class OpDivision implements Operation{

    @Override
    public double exec(double valueOne, double valueTwo ) {
        try{
            double p = valueOne / valueTwo;
        }catch(ArithmeticException e){
            System.out.println(e + " арифметичесская ошибка");
        }
        return (valueOne / valueTwo );
    }
}


interface OperationFactory
   {
     Operation getOpInstance( int op );
   } 

class MyOpFactory implements OperationFactory{
 
    int operationCode;
    private Operation operation;
    
    @Override
    public Operation getOpInstance(int op) {
        this.operationCode = op;
        switch (operationCode){
            case 0:{
                operation = new OpPlus();
                break;
            }
            case 1:{
                operation = new OpMinus();
                break;
            }
            case 2:{
                operation = new OpMultiply();
                break;
            }
            case 3:{
                operation = new OpDivision();
                break;
            }
            default:{
                operation = null;
            }
        }
        return operation;
    }
}

class Calculator {
    
    MyOpFactory myOpFactory;
    
    public Calculator(MyOpFactory myOpFactory){
        this.myOpFactory = myOpFactory;
    }

    public void exec(){
                
        boolean nextStep = true;             
        boolean p = true;
        double buf = 0;
        Scanner in = new Scanner(System.in);    
        do {            
           
            double arg1;
            arg1 = buf;   
            if(p){        
                System.out.println("Введите первый аргумент");
                try{
                if(!in.hasNextDouble()) {
                    throw new NumberFormatException();
                    } else 
                        arg1 = in.nextDouble();                                                      
                }catch(NumberFormatException e){
                    System.out.println(e);   
                    break;                  
                }                    
            }            
            
            System.out.println("Выберите операцию:");
            System.out.print("0 - сумма\t");  
            System.out.print("1 - разность\t");
            System.out.print("2 - уменожение\t");
            System.out.print("3 - деление");
            System.out.println();
            int operation = in.nextInt();
            
            System.out.println("Введите второй аргумент");
            double arg2 = in.nextDouble();
 
            System.out.print("Результат равен:\t");
            Operation op = myOpFactory.getOpInstance(operation);
            if (op != null){
                System.out.println(op.exec(arg1, arg2));
                buf = (int) op.exec(arg1, arg2);
            }
            else System.out.println("Недопустимая операция!!!");
            
            System.out.println("Хотите использовать результат как первый аргумент ?");
            System.out.print("1 - Да\t");
            System.out.println("2 - Нет");
            int what = in.nextInt();
            if (what == 1){
                p = false;
                continue;
            }
            else p = true;
            
            System.out.println("Хотите продолжить?");
            System.out.print("1 - Продолжить\t");
            System.out.println("2 - Выйти");
            int whatDo = in.nextInt();
            if (whatDo == 2) 
                nextStep = false;
        } while (nextStep);
    }
}
