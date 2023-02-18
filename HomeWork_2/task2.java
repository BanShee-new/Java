package HomeWork_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task2 {
    public static void main(String[] args) throws SecurityException, IOException 
    {
        int size = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader
        ("HomeWork_2/input.txt"))) 
        { 
            while (bufferedReader.readLine() != null) 
               { size += 1; }
        }   catch (IOException e) { e.getMessage(); }

        String[] listData = new String[size];
        try (BufferedReader bufferedReader = new BufferedReader
        (new FileReader("HomeWork_2/input.txt"))) 
        {
            String str;
            int i = 0;
            while ((str = bufferedReader.readLine()) != null) 
            {
                listData[i] = str;
                i++;
            }
        } catch (IOException e) { e.getMessage(); }

        System.out.println("вывод: ");
        for (int i = 0; i < listData.length; i++) 
            { 
                System.out.println(resultText(listData[i])); 
            }
             
    } // END MAIN    

    public static StringBuilder resultText(String line) {
        StringBuilder result = new StringBuilder("");
        String line_one = line.replace("{", "");
        String line_two = line_one.replace("}", "");
        String line_three = line_two.replace("\"", "");
        String[] arrayData = line_three.split(",");
        String[] listName = {"Студент: ", " \tполучил: ", "\t по предмету: "};
        for (int i = 0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            result.append(listName[i]);
            result.append(arrData[1]);
        }
        return result;


    }
}
