import java.util.Scanner;

public class Withdraw implements Transaction {
    private static final double WITHDRAW_LIMIT = 1000.0;

    // Overloaded execute method with TransactionHistory for logging
    public void execute(User user, TransactionHistory transactionHistory) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Withdrawal Operation...");

        // Prompt for withdrawal amount
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        // Validate amount and perform withdrawal
        if (isValidAmount(amount, user.getBalance())) {
            double newBalance = user.getBalance() - amount;
            user.setBalance(newBalance);
            System.out.println("Withdrawal Successful. Amount withdrawn: " + amount);

            // Log transaction using TransactionHistory object
            if (transactionHistory != null) {
                transactionHistory.addTransaction(
                        "Withdrawal: " + user.getUserId() + " - Amount: " + String.format("%.2f", amount));
            }
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds. Please try again.");
        }
    }

    // Implementation of the abstract method from Transaction interface
    @Override
    public void execute(User user) {
        // Delegate to the overloaded method with default TransactionHistory handling
        execute(user, null);
    }

    // Helper method for validation
    private boolean isValidAmount(double amount, double balance) {
        return amount <= WITHDRAW_LIMIT && amount > 0 && amount <= balance;
    }
}
