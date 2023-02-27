

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        try {

            countwords stats = new countwords(args[0]);

            File file = new File("result.txt");
            if (file.createNewFile()){
                System.out.println("File is created!");
            }
            else{
                System.out.println("File already exists.");
            }
            FileWriter writer = new FileWriter (file);
            writer.write("Количество слов в тексте: " + stats.ArrList().size() + "\n");
            writer.write("Самое часто встречающееся слово: " + stats.maxCountWord() + "\n");
            writer.write("Слово '"+stats.maxCountWord()+"' встретилось "+stats.getMax()+" раз");
            writer.close();

        } catch (IOException ignored) {

        }
    }
}