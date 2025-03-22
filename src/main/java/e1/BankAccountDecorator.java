package e1;
//abstract decorator
public abstract class BankAccountDecorator implements BankAccount{

    private BankAccount decoratedBankAccount;

    public BankAccountDecorator(BankAccount decoratedBankAccount){
        this.decoratedBankAccount= decoratedBankAccount;
    }

    @Override
    public int getBalance() {
        return decoratedBankAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        decoratedBankAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        decoratedBankAccount.withdraw(amount);

    }
}
