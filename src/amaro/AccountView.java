package amaro;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountView {
    ArrayList<AccountInput> accountList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    void addAccount() {
        while (true) {
            AccountInput account = new AccountInput();
            account.captureAccountDetails(scanner);

            if (isDuplicate(account)) {
                System.out.println("Account registration failed! Duplicate entry detected.");
            } else {
                accountList.add(account);
                System.out.println("Account registered successfully!");
                break;
            }

            System.out.println("Would you like to try again? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                System.out.println("Account registration aborted.");
                break;
            }
        }
    }

    boolean isDuplicate(AccountInput account) {
        for (AccountInput acc : accountList) {
            if (acc.ID == account.ID ||
                acc.firstName.equalsIgnoreCase(account.firstName) &&
                acc.lastName.equalsIgnoreCase(account.lastName) &&
                acc.email.equalsIgnoreCase(account.email)) {
                return true;
            }
        }
        return false;
    }

    void viewAccounts() {
        if (accountList.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            System.out.printf("%-5s %-15s %-15s %-25s %-15s%n", "ID", "First Name", "Last Name", "Email", "Username");
            System.out.println("-----------------------------------------------------------------------");

            for (AccountInput account : accountList) {
                System.out.printf("%-5d %-15s %-15s %-25s %-15s%n",
                        account.ID, account.firstName, account.lastName, account.email, account.username);
            }
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    void checkUserInput(AccountInput input) {
        boolean found = false;
        for (AccountInput acc : accountList) {
            if (acc.ID == input.ID &&
                acc.firstName.equalsIgnoreCase(input.firstName) &&
                acc.lastName.equalsIgnoreCase(input.lastName) &&
                acc.email.equalsIgnoreCase(input.email)) {
                System.out.println("Matching account found!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No matching account found based on ID, first name, last name, and email.");
        }
    }
}
