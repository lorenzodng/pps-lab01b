package e1;

class SilverBankAccount implements BankAccount {

    private int balance;

    public SilverBankAccount(int balance) {
        this.balance= balance;
    }

    @Override
    public int getBalance() {
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
