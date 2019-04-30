package p05_Telephony;

import java.util.*;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String[] numbers = scanner.nextLine().split("\\s+");
        List<String> phoneNumbers = new ArrayList<>(Arrays.asList(numbers));
        String[] urls = scanner.nextLine().split("\\s+");
        List<String> sites = new ArrayList<>(Arrays.asList(urls));

        Smartphone smartphone = new Smartphone(phoneNumbers, sites);
        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());

    }
}
