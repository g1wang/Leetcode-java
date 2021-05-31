package leetcode.lc202105;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/31
 */
public class LC32 {
    public int longestValidParentheses(String s) {
        Deque<Integer> countStack = new LinkedList<>();
        int maxCount = 0, count = 0, open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                countStack.push(count);
                count = 0;
                open++;
            } else {
                if (open > 0) {
                    open--;
                    count += 2 + countStack.pop();
                    maxCount = Math.max(maxCount, count);
                } else {
                    countStack.clear();
                    count = 0;
                }
            }
        }
        return maxCount;

    }
}
