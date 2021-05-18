package leetcode.lc202105;

import java.util.*;

/**
 * 140. Word Break II
 * https://leetcode.com/problems/word-break-ii/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/18
 */
public class LC140 {

    public static void main(String[] args) {
        LC140 lc140 = new LC140();
        List<String> res = lc140.wordBreak("catsanddog", Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"}));
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        dfs(s, wordDict, ans, sb);
        return ans;

    }

    private void dfs(String s, List<String> wordDict, List<String> ans, StringBuffer sb) {
        if (s.length() == 0) {
            ans.add(sb.toString().trim());
            return;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.startsWith(word)) {
                dfs(s.substring(word.length()), wordDict, ans, new StringBuffer().append(sb).append(word).append(" "));
            }
        }
    }

}
