package p01_reverseArray;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
         Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(stack::push);
        System.out.println(String.join(" ", stack));
    }
}
