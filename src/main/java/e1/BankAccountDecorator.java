package e1;
//abstract decorator
public abstract class BankAccountDecorator extends BronzeBankAccount{

    private final BankAccount decoratedBankAccount;

    public BankAccountDecorator(BronzeBankAccount decoratedBankAccount){
        super(decoratedBankAccount.getBalance());
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
