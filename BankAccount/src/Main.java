import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        BankAccount account = new BankAccount(0);
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("---------------");
            System.out.println("BANKING PROGRAM");
            System.out.println("---------------");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("---------------");

            System.out.println("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1 -> System.out.printf("Balance: $%.2f%n", account.getBalance());
                case 2 -> {
                    System.out.println("Enter amount to be deposit: ");
                    double amount = scanner.nextDouble();
                    try {
                        account.deposit(amount);
                        System.out.printf("Deposit successful! New balance: $%.2f%n", account.getBalance());
                    } catch (AssertionError e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    try {
                        account.withdraw(amount);
                        System.out.printf("Withdrawal successful! New balance: $%.2f%n", account.getBalance());
                    } catch (AssertionError e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 4 -> isRunning = false;
                default -> System.out.println("INVALID CHOICE");
            }
        }

        System.out.println("---------------------------");
        System.out.println("Thank you! Have a nice day!");
        System.out.println("---------------------------");

        scanner.close();
    }
}