package leetcode.lc202105;

import java.util.*;

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int size = row * col;
        int i = 0, j = -1, startRow = 0, startCol = 0;
        while (list.size() < size) {
            while (j + 1 < col) {
                list.add(matrix[i][++j]);
            }
            startRow++;
            while (i + 1 < row) {
                list.add(matrix[++i][j]);
            }
            col--;
            while (list.size() < size && j - 1 >= startCol) {
                list.add(matrix[i][--j]);
            }
            row--;
            while (list.size() < size && i - 1 >= startRow) {
                list.add(matrix[--i][j]);
            }
            startCol++;
        }
        return list;
    }
}
