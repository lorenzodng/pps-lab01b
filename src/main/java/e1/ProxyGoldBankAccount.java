package e1;
//proxy
public class ProxyGoldBankAccount implements BankAccount {

    private BankAccount bankAccount;
    private final int FIDO= 500;

    public ProxyGoldBankAccount(BankAccount bankAccount){
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
        if (amount <= bankAccount.getBalance() || (amount > bankAccount.getBalance() && (amount - bankAccount.getBalance()) <= FIDO)) {
            bankAccount.withdraw(amount);
        } else throw new IllegalStateException();
    }
}
