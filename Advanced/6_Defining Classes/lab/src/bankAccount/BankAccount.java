package bankAccount;

class BankAccount {
    private int id;
    private double balance;

    private static double interestRate = 0.02;
    private static int accountsCount = 0;

    public BankAccount() {
        accountsCount++;
        this.id = accountsCount;
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interRate) {
      interestRate = interRate;
    }

    public double getInterest(int years){
        return interestRate  * years * this.balance;
    }
}
