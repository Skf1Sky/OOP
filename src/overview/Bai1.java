package overview;

import overview.students.Student;
import util.Input;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Input.inputGreatThan("n", 0);
        ArrayList<Student> students = new ArrayList<>(n);
        System.out.println("NHẬP THÔNG TIN");
        for (int i = 1; i <= n; i++) {
            System.out.printf("Nhap vao sinh vien thu %d",i);
            Student student = new Student();
            student.input();
            students.add(student);
        }
        System.out.printf("XUAT THONG TIN ");
        for (int i=1;i<=n;i++){
            students.get(i-1).output();
        }

    }
}

