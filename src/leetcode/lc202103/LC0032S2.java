package leetcode.lc202103;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/1 13:26
 */
public class LC0032S2 {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                //....()
                if (s.charAt(i - 1) == '(') {
                    if (i - 1 > 0) {
                        dp[i] = dp[i - 2] + 2;
                    } else dp[i] = 2;
                }else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    //.....))
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLen = Math.max(dp[i], maxLen);

            }
        }
        return maxLen;

    }
}
