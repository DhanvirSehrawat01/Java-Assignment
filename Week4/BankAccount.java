class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;
    Account(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }
    Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }
    boolean deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            return true;
        }
        return false;
    }
    boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            return true;
        }
        return false;
    }
    String getAccountNumber() {
        return accountNumber;
    }
    String getOwnerName() {
        return ownerName;
    }
    double getBalance() {
        return balance;
    }
    public String toString() {
        return "Account Number: " + accountNumber + ", Owner: " + ownerName+ ", Balance: " + balance;
    }
}


public class BankAccount {
    public static void main(String[] args) {

        Account account1 = new Account("A101", "Rahul");
        Account account2 = new Account("A102", "Aman", 5000);

        System.out.println(account1);
        System.out.println(account2);
        System.out.println("Positive deposit: " + account1.deposit(1000));
        System.out.println(account1);
        System.out.println("Zero deposit: "+ account1.deposit(0));
        System.out.println(account1);
        System.out.println("Negative deposit: " + account1.deposit(-500));
        System.out.println(account1);
        System.out.println("Valid withdrawal: " + account1.withdraw(300));
        System.out.println(account1);
        System.out.println("Excessive withdrawal: "+ account1.withdraw(5000));
        System.out.println(account1);
        System.out.println("Account 2:");
        System.out.println(account2);
        account2.deposit(1000);
        System.out.println(account2);
    }
}