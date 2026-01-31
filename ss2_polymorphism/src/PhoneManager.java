package ss2_polymorphism; // Tên package của buổi 2

// QUAN TRỌNG: Import các class từ thư mục buổi 1
import ss1_inther.Phone;
import ss1_inther.NewPhone;
import ss1_inther.OldPhone;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneManager {
    // Sử dụng 1 List duy nhất chứa class cha (Phone)
    static ArrayList<Phone> phoneList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Biến đếm ID tự động
    static int newCount = 1;
    static int oldCount = 1;

    // Static block: Tạo dữ liệu giả định để test luôn không cần nhập lại
    static {
        // Dùng constructor của ss1_inther
        phoneList.add(new NewPhone("NPH" + newCount++, "iPhone 15", 1200, 12, "Apple", 10));
        phoneList.add(new NewPhone("NPH" + newCount++, "Samsung S24", 1000, 12, "Samsung", 5));

        phoneList.add(new OldPhone("OPH" + oldCount++, "iPhone 11", 400, 3, "Apple", 85, "Scratched"));
        phoneList.add(new OldPhone("OPH" + oldCount++, "Note 10", 300, 1, "Samsung", 80, "No pen"));
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- PHONE MANAGER (SESSION 2) ---");
            System.out.println("1. View All Phones");
            System.out.println("2. Add New Phone");
            System.out.println("5. Sort by Price (Interchange Sort)"); // Chức năng mới
            System.out.println("6. Search (Type, Price, Name)");       // Chức năng mới
            System.out.println("9. Exit");
            System.out.print("Choose: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: viewAllPhones(); break;
                    case 2: addNewPhone(); break;
                    case 5: sortPhones(); break;
                    case 6: searchPhones(); break;
                    case 9: return;
                    default: System.out.println("Invalid option!");
                }
            } catch (Exception e) {
                System.out.println("Error: Input number only.");
            }
        }
    }

    // --- 1. VIEW LIST ---
    public static void viewAllPhones() {
        System.out.println("\n--- LIST OF PHONES ---");
        if (phoneList.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            for (Phone p : phoneList) {
                // Tự động gọi hàm toString() bên ss1_inther
                System.out.println(p.toString());
            }
        }
    }

    // --- 2. ADD NEW ---
    public static void addNewPhone() {
        System.out.println("1. Add Old Phone | 2. Add New Phone");
        System.out.print("Select: ");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Price: "); double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Warranty: "); int warranty = Integer.parseInt(scanner.nextLine());
        System.out.print("Manufacturer: "); String manu = scanner.nextLine();

        if (type == 1) {
            System.out.print("Battery (%): "); int bat = Integer.parseInt(scanner.nextLine());
            System.out.print("Description: "); String desc = scanner.nextLine();
            // Gọi Class từ ss1_inther
            phoneList.add(new OldPhone("OPH" + oldCount++, name, price, warranty, manu, bat, desc));
        } else {
            System.out.print("Quantity: "); int qty = Integer.parseInt(scanner.nextLine());
            // Gọi Class từ ss1_inther
            phoneList.add(new NewPhone("NPH" + newCount++, name, price, warranty, manu, qty));
        }
        System.out.println("Added successfully!");
    }

    // --- 5. SORT BY PRICE (Interchange Sort) ---
    public static void sortPhones() {
        System.out.println("\n--- SORT BY PRICE ---");
        System.out.println("1. Ascending (Low -> High)");
        System.out.println("2. Descending (High -> Low)");
        System.out.print("Select: ");
        int type = Integer.parseInt(scanner.nextLine());

        // Thuật toán Interchange Sort: Duyệt 2 vòng lặp
        for (int i = 0; i < phoneList.size() - 1; i++) {
            for (int j = i + 1; j < phoneList.size(); j++) {
                Phone p1 = phoneList.get(i);
                Phone p2 = phoneList.get(j);

                boolean swap = false;
                // Lưu ý: Dùng getter p1.getPrice() vì thuộc tính thường là protected/private
                if (type == 1) { // Tăng dần
                    if (p1.getPrice() > p2.getPrice()) swap = true;
                } else { // Giảm dần
                    if (p1.getPrice() < p2.getPrice()) swap = true;
                }

                if (swap) {
                    phoneList.set(i, p2);
                    phoneList.set(j, p1);
                }
            }
        }
        System.out.println("Sorted! Please use 'View All Phones' to check.");
    }

    // --- 6. SEARCH (Instanceof, Price, Name) ---
    public static void searchPhones() {
        while (true) {
            System.out.println("\n--- SEARCH MENU ---");
            System.out.println("1. Search by Type (Old/New)");
            System.out.println("2. Search by Price Range");
            System.out.println("3. Search by Name");
            System.out.println("4. Back");
            System.out.print("Select: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 4) break;

            switch (choice) {
                case 1: // Tìm theo loại: Dùng INSTANCEOF để kiểm tra class gốc
                    System.out.print("Type (1. New Phone | 2. Old Phone): ");
                    int type = Integer.parseInt(scanner.nextLine());
                    System.out.println("--- RESULT ---");
                    for (Phone p : phoneList) {
                        // Kiểm tra p có phải được tạo từ khuôn NewPhone hay không
                        if (type == 1 && p instanceof NewPhone) {
                            System.out.println(p);
                        }
                        // Kiểm tra p có phải được tạo từ khuôn OldPhone hay không
                        else if (type == 2 && p instanceof OldPhone) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 2: // Tìm theo khoảng giá
                    System.out.print("Min Price: "); double min = Double.parseDouble(scanner.nextLine());
                    System.out.print("Max Price: "); double max = Double.parseDouble(scanner.nextLine());
                    System.out.println("--- RESULT ---");
                    for (Phone p : phoneList) {
                        if (p.getPrice() >= min && p.getPrice() <= max) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 3: // Tìm theo tên
                    System.out.print("Enter name to search: ");
                    String keyword = scanner.nextLine().toLowerCase();
                    System.out.println("--- RESULT ---");
                    for (Phone p : phoneList) {
                        if (p.getName().toLowerCase().contains(keyword)) {
                            System.out.println(p);
                        }
                    }
                    break;
            }
        }
    }
}