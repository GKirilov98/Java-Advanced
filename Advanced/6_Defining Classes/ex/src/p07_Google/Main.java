package p07_Google;

import java.util.*;

public class Main {

   private static Map<String, Person> allPersons = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            createPerson(tokens[0]);
            switch (tokens[1]) {
                case "company":
                    companyCreate(tokens[0],tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    break;
                case "pokemon":
                    addPokemon(tokens[0],tokens[2], tokens[3]);
                    break;
                case "parents":
                    addParent(tokens[0],tokens[2], tokens[3]);
                    break;
                case "children":
                    addChildren(tokens[0],tokens[2], tokens[3]);
                    break;
                default:
                    carCreate(tokens[0],tokens[2], Integer.parseInt(tokens[3]));

            }

            input = scanner.nextLine();
        }

        String name = scanner.nextLine();
        Person currPer = allPersons.get(name);
        //JelioJelev
        //Company:
        //JeleInc Jelior 777.77
        //Car:
        //AudiA4 180
        //Pokemon:
        //Onyx Rock
        //Charizard Fire
        //Parents:
        //JeleJelev 13/03/1933
        //Children:
        //PudingJelev 01/01/2001

        System.out.println(name);
        System.out.println("Company:" + currPer.getCompany().getInfo());
        System.out.println("Car:" + currPer.getCar().getInfo());
        System.out.print("Pokemon:");
        for (Pokemon pokemon : currPer.getPokemons()) {
            System.out.print(pokemon.getInfo());
        }
        System.out.println();
        System.out.print("Parents:");
        for (Parents parent : currPer.getParents()) {
            System.out.print(parent.getInfo());
        }
        System.out.println();
        System.out.print("Children:");
        for (Children child : currPer.getChildren()) {
            System.out.print(child.getInfo());
        }

    }

    private static void carCreate(String personName, String model, int speed) {
            allPersons.get(personName).getCar().setModel(model);
            allPersons.get(personName).getCar().setSpeed(speed);
    }

    private static void addChildren(String personName, String childName, String birthday) {
        allPersons.get(personName).getChildren().add(new Children(childName, birthday));
    }

    private static void addParent(String personName, String parentName, String birthday) {
        allPersons.get(personName).getParents().add(new Parents(parentName, birthday));
    }

    private static void addPokemon(String personName, String pokemonName, String type) {
        allPersons.get(personName).getPokemons().add(new Pokemon(pokemonName, type));
    }

    private static void companyCreate( String personName, String companyName, String department, double salary) {
            allPersons.get(personName).getCompany().setName(companyName);
            allPersons.get(personName).getCompany().setDepartment(department);
            allPersons.get(personName).getCompany().setSalary(salary);
    }

    private static void createPerson(String personName) {
        if (!allPersons.containsKey(personName)){
            allPersons.put(personName, new Person(personName));
        }
    }
}
