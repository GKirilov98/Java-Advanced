import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p07_FixEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        Pattern pattern = Pattern.compile("(.*)\\.us|(.*)\\.com|(.*)\\.uk" );
        LinkedHashMap<String, String> fixed = new LinkedHashMap<>();
        while (!name.equals("stop")) {
            String email = console.nextLine();

            Matcher m = pattern.matcher(email);
            if (!m.matches()) {
                fixed.put(name, email);
            }

            name = console.nextLine();
        }

        fixed.forEach((n, e) -> System.out.println(n + " -> " + e));
    }
}
