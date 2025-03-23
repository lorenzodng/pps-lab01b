package e1;

public abstract class ProxyBankAccount implements BankAccount {

    protected final BankAccount bankAccount;

    @Override
    public abstract void withdraw(int amount);

    protected ProxyBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public int getBalance() {
        return bankAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        bankAccount.deposit(amount);
    }

}
