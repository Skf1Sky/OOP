package bai2;

public class Main {
    public static void main(String[] args) {
        double number1 = 15.0;
        double number2 = 4.0;

        System.out.println("Number 1: " + number1);
        System.out.println("Number 2: " + number2);

        System.out.println("Addition: " + MathUtil.add(number1, number2));
        System.out.println("Subtraction: " + MathUtil.subtract(number1, number2));
        System.out.println("Multiplication: " + MathUtil.multiply(number1, number2));
        System.out.println("Division: " + MathUtil.divide(number1, number2));

        System.out.println("Division by zero: " + MathUtil.divide(number1, 0));
    }
}
