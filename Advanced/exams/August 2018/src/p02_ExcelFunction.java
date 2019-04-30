import java.util.*;


public class p02_ExcelFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] headers = scanner.nextLine().split(", ");
        String[][] table = new String[n - 1][headers.length];
        for (int row = 0; row < n -1; row++) {
            table[row] = scanner.nextLine().split(", ");
        }

        String[] command = scanner.nextLine().split(" ");
        boolean findIt = false;
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equals(command[1])){
                findIt = true;
            }
        }

        if (!findIt){
            return;
        }

        String header = command[1];
        int index = Arrays.asList(headers).indexOf(header);
        switch (command[0]) {
            case "hide":
                headers = Arrays.stream(headers)
                        .filter( e -> !e.equals(header))
                        .toArray(String[]::new);
               table = Arrays.stream(table)
                       .map( e -> e[index] = "-2")
                       .toArray(String[][]::new);
                break;
            case "sort":
                table = Arrays.stream(table).sorted(Comparator.comparing(a -> a[index])).toArray(String[][]::new);
                break;
            case "filter":
                break;
        }
        System.out.println(String.join(" | ", headers));
        for (String[] row : table) {
            System.out.println(String.join(" | ", row));
        }
    }
}


// for (int col = 0; col < demoTable.get(0).size(); col++) {
//            String header = demoTable.get(0).get(col);
//            currTable.put(header, new  ArrayList<>());
//            for (int row = 1; row < demoTable.size(); row++) {
//                currTable.get(header).add(demoTable.get(row).get(col));
//            }
//        }