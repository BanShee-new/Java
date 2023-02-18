package HomeWork_2;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.Arrays;
    
    public class task1 {
        public static void main(String[] args) throws SecurityException, IOException 
        {
            Logger logger = Logger.getLogger(task1.class.getTypeName());
            FileHandler fh = new FileHandler
            ("HomeWork_2/logTask1.txt");
            //java.util.logging.FileHandler.pattern = HomeWork_2/logTask1.txt
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
    
            int [] masiv = {5, 8, 3, 4, 4, 1, 2};
     
            boolean logic = false;
            int temp;
            while(logic == false) {
                logic = true;
                for (int i = 0; i < masiv.length-1; i++) 
                {
                    if(masiv[i] > masiv[i+1])
                    {
                        logic = false;
                        temp = masiv[i];
                        masiv[i] = masiv[i+1];
                        masiv[i+1] = temp;
                    }
                    // LOG REC
                    logger.info(Arrays.toString(masiv));
                }
            }
            System.out.println(Arrays.toString(masiv));   
        }
    }