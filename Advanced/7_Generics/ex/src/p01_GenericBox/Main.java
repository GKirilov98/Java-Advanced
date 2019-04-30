package p01_GenericBox;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
         Scanner scanner = new Scanner(System.in);
         int n =  Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Integer token =Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(token);
            System.out.println(box.toString());
        }
    }
}
