package leetcode.lc0020_valid_parentheses;

import java.util.*;

/*
20. Valid Parentheses
Easy

7024

292

Add to List

Share
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

/*
solution deque
 */
public class Solution {
    public boolean isValid(String s) {
        String leftStr = "([{";
        String rightStr = ")]}";
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (leftStr.indexOf(c) != -1) {
                queue.push(c);
            } else if (queue.isEmpty() || rightStr.indexOf(c) != leftStr.indexOf(queue.pop())) {
                return false;
            }
        }
        if (queue.isEmpty())
            return true;
        else return false;
    }
}
