public class Quit implements Transaction {
    public void execute(User user) {
        System.out.println("Quitting ATM. Goodbye!");
        System.exit(0);
    }
}
