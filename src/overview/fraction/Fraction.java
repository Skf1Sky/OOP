package overview.fraction;

import java.util.Scanner;

public class Fraction {
    // Nên dùng int cho phân số
    private int numerator;   // Tử số
    private int denominator; // Mẫu số

    // Constructor mặc định
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    // Constructor có tham số
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            System.out.println("Lỗi: Mẫu số không thể bằng 0. Đặt mặc định là 1.");
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
        simplify(); // Rút gọn ngay khi khởi tạo
    }

    // a.i: Method nhập (Không cho nhập mẫu = 0)
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tử số: ");
        // Xử lý trôi lệnh hoặc nhập liệu sai nếu cần, ở đây giả sử nhập đúng số
        this.numerator = sc.nextInt();

        do {
            System.out.print("Nhập mẫu số: ");
            this.denominator = sc.nextInt();
            if (this.denominator == 0) {
                System.out.println("Mẫu số phải khác 0. Vui lòng nhập lại!");
            }
        } while (this.denominator == 0);

        simplify(); // Rút gọn ngay sau khi nhập xong
    }

    // Hàm tìm Ước chung lớn nhất (UCLN) để rút gọn
    private int findGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Hàm rút gọn phân số và xử lý dấu
    public void simplify() {
        int gcd = findGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        // Đưa dấu trừ lên tử số nếu mẫu số âm
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // a.ii: Method xuất dạng rút gọn
    public void output() {
        if (denominator == 1) {
            System.out.println(numerator); // Ví dụ: 4/1 in ra 4
        } else if (numerator == 0) {
            System.out.println(0);         // Ví dụ: 0/5 in ra 0
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }

    // b. Các phép tính (Trả về đối tượng Fraction mới)

    // Cộng: a/b + c/d = (ad + bc) / bd
    public Fraction sum(Fraction fr) {
        int newNum = this.numerator * fr.denominator + this.denominator * fr.numerator;
        int newDen = this.denominator * fr.denominator;
        return new Fraction(newNum, newDen);
    }

    // Trừ: a/b - c/d = (ad - bc) / bd
    public Fraction sub(Fraction fr) {
        int newNum = this.numerator * fr.denominator - this.denominator * fr.numerator;
        int newDen = this.denominator * fr.denominator;
        return new Fraction(newNum, newDen);
    }

    // Nhân: a/b * c/d = (ac) / (bd)
    public Fraction mul(Fraction fr) {
        int newNum = this.numerator * fr.numerator;
        int newDen = this.denominator * fr.denominator;
        return new Fraction(newNum, newDen);
    }

    // Chia: a/b : c/d = (ad) / (bc)
    public Fraction devi(Fraction fr) {
        if (fr.numerator == 0) {
            System.out.println("Không thể chia cho 0. Trả về 0.");
            return new Fraction(0, 1);
        }
        int newNum = this.numerator * fr.denominator;
        int newDen = this.denominator * fr.numerator;
        return new Fraction(newNum, newDen);
    }

    // c. Kiểm tra âm dương
    public void checkSign() {
        if (numerator == 0) {
            System.out.println("Phân số bằng 0.");
        } else if (numerator > 0) { // Vì mẫu luôn dương sau khi simplify
            System.out.println("Đây là phân số DƯƠNG.");
        } else {
            System.out.println("Đây là phân số ÂM.");
        }
    }
}