public class BankAccount {
    private double balance;

    //Constructor
    public BankAccount(double initialBalance) {
        assert initialBalance >= 0 : "initial balance must be >= 0";
        this.balance = initialBalance;
        assert this.balance == initialBalance : "Postcondition failed: balance not set correctly";
    }

    //Deposit method
    public void deposit(double amount) {
        assert amount > 0 : "Deposit must be positive";
        double oldBalance = balance;
        balance += amount;
        assert balance == oldBalance + amount : "Postcondition failed";
    }

    //Withdraw method
    public void withdraw(double amount) {
        assert amount > 0 : "Withdraw amount must be positive";
        assert amount <= balance : "Withdrawal cannot be exceed balance";
        double oldBalance = balance;
        balance -= amount;
        assert balance == oldBalance - amount : "Postcondition failed: withdrawal not applied correctly";
    }

    //Getter method
    public double getBalance() {
        return balance;
    }
}
