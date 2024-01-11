import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Transfer implements Transaction {

    public void execute(User user) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Transfer Operation...");

        System.out.println("Enter recipient's account number: ");
        String recipientAcc = sc.nextLine();

        // assuming recipient's accout is represented as another user object
        User recipientUser = findUserByAccountNumber(recipientAcc);

        if (recipientUser == null) {
            System.out.println("Recipient account number not found. Please check the account number.");
        } else {
            // implementing transfer logic
            System.out.println("Enter Deposit Amount: ");
            double amount = sc.nextDouble();
            user.setBalance(user.getBalance() - amount);
            recipientUser.setBalance(recipientUser.getBalance() + amount);

            System.out.println("Transfer successful. Amount transferred to " + recipientUser + ": " + amount);
        }
    }

    private User findUserByAccountNumber(String accountNum) {
        // assuming all users are in a collection
        List<User> allUsers = getAllUsers();
        return allUsers.stream().filter(user -> user.getAccountNum().equals(accountNum)).findFirst().orElse(null);
    }

    private List<User> getAllUsers() {
        return Collections.emptyList();
    }

}
