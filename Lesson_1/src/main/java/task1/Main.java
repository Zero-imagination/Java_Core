package task1;

public class Main {
    public static int a = 7;
    public static int c = 977;
    public static int m = 997;
    public static int seed = (int)(System.currentTimeMillis() % 10000L);
    public static int matrixSize = 7;

    public static void main(String[] args){
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i< matrixSize; i++){
            for(int j=0; j<matrixSize; j++){
                matrix[i][j]=getRand();
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("=>");
        System.out.println("Max = "+getMax(matrix));
        System.out.println("Min = "+getMin(matrix));
        System.out.println("Avg = "+getAverage(matrix));
    }
    public static int getRand() {
        seed = (a * seed + c) % m;
        return seed;
    }
    public static int getMax(int[][] matrix){
        int max=0;
        for (int[] ints : matrix)
            for (int i = 0; i < matrix.length; i++)
                if (ints[i] > max) max = ints[i];
        return max;
    }
    public static int getMin(int[][] matrix){
        int min=matrix[0][0];
        for (int[] ints : matrix)
            for (int i = 0; i < matrix.length; i++)
                if (ints[i] < min) min = ints[i];
        return min;
    }
    public static double getAverage(int[][] matrix){
        double sum=0;
        int count=0;
        for (int[] ints : matrix)
            for (int i = 0; i < matrix.length; i++){
                sum+=ints[i];
                count++;
            }
        return sum/count;
    }
}
