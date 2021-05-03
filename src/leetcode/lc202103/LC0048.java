package leetcode.lc202103;

/**
 * Rotate Image
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/8 15:32
 */
public class LC0048 {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);

    }

    void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n/2 ; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }


}
