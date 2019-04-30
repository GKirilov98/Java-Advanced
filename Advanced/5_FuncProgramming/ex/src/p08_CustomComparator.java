import java.util.Arrays;
import java.util.Scanner;


public class p08_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] normalNums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] oddNums = Arrays.stream(normalNums).filter( e -> e %2 !=0 ).toArray();
        int[] evenNums = Arrays.stream(normalNums).filter( e -> e %2 ==0 ).toArray();
        for (int i = 0; i < evenNums.length; i++) {
            System.out.print(evenNums[i] + " ");
        }

        for (int i = 0; i < oddNums.length; i++) {
            System.out.print(oddNums[i] + " ");
        }
    }
}
