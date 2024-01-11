public class ATM {
    private String userId;
    private String pin;
    private TransactionHistory transactionHistory;

    public ATM(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.transactionHistory = new TransactionHistory();
    }

    public boolean authenticate(String enteredUserId, String enteredPin) {
        return userId.equals(enteredUserId) && pin.equals(enteredPin);
    }

    public void showMenu() {
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    public Transaction getTransaction(int choice) {
        switch (choice) {
            case 1:
                return new TransactionHistory();
            case 2:
                return new Withdraw();
            case 3:
                return new Deposit();
            case 4:
                return new Transfer();
            case 5:
                return new QuitTransaction();
            default:
                System.out.println("Invalid Choice. Please try again.");
                return null;
        }
    }

    public void logTransaction(String transaction) {
        transactionHistory.addTransaction(transaction);
    }
}