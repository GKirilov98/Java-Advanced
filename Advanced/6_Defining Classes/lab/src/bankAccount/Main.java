package bankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
     private static HashMap<Integer, BankAccount> allAccounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "Create":
                    createAccount();
                    break;
              case "Deposit":
                  deposit(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                  break;
              case "SetInterest":
                  setInterest(Double.parseDouble(tokens[1]));
                  break;
               case "GetInterest":
                   getInterest(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                   break;
            }
            line = scanner.nextLine();
        }
    }

    private static void getInterest(int id, int years) {
        if (allAccounts.containsKey(id)){
           double money = allAccounts.get(id).getInterest(years);
            System.out.printf("%.2f%n", money);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void setInterest(double interestRate) {
            BankAccount.setInterestRate(interestRate);
    }

    private static void deposit(int id, double ammount) {
        if (allAccounts.containsKey(id)){
            allAccounts.get(id).deposit(ammount);
            System.out.printf("Deposited %.0f to ID%d%n", ammount, id);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createAccount() {
        BankAccount account = new BankAccount();
        allAccounts.put(account.getId(), account);
        System.out.println("Account ID"+ account.getId() +" created");
    }

}
