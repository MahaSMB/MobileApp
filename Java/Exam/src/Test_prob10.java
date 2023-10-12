public class Test_prob10 {
    public static void main (String[] args) {
        int i = 1;
        while (i <= 6) {
            method1 (1, 2);
            i++;
        }
    }

    public static void method1( int i, int num) {
        for (int j = 1; j <= i; j++) {
            System.out.println(num + " ");
            num *= 2;
        }
        System.out.println();
    }
}
