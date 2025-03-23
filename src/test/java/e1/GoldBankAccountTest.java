package e1;

class GoldBankAccountTest extends BankAccountTest<GoldBankAccount>{

    @Override
    protected GoldBankAccount createBankAccount(int initialBalance) {
        return new GoldBankAccount(initialBalance);
    }

    @Override
    protected BankAccount createProxyAccount(GoldBankAccount bankAccount) {
        return new ProxyGoldBankAccount(bankAccount);
    }
}