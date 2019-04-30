package bankAccount;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {
    private static final String NAME_ERROR = "DJ";
    private static final String NAME = "Gosho";
    private static final BigDecimal BALANCE_ERROR = BigDecimal.valueOf(-20.34);
    private static final BigDecimal BALANCE = BigDecimal.valueOf(999.99);
    private static final BigDecimal WITHDRAW = BigDecimal.valueOf(201.25);

    BankAccount bankAccount;
    @Before
    public void createBankAcount(){
        bankAccount = new BankAccount(NAME, BALANCE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameThrowErrorByConstructor(){
        BankAccount bankAccount = new BankAccount(NAME_ERROR, BALANCE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBalanceThrowErrorByConstructor(){
        BankAccount bankAccount = new BankAccount(NAME, BALANCE_ERROR);
    }

    @Test
    public void getNameShouldGiveCorrectlyName(){
        Assert.assertEquals(NAME, bankAccount.getName());
    }

    @Test
    public void getBalanceShouldGiveCorrectlyBalance(){
        Assert.assertEquals(BALANCE, bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void depositShouldThrowErrorNegativeNumber(){
        bankAccount.deposit(BALANCE_ERROR);
    }

    @Test
    public void depositShouldAddCorrectlyBalance(){
        bankAccount.deposit(BALANCE);
        Assert.assertEquals(BALANCE.multiply(BigDecimal.valueOf(2)), bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawShouldThrowErrorForNegativeNumber(){
        bankAccount.withdraw(BALANCE_ERROR);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawShouldThrowErrorForMoreThanBalance(){
        bankAccount.withdraw(BALANCE.add(BALANCE));
    }

    @Test
    public void withdrawShouldSubstractFromBalance(){
        bankAccount.withdraw(WITHDRAW);
        Assert.assertEquals(BALANCE.subtract(WITHDRAW), bankAccount.getBalance());
    }

    @Test
    public void withdrawShouldGiveAmount(){
      BigDecimal amount =  bankAccount.withdraw(WITHDRAW);
        Assert.assertEquals(WITHDRAW, amount);
    }
}