package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SilverBankAccountTest {

    private SilverBankAccount silverBankAccount;

    @BeforeEach
    void beforeEach() {
        int initialBalance = 200;
        silverBankAccount = new SilverBankAccount(initialBalance);
    }

    @Test
    void getBalance() {
        int expectedBalance = 200;
        assertEquals(expectedBalance, silverBankAccount.getBalance());
    }

    @Test
    void deposit() {
        int amount = 100;
        silverBankAccount.deposit(amount);
        int expectedAmount = 300;
        assertEquals(expectedAmount, silverBankAccount.getBalance());
    }

    @Test
    void withdraw() {
        BankAccount proxySilverAccount = new ProxySilverBankAccount(silverBankAccount);
        int amount = 200;
        proxySilverAccount.withdraw(amount);
        int expectedAmount = 0;
        assertEquals(expectedAmount, silverBankAccount.getBalance());
    }

    @Test
    void failWithdraw() {
        BankAccount proxySilverAccount = new ProxySilverBankAccount(silverBankAccount);
        int amount = 500;
        assertThrows(IllegalStateException.class, () -> proxySilverAccount.withdraw(amount));

    }
}

