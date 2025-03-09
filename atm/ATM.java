package atm;

import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> handleWithdrawal();
                case 2 -> handleDeposit();
                case 3 -> System.out.println("Current Balance: " + getBalance());
                case 4 -> {
                    System.out.println("Thank you for using the ATM.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleWithdrawal() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        withdraw(amount);
    }

    private void handleDeposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        deposit(amount);
    }

    private double getBalance() {
        return account.getBalance();
    }

    private void withdraw(double amount) {
        account.withdraw(amount);
    }

    private void deposit(double amount) {
        account.deposit(amount);
    }
}
