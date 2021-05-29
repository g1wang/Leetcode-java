package leetcode.lc_re1_202106;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/29
 */

/*public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gen(n, n, new StringBuffer(), ans);
        return ans;
        }

private void gen(int l, int r, StringBuffer stringBuffer, List<String> ans) {
        if (l < 0 || l > r) return;
        if (r == 0) {
        ans.add(stringBuffer.toString());
        return;
        }
        stringBuffer.append('(');
        gen(l - 1, r, stringBuffer, ans);
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(')');
        gen(l, r-1, stringBuffer, ans);
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }*/
public class LC22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gen(n, n, new StringBuffer(), ans);
        return ans;
    }

    private void gen(int l, int r, StringBuffer stringBuffer, List<String> ans) {
        if (r == 0) {
            ans.add(stringBuffer.toString());
            return;
        }
        if (l > 0 && l <= r) {
            stringBuffer.append('(');
            gen(l - 1, r, stringBuffer, ans);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        if (r > l) {
            stringBuffer.append(')');
            gen(l, r - 1, stringBuffer, ans);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }

}
