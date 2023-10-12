import java.util.*;
public class Test_prob11 extends Object {
    public static void main(String[] args) {
        Date d1 = new Date();
        Date d2 = new Date(349324);
        Date d3 = d1;
        System.out.println("(1) " + (d1 == d2));
        System.out.println("(2) " + (d1 == d3));
        System.out.println("(3) " + d1.equals(d2));
        System.out.println("(4) " + d1.equals(d3));
    }
}
