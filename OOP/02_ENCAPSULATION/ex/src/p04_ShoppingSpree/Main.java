package p04_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        LinkedHashMap<String, Product> products = new LinkedHashMap<>();

        try {
            String[] clients = console.readLine().split(";");
            for (int i = 0; i < clients.length; i++) {
                String[] nameMoney = clients[i].split("=");
                String name = nameMoney[0];
                double money = Double.parseDouble(nameMoney[1]);

                Person person = new Person(name, money);
                people.put(name, person);

            }

            String[] consumables = console.readLine().split(";");
            for (int i = 0; i < consumables.length; i++) {
                String[] productCost = consumables[i].split("=");
                String product = productCost[0];
                double cost = Double.parseDouble(productCost[1]);
                Product pro = new Product(product, cost);
                products.put(product, pro);
            }

            while (true) {
                String[] input = console.readLine().split("\\s+");
                if (input[0].equals("END")) {
                    break;
                }

                String client = input[0];
                String product = input[1];

                Person person = people.get(client);
                Product pro = products.get(product);
                person.buyProduct(pro);

            }

            for (Person person : people.values()) {
                if (person.getProducts().isEmpty()){
                    System.out.printf("%s - Nothing bought%n", person.getName());
                } else {
                    System.out.printf("%s - %s%n",
                            person.getName(),
                            String.join(", ", person.getProducts()));
                }
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
