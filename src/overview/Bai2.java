package overview;


public class Bai2 {
    public static void main(String[] args) {
        Fraction fr1 = new Fraction();
        Fraction fr2 = new Fraction();
        fr1.input();
        fr2.input();

        Fraction sum1 = fr1.sum(fr2);
        sum1.output();
        Fraction sub1 = fr1.sub(fr2);
        sub1.output();
        Fraction mul1 = fr1.mul(fr2);
        mul1.output();
        Fraction devi1 = fr1.devi(fr2);
        devi1.output();

    }
}
