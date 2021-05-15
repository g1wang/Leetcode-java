package leetcode.lc202105;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/15
 */
public class LC150 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                int n = stack.pop();
                stack.push(stack.pop() - n);
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int n = stack.pop();
                stack.push(stack.pop() / n);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
