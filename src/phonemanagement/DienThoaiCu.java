package phonemanagement;
import java.util.Scanner;

public class DienThoaiCu extends DienThoai {
    private int pin;
    private String moTa;

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
        System.out.print("Pin (%): ");
        pin = sc.nextInt();
        sc.nextLine();
        System.out.print("Mô tả: ");
        moTa = sc.nextLine();
    }

    @Override
    public void output() {
        System.out.println(id + " | " + ten + " | " + gia + " | " + pin + "% | " + hang);
    }
}

