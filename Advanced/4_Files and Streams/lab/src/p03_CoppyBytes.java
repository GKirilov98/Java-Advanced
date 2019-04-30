import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class p03_CoppyBytes {
    public static void main(String[] args) {
        String inputPath = "resource/input.txt";
        String outPath = "resource/3_CoppyBytes.txt";
        try (FileInputStream inputStream = new FileInputStream(inputPath);
             FileOutputStream outputStream = new FileOutputStream(outPath)) {
            int read = inputStream.read();
            while (read >= 0){
                if (read == ' ' || read == '\n' ){
                  outputStream.write(read);
                } else {
                    String wordChar = read + "";
                    for (int i = 0; i < wordChar.length(); i++) {
                        outputStream.write(wordChar.charAt(i));
                    }
                }

                read = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
