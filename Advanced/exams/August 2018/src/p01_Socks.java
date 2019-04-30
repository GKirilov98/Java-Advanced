import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p01_Socks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(leftSocks::add);
        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(rightSocks::add);
        ArrayList<String> allPairs = new ArrayList<>();
        while (leftSocks.size() > 0 && rightSocks.size() > 0){
            int leftSock = leftSocks.removeLast();
            int rightSock = rightSocks.removeFirst();
            if (leftSock > rightSock){
                int value = leftSock + rightSock;
                allPairs.add(value + "");
            } else if (leftSock == rightSock) {
                leftSocks.addLast(++leftSock);
            } else {
                rightSocks.addFirst(rightSock);
            }
        }

       int maxPair = allPairs.stream().mapToInt(Integer::parseInt).max().getAsInt();
        System.out.println(maxPair);
        System.out.println(String.join(" ", allPairs));
    }
}
