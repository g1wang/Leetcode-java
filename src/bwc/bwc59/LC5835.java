package bwc.bwc59;
//TO-DO
public class LC5835 {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                if (j < matrix[0].length - 1) {
                    max = Math.max(max, -matrix[i][j] - matrix[i][j + 1]);
                }
                if (i < matrix.length - 1) {
                    max = Math.max(max, -matrix[i][j] - matrix[i + 1][j]);
                }
            }
        }
        return sum + 2 * max;
    }
}
