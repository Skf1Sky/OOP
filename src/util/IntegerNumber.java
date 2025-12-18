package util;

public class IntegerNumber {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = (int) Math.sqrt(n); i > 1; i--) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPositiveNumber(int n) {
        return n > 0;
    }
}
