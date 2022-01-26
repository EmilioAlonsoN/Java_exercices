package MultiDimensionalArray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Integer[][] multiDArray = new Integer[][] {{1,1,1,0,0,0},
                                                    {0,1,0,0,0,0},
                                                    {1,1,1,0,0,0},
                                                    {0,0,2,4,4,0},
                                                    {0,0,0,2,0,0},
                                                    {0,0,1,2,4,0}};


        List<List<Integer>> arr = Arrays.stream(multiDArray).map(Arrays::asList).collect(Collectors.toList());
        hourglassSum(arr);
        
        int[][] matrix = new int[][] {{5,1,9,11},
                                      {2,4,8,10},
                                      {13,3,6,7},
                                      {15,14,12,16}};
        rotate(matrix);

        System.out.println(" ");
        
        int[][] unevenMatrix = new int[][] {{5,1,9},
                                            {2,4,8},
                                            {13,3,6},
                                            {15,14,12}};
        rotateCW(unevenMatrix);
    }

    static int row = 6;
    static int colum = 6;

    public static int hourglassSum(List<List<Integer>> arr) {

        //Print the matrix in console
        arr.forEach(System.out::println);

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < row - 2; i++) {

            for (int j = 0; j < colum - 2; j++) {

                //Search for max_value following the pattern
                //a b c
                //  d
                //e f g
                int sum = (arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2))
                                             + (arr.get(i + 1).get(j + 1)) +
                          (arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2));
                //System.out.println(sum);
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);
        return maxSum;
    }

    public static int[][] rotate(int[][] matrix) {

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        int n = matrix.length;
        // first rotation
        // with respect to main diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Second rotation
        // with respect to middle column
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
        System.out.println(" ");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        return matrix;
    }

    static int[][] rotateCW(int[][] mat) {
        
        for (int[] ints : mat) {
            System.out.println(Arrays.toString(ints));
        }
        int row = mat.length;
        int colum = mat[0].length;
        int[][] rotated = new int[colum][row];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                rotated[j][row-1-i] = mat[i][j];
            }
        }
        System.out.println(" ");
        for (int[] ints : rotated) {
            System.out.println(Arrays.toString(ints));
        }
        return rotated;
    }
}
