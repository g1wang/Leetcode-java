package leetcode.lc202105;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 *
 * stack
 * @author CodeX
 * @version 1.0
 * @date 2021/5/10
 */
public class LC739S2 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int idx=stack.pop();
                ans[idx] = i-idx;
            }
            stack.push(i);
        }
        return ans;
    }

}
