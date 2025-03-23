package e1;
//proxy
public class ProxyBronzeBankAccount extends ProxyBankAccount{

    protected ProxyBronzeBankAccount(BankAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    public void withdraw(int amount) {
        if(amount < bankAccount.getBalance()) {
            bankAccount.withdraw(amount);
        } else throw new IllegalStateException();
    }
}
