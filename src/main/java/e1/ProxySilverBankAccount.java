package e1;
//proxy
public class ProxySilverBankAccount extends ProxyBankAccount {

    protected ProxySilverBankAccount(BankAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    public void withdraw(int amount) {
        if(amount <= bankAccount.getBalance()) {
            bankAccount.withdraw(amount);
        } else throw new IllegalStateException();
    }
}
