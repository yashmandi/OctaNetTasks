import java.util.ArrayList;
import java.util.List;

public class TransactionHistory implements Transaction {
    private List<String> transactionHistory;

    public TransactionHistory() {
        this.transactionHistory = new ArrayList<>();
    }

    public void execute(User user) {
        System.out.println("Displaying Transaction History: ");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

}
