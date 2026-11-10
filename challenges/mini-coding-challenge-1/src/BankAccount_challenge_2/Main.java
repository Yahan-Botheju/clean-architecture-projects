package BankAccount_challenge_2;

public class Main {
    public static void main(String[] args) {

      BankAccount account_1 = new BankAccount("1001", "Sara Soe", 2000);

      account_1.deposit(-1000                                                                  );
      account_1.withdraw(5000);
      account_1.displayAccountInfo();


    }
}
