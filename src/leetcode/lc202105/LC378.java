package leetcode.lc202105;

import java.util.PriorityQueue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/17
 */
public class LC378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                queue.offer(matrix[i][j]);
                if (queue.size() > k)
                    queue.poll();
            }
        }
        return queue.peek();
    }
}
