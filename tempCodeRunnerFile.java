import java.util.Scanner;

public class ATMApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter user ID: ");
        String enteredUserId = sc.nextLine();
        System.out.println("Enter PIN: ");
        String enteredPin = sc.nextLine();

        ATM atm = new ATM("user01", "1234");

        if (atm.authenticate(enteredUserId, enteredPin)) {
            System.out.println("Authentication Successful. Welcome to ATM.");

            atm.showMenu();

            User user = null;

            while (true) {
                System.out.println("Enter your choice (1-5): ");
                int choice = sc.nextInt();
                sc.nextLine();

                Transaction trans = atm.getTransaction(choice);

                if (trans != null) {
                    if (user == null) {
                        user = new User("user01", "1234", choice);
                    }
                    trans.execute(user);
                    atm.logTransaction("Transaction: " + trans.getClass().getSimpleName());
                }
            }
        } else {
            System.out.println("Authentication Failed. Exiting...");
        }

    }

}
