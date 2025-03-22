package e1;

public class BronzeBankAccount implements BankAccount {

    private int balance;

    public BronzeBankAccount(int balance) {
        this.balance= balance;
    }

    @Override
    public int getBalance(){
        return balance;
    }

    @Override
    public void deposit(int amount) {
        balance= balance + amount;
    }

    @Override
    public void withdraw(int amount) {
        balance= balance - amount;
    }
}
