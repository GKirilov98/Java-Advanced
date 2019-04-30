import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p06_BalancedParentheses {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String parentheses = console.nextLine();

        if (parentheses.length() % 2 != 0){
            System.out.println("NO");
            return;
        }

        boolean isSimetric = false;
        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char current = parentheses.charAt(i);
            if(current == '[' || current == '{' ||  current == '('){
                openingBrackets.push(current);
            } else {
                char opening = openingBrackets.pop();

                if (opening == '[' && current == ']'){
                    isSimetric = true;
                } else if (opening == '{' && current == '}'){
                    isSimetric = true;
                } else if (opening == '(' && current == ')'){
                    isSimetric = true;
                } else {
                    isSimetric = false;
                    break;
                }
            }
        }

        if (isSimetric){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
