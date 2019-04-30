import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner console = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();
        while (true) {
            String page = console.nextLine();
            if (page.equals("Home")) {
                break;
            }

            if (page.equals("back")) {
                if (history.size() <= 1){
                    System.out.println("no previous URLs");
                } else {
                    String currentPage = history.pop();
                    System.out.println(history.peek());
                }
            } else {
                history.push(page);
                System.out.println(page);
            }
        }
    }
}
