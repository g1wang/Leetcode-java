package leetcode.lc200;

import java.util.HashSet;
import java.util.List;

/**
 * 139. Word Break
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30
 */
public class LC0139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] match = new boolean[s.length()+1];
        match[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (match[j]&&wordDict.contains(s.substring(j,i))){
                    match[i] = true;
                    break;
                }
            }
        }
        return match[s.length()];
    }
}
