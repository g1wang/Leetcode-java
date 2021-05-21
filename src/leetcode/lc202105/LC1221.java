package leetcode.lc202105;

/**
 * 1221. Split a String in Balanced Strings
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/22
 */
public class LC1221 {
    public int balancedStringSplit(String s) {
        int balance = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') balance++;
            else balance--;
            if (balance == 0) count++;
        }
        return count;

    }
}
