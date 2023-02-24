package HomeWork_4;

import java.util.LinkedList;

public class task1 {

    public static void main(String[] args) {

        int[] listMas = {8,3,2,6,7,4,9,5,1};
        LinkedList<Integer> linkList = new LinkedList<>();
        
        for (Integer temp : listMas) {
            linkList.add(temp);
        }
        System.out.println("Задан следующий linkList: " + linkList);

        int temp = 0;
        while (temp != linkList.size() - 1) {
            linkList.add(linkList.size()-temp, linkList.getFirst());
            linkList.removeFirst();
            temp++;
        }

        System.out.println("Перевернутый linkList: " + linkList);
        
    }
}