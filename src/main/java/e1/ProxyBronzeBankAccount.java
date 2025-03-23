package e1;
//proxy
public class ProxyBronzeBankAccount implements BankAccount {

    private final BankAccount bankAccount;

    public ProxyBronzeBankAccount(BankAccount bankAccount){
        this.bankAccount= bankAccount;
    }

    @Override
    public int getBalance() {
       return bankAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        bankAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if(amount < bankAccount.getBalance()) {
            bankAccount.withdraw(amount);
        } else throw new IllegalStateException();
    }
}
