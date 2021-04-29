package leetcode.lc100.lc0022_generate_parentheses;


/*
22. Generate Parentheses
Medium

7347

318

Add to List

Share
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
 */
/*
solution

 */

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/3/18 18:29
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int left = 0, right = 0;
        gen(result, right, left, "", n);
        return result;
    }

    private void gen(List<String> result, int right, int left, String s, int n) {

        if (2 * n == (left + right)) {
            result.add(s);
            return;
        }

        if (left < n) {
            gen(result, right, left + 1, s + '(', n);
        }
        if (left > right) {
            gen(result, right + 1, left, s + ')', n);
        }
    }


}
