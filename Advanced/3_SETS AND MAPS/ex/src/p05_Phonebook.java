import java.util.HashMap;
import java.util.Scanner;

public class p05_Phonebook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String add = console.nextLine();
        HashMap<String, String> phoneBook = new HashMap<>();
        while (!add.equals("search")) {
            String[] tokens = add.split("-");
            String name = tokens[0];
            String phone = tokens[1];
            phoneBook.put(name, phone);
            add = console.nextLine();
        }

        String search = console.nextLine();
        while (!search.equals("stop")) {
            if(phoneBook.containsKey(search)){
                System.out.printf("%s -> %s%n", search, phoneBook.get(search));
            } else {
                System.out.printf("Contact %s does not exist.%n", search);
            }
            search = console.nextLine();
        }
    }
}
