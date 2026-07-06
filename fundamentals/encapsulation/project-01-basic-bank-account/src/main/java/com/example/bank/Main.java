

public class Main {
    public static void main(String[] args) {
        // Create an account
        BankAccount acc = new BankAccount("1234567890", "Alice", 1000.0);
        System.out.println("Initial: " + acc);

        // Deposit
        acc.deposit(500);
        System.out.println("After deposit: " + acc);

        // Withdraw
        acc.withdraw(200);
        System.out.println("After withdrawal: " + acc);

        // Try invalid operations (they will throw exceptions)
        try {
            acc.withdraw(2000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error (expected): " + e.getMessage());
        }

        try {
            acc.deposit(-50);
        } catch (IllegalArgumentException e) {
            System.out.println("Error (expected): " + e.getMessage());
        }
    }
}