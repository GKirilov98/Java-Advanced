import java.util.ArrayDeque;
import java.util.Scanner;
//50/100
public class p08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<String> backHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();
        while (true) {
            String page = console.nextLine();
            if (page.equals("Home")) {
                break;
            }

            if (page.equals("back")) {
                if (backHistory.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    String currentPage = backHistory.pop();
                    forwardHistory.offer(currentPage);
                    System.out.println(backHistory.peek());
                }
            } else if (page.equals("forward")) {
                if (forwardHistory.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    String currForwardPage = forwardHistory.poll();
                    backHistory.push(currForwardPage);
                    System.out.println(backHistory.peek());
                }
            } else {
                backHistory.push(page);
                System.out.println(page);
            }
        }
    }

}
