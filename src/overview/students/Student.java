package overview.students;

import java.util.Scanner;

public class Student {
    String name;
    double scoreMath;
    double scoreLei;
    double scoreEng;


    int id;



    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ten");
        name = sc.nextLine();
        System.out.println("nhap vao diem toan");
        scoreMath = Double.parseDouble(sc.nextLine());
        System.out.println("nhap vao diem van");
        scoreLei = Double.parseDouble(sc.nextLine());
        System.out.println("nhap vao diem anh");
        scoreEng = Double.parseDouble(sc.nextLine());

    }

    void output() {
        System.out.println(name);
        System.out.println(calculateAverageScore());
    }

    double calculateAverageScore(   ) {
        System.out.println("DIEM TRUNG BINH");
        double average = (scoreEng + scoreMath + scoreLei) / 3;
        return average;
    }
}
