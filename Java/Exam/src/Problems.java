public class Problems {
    public static void main (String [] args) {
        double x = 76.0252175;
        int y = 100;

        int total = (int) (x * y) / y;
        System.out.println("Total: " + total);

        int result7 = problem7(3);

        System.out.println("Result 7: " + result7);

        int result9 = problem9();

        System.out.println("Result 9: " + result9);

        int number = 4;
        {

            boolean even;

            if (number % 2 == 0)
                even = true;
            else
                even = false;
        }
        {
            boolean even = (number % 2 == 0);
        }

        // Problem 12
//        Object o = new Object();
//        String d = (String)o;

    }
    public static int problem7 (int x) {
        int someX = x;

        int y = 0;
        switch (someX + 3) {
            case 6: y = 0;
            case 7: y = 1;
            default: y+= 1;
        }
        return y;
    }

    public static int problem9 () {
        int x = 0;
        int y = 101;

        int var = (int) (Math.random() * y + 1);

        return var;
    }



}



