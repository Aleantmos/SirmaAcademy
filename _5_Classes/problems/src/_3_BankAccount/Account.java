package _3_BankAccount;

public class Account {
    private static int currId = 0;
    private int id;
    private double balance = 0;
    private static double interest = 0.02;

    public Account() {
        this.id = ++currId;
    }

    public int getId() {
        return this.id;
    }

    public double getInterest(int years) {
        return (this.balance * interest) * years;
    }

    public static void setInterest(double interest) {
        Account.interest = interest;
    }
    public String deposit(double amount) {
        this.balance += amount;
        return String.format("Deposited %.0f to %d", amount, this.id);
    }
}
