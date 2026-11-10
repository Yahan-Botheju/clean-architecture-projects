package BankAccount_challenge_2;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    BankAccount(String accountNumber, String accountHolder, double balance){
        this.accountNumber = accountNumber;
        setAccountHolder(accountHolder);
        this.balance = balance;
    }

    /* __SETTERS__ */

    public void setAccountHolder(String accountHolder) {
        if( accountHolder == null ||  accountHolder.trim().isEmpty()) {
            return;
        }
        this.accountHolder = accountHolder;
    }

    /* __GETTERS__ */

    public String getAccountNumber() {
        return accountNumber;
    }

    //deposit amount
    void deposit(double amount){
        if(amount <= 0){
            System.out.println("Deposit amount must be positive!");
            return;
        }

        this.balance += amount;
    }

    //withdraw amount
    void withdraw(double amount){
        if(this.balance < amount || amount <= 0){
            System.out.println("Insufficient funds");
            return;
        }
        this.balance -= amount;
    }

    //display amount
    void displayAccountInfo(){
        if( accountHolder == null ||  accountHolder.isEmpty()){
            System.out.println("Cannot display account due to insufficient verification!");
            return;
        }
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Holder: " + balance);
    }

}
