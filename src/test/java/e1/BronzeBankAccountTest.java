package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BronzeBankAccountTest extends BankAccountTest<BronzeBankAccount>{

    @Override
    protected BronzeBankAccount createBankAccount(int initialBalance) {
        return new BronzeBankAccount(initialBalance);
    }

    @Override
    protected BankAccount createProxyAccount(BronzeBankAccount bankAccount) {
        return new ProxyBronzeBankAccount(bankAccount);
    }

    @Test
    void withdrawWithFee() {
        BankAccount bronzeAccountDecorator= new FeeDecorator(bankAccount);
        BankAccount bronzeProxyAccount= new ProxyBronzeBankAccount(bronzeAccountDecorator);
        int amount= 100;
        bronzeProxyAccount.withdraw(amount);
        int expectedAmount= 99;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }
}

