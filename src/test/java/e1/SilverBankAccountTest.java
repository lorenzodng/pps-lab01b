package e1;

class SilverBankAccountTest extends BankAccountTest<SilverBankAccount> {

    @Override
    protected SilverBankAccount createBankAccount(int initialBalance) {
        return new SilverBankAccount(initialBalance);
    }

    @Override
    protected BankAccount createProxyAccount(SilverBankAccount bankAccount) {
        return new ProxySilverBankAccount(bankAccount);
    }
}

