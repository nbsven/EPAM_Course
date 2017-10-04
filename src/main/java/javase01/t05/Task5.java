package javase01.t05;

public class Task5 {
    public static void main(String[] args) {
        int n=9;
        int[][] matrix=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j||(n-1-i==j)){
                    matrix[i][j]=1;
                }
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
