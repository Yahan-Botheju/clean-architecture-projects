package BankAccount_challenge_1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BankAccount account_1 = new BankAccount(
                "12345",
                "John Doe",
                500.00
        );
        account_1.deposit(2000.00);

        BankAccount account_2 = new BankAccount(
                "457891",
                "Sara Soe",
                200.00
        );
        account_2.withdraw(400.00);


        account_1.displayAccountInfo();
        account_2.displayAccountInfo();
    }
}