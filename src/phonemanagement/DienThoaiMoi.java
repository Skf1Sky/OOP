package phonemanagement;

import java.util.Scanner;

public class DienThoaiMoi extends DienThoai {
    private int soLuong;

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tên: ");
        ten = sc.nextLine();
        System.out.print("Giá: ");
        gia = sc.nextDouble();
        System.out.print("Bảo hành: ");
        baoHanh = sc.nextInt();
        sc.nextLine();
        System.out.print("Hãng: ");
        hang = sc.nextLine();
        System.out.print("Số lượng: ");
        soLuong = sc.nextInt();
    }

    @Override
    public void output() {
        System.out.println(id + " | " + ten + " | " + gia + " | SL: " + soLuong + " | " + hang);
    }
}
