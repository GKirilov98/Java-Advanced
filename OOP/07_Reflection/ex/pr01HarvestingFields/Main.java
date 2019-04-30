package pr01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Field[] allFields = RichSoilLand.class.getDeclaredFields();
        String command = scanner.nextLine();
        StringBuilder toPrintResult = new StringBuilder();
        while (!command.equals("HARVEST")) {
            switch (command) {
                case "private":
                    Arrays.stream(allFields)
                            .filter(e -> Modifier.isPrivate(e.getModifiers())).forEach(e -> toPrintResult.append(Modifier.toString(e.getModifiers())).append(" ").append(e.getType().getSimpleName()).append(" ").append(e.getName()).append("\n"));
                    break;
                case "protected":
                    Arrays.stream(allFields)
                            .filter(e -> Modifier.isProtected(e.getModifiers())).forEach(e -> toPrintResult.append(Modifier.toString(e.getModifiers())).append(" ").append(e.getType().getSimpleName()).append(" ").append(e.getName()).append("\n"));
                    break;
                case "public":
                    Arrays.stream(allFields)
                            .filter(e -> Modifier.isPublic(e.getModifiers())).forEach(e -> toPrintResult.append(Modifier.toString(e.getModifiers())).append(" ").append(e.getType().getSimpleName()).append(" ").append(e.getName()).append("\n"));
                    break;
                default:
                    Arrays.stream(allFields).forEach(e -> toPrintResult.append(Modifier.toString(e.getModifiers())).append(" ").append(e.getType().getSimpleName()).append(" ").append(e.getName()).append("\n"));
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.print(toPrintResult);
    }
}
