package javase01.t03;

public class Task3 {
    public static double f(double x) {
        return Math.tan(2 * x) - 3;
    }

    public static void main(String[] args) {
        double a = -1;
        double b = 1;
        double h = 0.04;
        for (double x = a; x <= b; x += h) {
            System.out.printf("x=% f; \t F(x)=% f %n",x,f(x));
        }
    }
}
