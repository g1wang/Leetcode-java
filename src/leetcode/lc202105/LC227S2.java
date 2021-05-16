package leetcode.lc202105;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 227. Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/16
 */
public class LC227S2 {
    public int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;
    }
}
