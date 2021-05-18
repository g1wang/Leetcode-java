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
public class LC140S2 {

    public static void main(String[] args) {
        LC140S2 lc140 = new LC140S2();
        List<String> res = lc140.wordBreak("catsanddog", Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"}));
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String s1 : wordDict) {
            wordSet.add(s1);
        }
        Map<String, List<String>> dp = new HashMap<>();
        return dfs(dp, s, wordDict);

    }

    private List<String> dfs(Map<String, List<String>> dp, String s, List<String> wordDict) {

        if (s.length() == 0) {
            List list = new ArrayList();
            list.add("");
            return list;
        }
        if (dp.containsKey(s)) return dp.get(s);
        List list = new ArrayList();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subSet = dfs(dp, s.substring(word.length()), wordDict);
                StringBuffer sb = new StringBuffer();
                for (String s1 : subSet) {
                    sb.append(word);
                    if (!s1.isEmpty()){
                        sb.append(" ").append(s1);
                    }
                    list.add(sb.toString());
                    sb = new StringBuffer();
                }
            }
        }
        dp.put(s, list);
        return list;
    }

}
