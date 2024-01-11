import java.util.Scanner;

public class Deposit implements Transaction {

    public void execute(User user) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Deposit Operation...");

        System.out.println("Enter Deposit Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid deposit amount. Please try again.");
        } else {
            double newBalance = user.getBalance() + amount;
            user.setBalance(newBalance);
            String transactionDetails = "Deposit: " + user.getUserId() + " - Amount: " + String.format("%.2f", amount);
            System.out.println("Deposit Successful. Amount deposited: " + amount);
            // adding transaction details to transaction history
            atm.logTransaction(transactionDetails);

        }
    }
}
