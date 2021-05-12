package leetcode.lc202105;

/**
 * 171. Excel Sheet Column Number
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/13
 */
public class LC171 {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++)
            ans = ans * 26 + columnTitle.charAt(i) - 'A' + 1;
        return ans;
    }
}
