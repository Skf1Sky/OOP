package overview.point;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();

        p1.inputCoordinates("A");
        p2.inputCoordinates("B");


        System.out.print("Point A: ");
        p1.display();
        System.out.print("\nPoint B: ");
        p2.display();


        double distance = p1.calculateDistance(p2);

        System.out.println("\n---------------------------");
        System.out.printf("Distance between A and B: %.4f\n", distance);
    }
}

