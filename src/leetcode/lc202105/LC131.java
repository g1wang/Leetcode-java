package leetcode.lc202105;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/21
 */
public class LC131 {
    public List<List<String>> partition(String s) {
        //idx,len
        List<List<String>> ans = new ArrayList<>();
        //1:isPalindrome 2: not
        //memo0:idx,1 len
        int[][] memo = new int[s.length()][s.length() + 1];
        dfs(s, 0, new ArrayList<>(), memo, ans);
        return ans;
    }

    private void dfs(String s, int idx, List<String> list, int[][] memo, List<List<String>> ans) {

        if (s.isEmpty()) ans.add(new ArrayList<>(list));
        for (int i = 1; i <= s.length(); i++) {
            if (memo[idx][i] == 2) continue;
            String str = s.substring(0, i);
            if (memo[idx][i] == 1 || isPalindrome(str)) {
                list.add(str);
                memo[idx][i] = 1;
                dfs(s.substring(i), idx + i, list, memo, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
