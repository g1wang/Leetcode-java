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
public class LC739S3 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        int[] stack = new int[T.length];
        int top=-1;
        for (int i = 0; i < T.length; i++) {
            while (top>-1&&T[i]>T[stack[top]]){
                int idx=stack[top--];
                ans[idx] = i-idx;
            }
            stack[++top]=i;
        }
        return ans;
    }

}
