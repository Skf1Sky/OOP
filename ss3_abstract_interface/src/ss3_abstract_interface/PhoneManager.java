package ss3_abstract_interface;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneManager {
    static ArrayList<Phone> phoneList = new ArrayList<>();

    static {
        // Dữ liệu mẫu test giảm giá
        // NewPhone số lượng 10 (>5) -> Được giảm giá
        phoneList.add(new NewPhone("DTM1", "iPhone 15", 30000, 12, "Apple", 10));
        // OldPhone pin 70% (<80%) -> Được giảm giá
        phoneList.add(new OldPhone("DTC1", "Note 10", 5000, 3, "SS", 70, "Vỡ"));
    }

    public static void main(String[] args) {
        // Test hiển thị và tính toán
        System.out.println("--- DANH SÁCH & KHUYẾN MÃI ---");

        for (Phone p : phoneList) {
            // 1. Gọi hàm abstract hiển thị
            p.hienThiThongTin();

            // 2. Tính giảm giá
            // Vì cả NewPhone và OldPhone đều implements IDiscount, ta ép kiểu để gọi hàm
            if (p instanceof IDiscount) {
                // Ép kiểu p về IDiscount để dùng hàm tinhGiamGia()
                IDiscount sanPhamKhuyenMai = (IDiscount) p;
                double tienGiam = sanPhamKhuyenMai.tinhGiamGia();
                double thanhTien = p.getPrice() - tienGiam;

                System.out.printf("   => Giá gốc: %.0f | Giảm: %.0f | CÒN LẠI: %.0f\n",
                        p.getPrice(), tienGiam, thanhTien);
            }
            System.out.println("-------------------------------------------------");
        }
    }
}