package HomeWork_4;

import java.util.LinkedList;

public class task2 {

    public static void main(String[] args) {

        int[] list = { 3, 5, 7, 2, 4, 6 };

        LinkedList<Integer> linkList = new LinkedList<>();
        for (Integer temp : list) {
            linkList.add(temp);
        }
        String str = new String();
        System.out.println("Задан следующий linkList: " +linkList);
        System.out.println(str);
        enqueue(linkList, 9);
        System.out.println("В конец очереди заданного linkList добавлен элемент: " +linkList);
        System.out.println(str);
        System.out.println("Первый элемент заданного linkList: " +dequeue(linkList));
        System.out.println("linkList после удаления первого элемента: " +linkList);
        System.out.println(str);
        System.out.println("Первый элемент заданного linkList: " +first(linkList));
        System.out.println("linkList без удаления первого элемента: " +linkList);
    }

    public static void enqueue(LinkedList<Integer> list, int num) {
        list.addLast(num);
    }

    public static int dequeue(LinkedList<Integer> list) {
        int num = 0;
        num = list.get(0);
        list.remove(0);
        return num;
    }

    public static int first(LinkedList<Integer> list) {
        int num = 0;
        num = list.get(0);
        return num;
    }
}
