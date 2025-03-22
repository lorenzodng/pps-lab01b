package e1;
//concrete decorator
public class FeeDecorator extends BankAccountDecorator {

    private static final double WITHDRAWAL_WITH_FEE= 100;
    private static final int FEE_BRONZE_BANK_ACCOUNT= 1;

    public FeeDecorator(BankAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    public int getBalance() {
        return super.getBalance();
    }

    @Override
    public void deposit(int amount) {
        super.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if(amount >= WITHDRAWAL_WITH_FEE){
            super.withdraw(amount + FEE_BRONZE_BANK_ACCOUNT);
        } else{
            super.withdraw(amount);
        }
    }

}
