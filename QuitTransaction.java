public class QuitTransaction implements Transaction {
    @Override
    public void execute(User user) {
        System.out.println("Quitting ATM. Goodbye!");
        System.exit(0);
    }
}
