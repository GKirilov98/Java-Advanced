import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p05_Robotics {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        // take robo data
        String[] allRoboData = console.nextLine().split(";");
        String[] names = new String[allRoboData.length];
        int[] workingTime = new int[allRoboData.length];
        int[] processTime = new int[allRoboData.length];
        for (int i = 0; i < allRoboData.length; i++) {
            String[] tokens = allRoboData[i].split("-");
            names[i] = tokens[0];
            workingTime[i] = Integer.parseInt(tokens[1]);
        }
        //take starting time
        int[] tokensTime = Arrays
                .stream(console.nextLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startingTimeSeconds = (tokensTime[0] * 3600) + (tokensTime[1]*60) + (tokensTime[2]);
        //takeProducts
        ArrayDeque<String> products = new ArrayDeque<>();
        String currProduct = console.nextLine();
        while (!currProduct.equals("End")){
                products.offer(currProduct);
                currProduct = console.nextLine();
        }

        int time = 0;
        while (!products.isEmpty()){
            time ++;
            int currTime = time + startingTimeSeconds;
            String product = products.pollFirst();
            boolean isAssigned = false;
            for (int i = 0; i < names.length; i++) {
                if (processTime[i] == 0 && !isAssigned){
                    processTime[i] = workingTime[i];
                    String clock = convertSecondsToHHMMSS(currTime);
                    isAssigned = true;
                    System.out.printf("%s - %s [%s]%n", names[i], product, clock);
                }

                if (processTime[i] > 0){
                    processTime[i]--;
                }
            }

            if (!isAssigned){
                products.offer(product);
            }
        }
    }

    public static String convertSecondsToHHMMSS(int seconds){

        int s = seconds % 60;
        int m = (seconds/ 60) % 60;
        int h = (seconds / (60 * 60)) % 24;

        return String.format("%02d:%02d:%02d",h,m,s);
    }
}
