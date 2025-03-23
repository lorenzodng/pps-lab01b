package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class BankAccountTest<Account extends BankAccount> {

    protected Account bankAccount;
    protected abstract Account createBankAccount(int initialBalance);
    protected abstract BankAccount createProxyAccount(Account bankAccount);

    @BeforeEach
    void beforeEach(){
        int initialBalance= 200;
        bankAccount = createBankAccount(initialBalance);
    }

    @Test
    void getBalance(){
        int expectedBalance= 200;
        assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test
    void deposit() {
        int amount = 100;
        bankAccount.deposit(amount);
        int expectedAmount = 300;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void withdraw() {
        BankAccount proxyAccount= createProxyAccount(bankAccount);
        int amount = 99;
        proxyAccount.withdraw(amount);
        int expectedAmount = 101;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void failWithdraw(){
        BankAccount proxyBankAccount= createProxyAccount(bankAccount);
        int amount = 701;
        assertThrows(IllegalStateException.class, () -> proxyBankAccount.withdraw(amount));
    }
}
