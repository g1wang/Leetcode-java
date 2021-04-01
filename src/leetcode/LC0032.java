package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/1 15:55
 */
public class LC0032 {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }


}
