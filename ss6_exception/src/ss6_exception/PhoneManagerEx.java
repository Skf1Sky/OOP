package ss6_exception;

import ss3_abstract_interface.NewPhone;
import ss3_abstract_interface.OldPhone;
import ss3_abstract_interface.Phone;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneManagerEx {
    static ArrayList<Phone> phoneList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- PHONE MANAGEMENT SYSTEM ---");
            System.out.println("1. Add New Phone");
            System.out.println("2. Add Old Phone");
            System.out.println("3. Show List");
            System.out.println("4. Exit");
            System.out.print("Choose function: ");

            try {
                String choiceStr = scanner.nextLine();
                if (choiceStr.trim().isEmpty()) throw new EmptyFieldException("Selection cannot be empty!");
                int choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1:
                        addNewPhone();
                        break;
                    case 2:
                        addOldPhone();
                        break;
                    case 3:
                        showList();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Please choose between 1-4!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Input must be a number!");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    public static String inputString(String fieldName) throws EmptyFieldException {
        System.out.print("Enter " + fieldName + ": ");
        String input = scanner.nextLine();
        if (input.trim().isEmpty()) {
            throw new EmptyFieldException(fieldName + " cannot be empty!");
        }
        return input;
    }

    public static double inputPositiveNumber(String fieldName) throws EmptyFieldException, NegativeNumberException, NumberFormatException {
        System.out.print("Enter " + fieldName + ": ");
        String input = scanner.nextLine();

        if (input.trim().isEmpty()) throw new EmptyFieldException(fieldName + " cannot be empty!");

        double number = Double.parseDouble(input);

        if (number < 0) {
            throw new NegativeNumberException(fieldName + " must be a positive number!");
        }
        return number;
    }

    public static void addNewPhone() {
        try {
            System.out.println("--- ADD NEW PHONE ---");
            String id = inputString("Product ID");
            String name = inputString("Phone Name");
            String manufact = inputString("Manufacturer");

            double price = inputPositiveNumber("Price");
            int warranty = (int) inputPositiveNumber("Warranty (months)");
            int quantity = (int) inputPositiveNumber("Stock Quantity");

            NewPhone newPhone = new NewPhone(id, name, price, warranty, manufact, quantity);
            phoneList.add(newPhone);
            System.out.println("=> Added successfully!");

        } catch (EmptyFieldException | NegativeNumberException | NumberFormatException e) {
            System.err.println("INPUT ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("The application encountered an unexpected error, please try again.");
        }
    }

    public static void addOldPhone() {
        try {
            System.out.println("--- ADD OLD PHONE ---");
            String id = inputString("Product ID");
            String name = inputString("Phone Name");
            String manufact = inputString("Manufacturer");
            double price = inputPositiveNumber("Price");
            int warranty = (int) inputPositiveNumber("Warranty (months)");

            System.out.print("Enter Battery % (0-100): ");
            String batStr = scanner.nextLine();
            if (batStr.trim().isEmpty()) throw new EmptyFieldException("Battery cannot be empty");
            int battery = Integer.parseInt(batStr);

            if (battery < 0 || battery > 100) {
                throw new NumberOutOfRangeException("Battery must be between 0% - 100%!");
            }

            System.out.print("Enter Condition Description: ");
            String desc = scanner.nextLine();
            if (desc.trim().isEmpty()) throw new EmptyFieldException("Description cannot be empty");
            if (desc.length() < 10) {
                throw new MinLengthException("Description is too short! Must be at least 10 characters.");
            }

            OldPhone oldPhone = new OldPhone(id, name, price, warranty, manufact, battery, desc);
            phoneList.add(oldPhone);
            System.out.println("=> Added successfully!");

        } catch (EmptyFieldException | NegativeNumberException | NumberOutOfRangeException | MinLengthException | NumberFormatException e) {
            System.err.println("INPUT ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("The application encountered an unexpected error, please try again.");
        }
    }

    public static void showList() {
        if (phoneList.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        for (Phone p : phoneList) {
            p.hienThiThongTin();
        }
    }
}