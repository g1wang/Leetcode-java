package leetcode.lc202105;

/**
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/22
 */
public class LC392 {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean match = false;
            char sc = s.charAt(i);
            while (j < t.length()) {
                if (sc == t.charAt(j++)) {
                    match = true;
                    break;
                }
            }
            if (!match) return false;

        }
        return true;

    }
}
