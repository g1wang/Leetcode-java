package leetcode.lc202104;

/*
215. Kth Largest Element in an Array
https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class LC0215 {
    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i <nums.length ; i++) {
            if (i<k){
                queue.offer(nums[i]);
            }else {
                if (nums[i]>queue.peek()){
                    queue.offer(nums[i]);
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }
}
