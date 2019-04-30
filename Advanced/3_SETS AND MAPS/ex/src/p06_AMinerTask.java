import java.util.LinkedHashMap;
import java.util.Scanner;

public class p06_AMinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, Long> items = new LinkedHashMap<>();
        String stuff = console.nextLine();
        while (!stuff.equals("stop")){
            long quantity = Long.parseLong(console.nextLine());
            items.putIfAbsent(stuff, (long) 0);
            items.put(stuff, quantity + items.get(stuff));
            stuff = console.nextLine();
        }
       items.forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}
