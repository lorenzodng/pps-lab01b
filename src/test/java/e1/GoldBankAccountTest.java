package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoldBankAccountTest {

    private GoldBankAccount goldBankAccount;

    @BeforeEach
    void beforeEach(){
        int initialBalance = 200;
        goldBankAccount= new GoldBankAccount(initialBalance);
    }

    @Test
    void getBalance() {
        int expectedBalance= 200;
        assertEquals(expectedBalance, goldBankAccount.getBalance());
    }

    @Test
    void deposit() {
        int amount= 100;
        goldBankAccount.deposit(amount);
        int expectedAmount= 300;
        assertEquals(expectedAmount, goldBankAccount.getBalance());
    }

    @Test
    void withdraw() {
        BankAccount goldProxyAccount= new ProxyGoldBankAccount(goldBankAccount);
        int amount= 200;
        goldProxyAccount.withdraw(amount);
        int expectedAmount= 0;
        assertEquals(expectedAmount, goldBankAccount.getBalance());
    }

    @Test
    void failWithdraw() {
        BankAccount goldProxyAccount= new ProxyGoldBankAccount(goldBankAccount);
        int amount= 701;
        assertThrows(IllegalStateException.class, () -> goldProxyAccount.withdraw(amount));
    }
}