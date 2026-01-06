package phonemanagement;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public static void menuChinh() {
        int choice;
        do {
            System.out.println("\n-- CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI --");
            System.out.println("1. Xem danh sách điện thoại");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp theo giá");
            System.out.println("6. Tìm kiếm");
            System.out.println("7. Tính tổng tiền");
            System.out.println("8. Giảm giá cho điện thoại cũ");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> menuXem();
                case 2 -> menuThem();
                case 3 -> QuanLyDienThoai.capNhat();
                case 4 -> QuanLyDienThoai.xoa();
                case 9 -> System.out.println("Kết thúc chương trình!");
            }
        } while (choice != 9);
    }

    static void menuXem() {
        System.out.println("1. Xem tất cả");
        System.out.println("2. Xem điện thoại cũ");
        System.out.println("3. Xem điện thoại mới");
        System.out.println("4. Trở về");
        int c = sc.nextInt();
        if (c == 1) QuanLyDienThoai.xemTatCa();
        if (c == 2) QuanLyDienThoai.xemCu();
        if (c == 3) QuanLyDienThoai.xemMoi();
    }

    static void menuThem() {
        System.out.println("1. Thêm điện thoại cũ");
        System.out.println("2. Thêm điện thoại mới");
        System.out.println("3. Trở về");
        int c = sc.nextInt();
        if (c == 1) QuanLyDienThoai.themCu();
        if (c == 2) QuanLyDienThoai.themMoi();
    }
}
