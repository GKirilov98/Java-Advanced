import java.util.*;
import java.util.stream.Collectors;

public class p10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toCollection(ArrayList::new));
        String line = scanner.nextLine();
        while (!line.equals("Party!")) {
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "Remove":
                    switch (tokens[1]) {
                        case "StartsWith":
                            names = names.stream().filter(e -> !e.startsWith(tokens[2])).collect(Collectors.toList());
                            break;
                        case "EndsWith":
                            names = names.stream().filter(e -> !e.endsWith(tokens[2])).collect(Collectors.toList());
                            break;
                        case "Length":
                         names = names.stream().filter(e -> e.length() != Integer.parseInt(tokens[2])).collect(Collectors.toCollection(ArrayList::new));
                            break;
                    }
                    break;
                case "Double":
                    switch (tokens[1]) {
                        case "StartsWith":
                            ArrayList<String> currName = new ArrayList<>();
                            names.forEach(e -> {
                                if (e.startsWith(tokens[2])) {
                                    currName.add(e);
                                }});
                            names.addAll(currName);
                            break;
                        case "EndsWith":
                            ArrayList<String> currName2 = new ArrayList<>();
                            names.forEach(e -> {
                                if (e.endsWith(tokens[2])) {
                                    currName2.add(e);
                                }});
                            names.addAll(currName2);
                            break;
                        case "Length":
                            ArrayList<String> currName3 = new ArrayList<>();
                            names.forEach(e -> {
                                if (e.length() == Integer.parseInt(tokens[2])) {
                                    currName3.add(e);
                                }});
                            names.addAll(currName3);
                            break;
                    }
                break;
            }

            line = scanner.nextLine();
        }
        if ((names.size() == 1 && names.get(0).equals("")) || names.size() == 0){
            System.out.println("Nobody is going to the party!");
        } else {
            names.sort((a, b) -> a.compareTo(b));
            System.out.println(String.join(", ", names) + " are going to the party!");
        }
    }
}
