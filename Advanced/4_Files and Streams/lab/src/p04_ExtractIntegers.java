import java.io.*;
import java.util.Scanner;

public class p04_ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "resource/input.txt";
        String outPath = "resource/4_ExtractIntegers.txt";
        try (Scanner scanner = new Scanner(new FileInputStream(inputPath)); PrintWriter printWriter = new PrintWriter(new FileOutputStream(outPath))) {
            while (scanner.hasNext()){
                if (scanner.hasNextInt()){
                    printWriter.println(scanner.nextInt());
                }

                scanner.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
