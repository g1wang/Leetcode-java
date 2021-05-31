package leetcode.lc202105;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/28
 */
public class LC20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        stack.push('1');
        for (char c : s.toCharArray()) {
            if (c==')'){
                if (stack.pop()!='(') return false;
            }else if (c==']'){
                if (stack.pop()!='[') return false;}
            else if (c=='}'){
                if (stack.pop()!='{') return false;
            }else stack.push(c);
        }
        return stack.pop()=='1';
    }
}
