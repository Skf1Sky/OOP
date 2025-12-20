package overview.point;

import java.util.Scanner;

public class Point {
    public double x;
    public double y;

    public void inputCoordinates(String pointName) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coordinates for point " + pointName + ":");
        System.out.print("Input x: ");
        this.x = sc.nextDouble();
        System.out.print("Input y: ");
        this.y = sc.nextDouble();
    }


    public void display() {
        System.out.printf("(%.2f, %.2f)", this.x, this.y);
    }


    public double calculateDistance(Point otherPoint) {
        double dx = this.x - otherPoint.x;
        double dy = this.y - otherPoint.y;


        return Math.sqrt(dx * dx + dy * dy);
    }
}
