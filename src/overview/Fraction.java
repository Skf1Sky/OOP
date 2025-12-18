package overview;

import java.util.Scanner;

public class Fraction {
    double numerator;
    double denominator;

     void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("input numerator ");
        numerator = Integer.parseInt(sc.nextLine());
        do {
            System.out.println("input denominator ");
            denominator=Integer.parseInt(sc.nextLine());
            if(denominator==0){
                System.out.println("denominator different 0 pls re-input");
            }
        }
        while (denominator==0);
    }
     void output(){
        System.out.printf("%d/%d",numerator,denominator);

    }

    Fraction sum(Fraction fr){
         Fraction sum= new Fraction();
         sum.numerator= numerator* fr.denominator + denominator* fr.numerator;
         sum.denominator = denominator* fr.denominator;
        return sum;
    }
    Fraction sub(Fraction fr){
        Fraction sub= new Fraction();
        sub.numerator= numerator* fr.denominator - denominator* fr.numerator;
        sub.denominator = denominator* fr.denominator;
        return sub;
    }
    Fraction mul(Fraction fr){
        Fraction mul= new Fraction();
        mul.numerator= numerator* fr.denominator;
        mul.denominator = denominator* fr.denominator;
        return mul;
    }
    Fraction devi(Fraction fr){
        Fraction devi= new Fraction();
        devi.numerator= numerator/ fr.denominator;
        devi.denominator = denominator/ fr.denominator;
        return devi;
    }


}
