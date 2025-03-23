package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BronzeBankAccountTest {

    private BronzeBankAccount bronzeBankAccount;

    @BeforeEach
    void beforeEach() {
        int initialBalance = 200;
        bronzeBankAccount= new BronzeBankAccount(initialBalance);
    }

    @Test
    void getBalance() {
        int expectedBalance = 200;
        assertEquals(expectedBalance, bronzeBankAccount.getBalance());
    }

    @Test
    void deposit() {
        int amount = 100;
        bronzeBankAccount.deposit(amount);
        int expectedAmount = 300;
        assertEquals(expectedAmount, bronzeBankAccount.getBalance());
    }

    @Test
    void withdraw() {
        BankAccount bronzeAccountDecorator= new FeeDecorator(bronzeBankAccount);
        BankAccount bronzeProxyAccount= new ProxyBronzeBankAccount(bronzeAccountDecorator);
        int amount = 99;
        bronzeProxyAccount.withdraw(amount);
        int expectedAmount = 101;
        assertEquals(expectedAmount, bronzeBankAccount.getBalance());
    }

    @Test
    void withdrawWithFee() {
        BankAccount bronzeAccountDecorator= new FeeDecorator(bronzeBankAccount);
        BankAccount bronzeProxyAccount= new ProxyBronzeBankAccount(bronzeAccountDecorator);
        int amount= 100;
        bronzeProxyAccount.withdraw(amount);
        int expectedAmount= 99;
        assertEquals(expectedAmount, bronzeBankAccount.getBalance());
    }

    @Test
    void failWithdraw() {
        BankAccount proxyBronzeAccount = new ProxyBronzeBankAccount(bronzeBankAccount);
        int amount = 701;
        assertThrows(IllegalStateException.class, () -> proxyBronzeAccount.withdraw(amount));
    }
}

