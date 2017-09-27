package javase01.t04;

import java.util.Random;


public class Task4 {

    public static void main(String[] args) {

        Random rnd = new Random();
        int n = rnd.nextInt(1000);
        System.out.println("n="+n);
        double[] array = new double[2 * n];

        for (int i = 0; i < array.length; i++) {
            array[i] = (0.5 - rnd.nextDouble()) * rnd.nextInt(2_000_000);
            System.out.print(array[i]+" ");
        }

        System.out.println();

        double maximum=array[0]+array[array.length-1];
        for (int i=1;i<n;i++){
            double tmp=array[i]+array[array.length-1-i];
            if(tmp>maximum){
                maximum=tmp;
            }
        }
        System.out.println("maximum="+maximum);


    }
}
