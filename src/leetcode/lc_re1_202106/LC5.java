package leetcode.lc_re1_202106;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/26
 */
public class LC5 {
    public String longestPalindrome(String s) {
        char[] sc = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                int left = j, right = len - i + j - 1;
                boolean match = true;
                while (left < right) {
                    if (sc[left++] != sc[right--]) {
                        match = false;
                        break;
                    }
                }
                if (match) return s.substring(j, len - i + j);
            }
        }
        return null;
    }


}
