package leetcode.lc202105;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/25
 */
public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        int[] tbl = new int[128];
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            tbl[c]++;
            if (tbl[c] > 1) {
                do {
                    char lc = s.charAt(left);
                    tbl[lc]--;
                }
                while (s.charAt(left++) != c);
            } else max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
