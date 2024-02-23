package Progress_5_Java_Part_1;

import java.util.*;

public class BankingSystem {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Create a new Savings Account");
            System.out.println("2. Create a new Current Account");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Display account details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createSavingsAccount();
                    break;
                case 2:
                    createCurrentAccount();
                    break;
                case 3:
                    performDeposit();
                    break;
                case 4:
                    performWithdrawal();
                    break;
                case 5:
                    displayAccountDetails();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        System.out.println("Thank you for using our Banking System.");
    }

    private static void createSavingsAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.next();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Enter interest rate: ");
        double interestRate = sc.nextDouble();
        SavingsAccount newAccount = new SavingsAccount(accountNumber, balance, interestRate);
        accounts.add(newAccount);
        System.out.println("Savings account created successfully.");
    }

    private static void createCurrentAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.next();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Enter overdraft limit: ");
        double overdraftLimit = sc.nextDouble();
        CurrentAccount newAccount = new CurrentAccount(accountNumber, balance, overdraftLimit);
        accounts.add(newAccount);
        System.out.println("Current account created successfully.");
    }

    private static void performDeposit() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.next();
        System.out.print("Enter deposit amount: ");
        double amount = sc.nextDouble();
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.deposit(amount);
                System.out.println("Amount deposited successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void performWithdrawal() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.next();
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.withdraw(amount);
                System.out.println("Withdrawal successful.");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void displayAccountDetails() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.next();
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.displayAccountDetails();
                return;
            }
        }
        System.out.println("Account not found.");
    }
}
