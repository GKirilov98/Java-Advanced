import java.io.*;

public class p05_WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "resource/input.txt";
        String outPath = "resource/5_WriteEveryThirdLine.txt";

        try (BufferedReader reader = new BufferedReader( new FileReader(inputPath));
                PrintWriter printWriter = new PrintWriter(new FileWriter(outPath))){
            String read = reader.readLine();
            int counter = 0;
            while (read != null){
                counter++;
                if (counter % 3 == 0){
                    printWriter.println(read);
                }
                read = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
