package leetcode.lc202105;

/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC91 {

    int ans = 0;

    public int numDecodings(String s) {
        decoding(s, 0);
        return ans;
    }

    void decoding(String s, int idx) {
        if (idx < s.length() && s.charAt(idx) == '0') return;
        if (idx == s.length()) {
            ans++;
            return;
        }
        if (idx <= s.length() - 2) {
            int num = Integer.valueOf(s.substring(idx, idx + 2));
            if (0 < num && num <= 26) {
                decoding(s, idx + 2);
            }
        }
        decoding(s, idx + 1);
    }
}
