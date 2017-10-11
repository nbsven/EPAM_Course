package javase01.t02;

public class Task2 {
    public static void main(String[] args) {
        double a;
        double epsilon=0.01;
        for (int i=1;true;i++){
            a=1.0/Math.pow(i+1,2);
            System.out.println("a"+i+"="+a);
            if(a<epsilon){
                System.out.println(i);
                return;
            }
        }
    }
}
