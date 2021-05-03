package leetcode.lc202104;

import java.util.Deque;
import java.util.LinkedList;

public class LC0239S2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] ans = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {

            while (!queue.isEmpty()&&queue.peek()<i-k+1){
                queue.poll();
            }
            while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
            if (i-k+1>=0){
                ans[i-k+1]=nums[queue.peek()];
            }

        }
        return ans;

    }
}
