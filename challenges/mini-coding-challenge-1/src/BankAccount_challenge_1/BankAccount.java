package BankAccount_challenge_1;

public class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;

    BankAccount(String accountNumber, String accountHolder, double balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    //deposit amount
    void deposit(double amount){
        this.balance += amount;
    }

    //withdraw amount
    void withdraw(double amount){
        if(this.balance <= amount){
            System.out.println("Insufficient funds - " + accountHolder);
            return;
        }
        this.balance -= amount;
    }

    //display amount
    void displayAccountInfo(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Holder: " + balance);
    }
}
