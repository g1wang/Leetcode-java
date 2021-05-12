package leetcode.lc202105;

import java.util.HashSet;

/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC73 {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> seenRow = new HashSet();
        HashSet<Integer> seenCol = new HashSet();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j]==0){
                    seenRow.add(i);
                    seenCol.add(j);
                }
            }
        }
        for (Integer r : seenRow) {
            for (int i = 0; i < col; i++) {
                matrix[r][i]=0;
            }
        }
        for (Integer c : seenCol) {
            for (int i = 0; i < row; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
