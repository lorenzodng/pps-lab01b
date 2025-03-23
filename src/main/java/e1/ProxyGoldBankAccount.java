package e1;
//proxy
public class ProxyGoldBankAccount extends ProxyBankAccount {

    private static final int FIDO= 500;

    protected ProxyGoldBankAccount(BankAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= bankAccount.getBalance() || (amount > bankAccount.getBalance() && (amount - bankAccount.getBalance()) <= FIDO)) {
            bankAccount.withdraw(amount);
        } else throw new IllegalStateException();
    }
}
