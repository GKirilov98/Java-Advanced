import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class writeToFile {
    public static void main(String[] args) {
        String inputPath = "resource/input.txt";
        String outputPath = "resource/2_writeToFileOutput.txt";
        List<Character> bannedSimbols = new ArrayList<>();
        Collections.addAll(bannedSimbols, ',','.','!','?');
        try(FileInputStream inputStream = new FileInputStream(inputPath);
            FileOutputStream outputStream = new FileOutputStream(outputPath)) {
            int read =inputStream.read();
            while (read >= 0){
                if (!bannedSimbols.contains((char) read)){
                   outputStream.write(read);
                }

                read = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
