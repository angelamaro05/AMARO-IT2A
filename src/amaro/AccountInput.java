package amaro;

import java.util.Scanner;

public class AccountInput {
    int ID;
    String firstName;
    String lastName;
    String email;
    String username;
    String password;

    void captureAccountDetails(Scanner scanner) {
        System.out.print("Enter ID: ");
        ID = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Enter First Name: ");
        firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        lastName = scanner.nextLine();

        System.out.print("Enter Email: ");
        email = scanner.nextLine();

        System.out.print("Enter Username: ");
        username = scanner.nextLine();

        String enteredPassword;
        while (true) {
            System.out.print("Enter Password: ");
            enteredPassword = scanner.nextLine();
            if (passwordValidator(enteredPassword)) {
                password = enteredPassword;
                break;
            } else {
                System.out.println("Invalid password. Please try again.");
            }
        }

        while (true) {
            System.out.print("Re-enter Password for verification: ");
            String verifyPassword = scanner.nextLine();
            if (password.equals(verifyPassword)) {
                break;
            } else {
                System.out.println("Password verification failed. Please try again.");
            }
        }
    }

    boolean passwordValidator(String password) {
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else {
                hasSpecialChar = true;
            }
        }

        if (!hasUppercase) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        }

        if (!hasLowercase) {
            System.out.println("Password must contain at least one lowercase letter.");
            return false;
        }

        if (!hasNumber) {
            System.out.println("Password must contain at least one number.");
            return false;
        }

        if (!hasSpecialChar) {
            System.out.println("Password must contain at least one special character.");
            return false;
        }

        if (password.toLowerCase().contains("admin") || password.equalsIgnoreCase("password") || password.contains("1234")) {
            System.out.println("Password cannot be 'admin', 'password', or '1234'.");
            return false;
        }

        return true;
    }
}
