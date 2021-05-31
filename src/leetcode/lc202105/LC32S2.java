package leetcode.lc202105;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/31
 */
public class LC32S2 {

    public static void main(String[] args) {
        LC32S2 lc324S2 = new LC32S2();
        lc324S2.longestValidParentheses(")()())");
    }
    public int longestValidParentheses(String s) {
        int[] counts = new int[s.length()];
        int maxCount = 0, count, idx;
        for (int i = 1; i < s.length(); i++) {
            count = 0;
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    count += 2 + counts[i - 1];
                } else if ((idx = i - counts[i - 1] - 1) >= 0 && s.charAt(idx) == '(')
                    count += 2 + counts[i - 1] + counts[idx];
                counts[i] = count;
            } else {
                if (s.charAt(i - 1) == ')')
                    counts[i] = counts[i - 1];
                else counts[i] = 0;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
