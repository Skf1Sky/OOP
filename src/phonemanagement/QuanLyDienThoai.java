package phonemanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyDienThoai {
    static ArrayList<DienThoaiCu> dsCu = new ArrayList<>();
    static ArrayList<DienThoaiMoi> dsMoi = new ArrayList<>();
    static int demCu = 1;
    static int demMoi = 1;

    static {
        DienThoaiCu c1 = new DienThoaiCu();
        c1.id = "DTC001";
        dsCu.add(c1);

        DienThoaiMoi m1 = new DienThoaiMoi();
        m1.id = "DTM001";
        dsMoi.add(m1);
    }

    // XEM
    public static void xemTatCa() {
        dsCu.forEach(DienThoai::output);
        dsMoi.forEach(DienThoai::output);
    }

    public static void xemCu() {
        dsCu.forEach(DienThoai::output);
    }

    public static void xemMoi() {
        dsMoi.forEach(DienThoai::output);
    }

    // THÊM
    public static void themCu() {
        DienThoaiCu dt = new DienThoaiCu();
        dt.id = String.format("DTC%03d", demCu++);
        dt.input();
        dsCu.add(dt);
    }

    public static void themMoi() {
        DienThoaiMoi dt = new DienThoaiMoi();
        dt.id = String.format("DTM%03d", demMoi++);
        dt.input();
        dsMoi.add(dt);
    }

    // CẬP NHẬT
    public static void capNhat() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        if (id.startsWith("DTC")) {
            for (DienThoaiCu d : dsCu) {
                if (d.id.equals(id)) {
                    d.input();
                    System.out.println("Cập nhật thành công!");
                    return;
                }
            }
        } else if (id.startsWith("DTM")) {
            for (DienThoaiMoi d : dsMoi) {
                if (d.id.equals(id)) {
                    d.input();
                    System.out.println("Cập nhật thành công!");
                    return;
                }
            }
        }
        System.out.println("ID không tồn tại!");
    }

    // XÓA
    public static void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        if (id.startsWith("DTC")) {
            dsCu.removeIf(d -> d.id.equals(id));
            System.out.println("Đã xóa!");
            return;
        }
        if (id.startsWith("DTM")) {
            dsMoi.removeIf(d -> d.id.equals(id));
            System.out.println("Đã xóa!");
            return;
        }
        System.out.println("ID không hợp lệ!");
    }
}

