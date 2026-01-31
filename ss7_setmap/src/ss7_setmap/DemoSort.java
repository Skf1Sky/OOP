package ss7_setmap;

import ss3_abstract_interface.NewPhone;
import ss3_abstract_interface.OldPhone;
import ss3_abstract_interface.Phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoSort {
    public static void main(String[] args) {
        // 1. Tạo danh sách dữ liệu mẫu
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(new NewPhone("DT01", "Samsung S24", 25000, 12, "Samsung", 10));
        phoneList.add(new NewPhone("DT02", "IPhone 15", 30000, 12, "Apple", 5));
        phoneList.add(new OldPhone("DT03", "Nokia 1280", 500, 1, "Nokia", 90, "Cũ"));
        phoneList.add(new NewPhone("DT04", "Xiaomi Note", 8000, 12, "Xiaomi", 20));

        System.out.println("--- DANH SÁCH BAN ĐẦU ---");
        show(phoneList);

        // 2. Sắp xếp bằng Comparable (Theo Tên - Mặc định)
        Collections.sort(phoneList);
        System.out.println("\n--- SAU KHI SORT THEO TÊN (COMPARABLE) ---");
        show(phoneList);

        // 3. Sắp xếp bằng Comparator (Theo Giá - Tăng dần)
        Collections.sort(phoneList, new PriceComparator());
        System.out.println("\n--- SAU KHI SORT THEO GIÁ (COMPARATOR) ---");
        show(phoneList);

        // 4. Sắp xếp bằng Comparator (Theo Giá - Giảm dần - Dùng lambda cho nhanh)
        Collections.sort(phoneList, (p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
        System.out.println("\n--- SAU KHI SORT THEO GIÁ GIẢM DẦN (LAMBDA) ---");
        show(phoneList);
    }

    public static void show(List<Phone> list) {
        for (Phone p : list) {
            // In ngắn gọn Tên và Giá để dễ check
            System.out.printf("Tên: %-15s | Giá: %-10.0f\n", p.getName(), p.getPrice());
        }
    }
}