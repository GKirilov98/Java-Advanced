package p01_Socks;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> left = new ArrayDeque<>(); //Stack
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(left::push);
        ArrayDeque<Integer> right = new ArrayDeque<>(); //Queue
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(right::add);
        ArrayList<String> pairs = new ArrayList<>();
        while (left.size() > 0 && right.size() >0){
            int leftSock = left.remove();
            int rightSock = right.pop();
           if (leftSock > rightSock){
               pairs.add(leftSock+rightSock + "");
           } else if (leftSock == rightSock){
               left.push(++leftSock);
           } else {
               right.addFirst(rightSock);
           }
        }

        System.out.println(pairs.stream().mapToInt(Integer::parseInt).max().getAsInt());
        System.out.println(String.join(" ",  pairs));
    }
}
