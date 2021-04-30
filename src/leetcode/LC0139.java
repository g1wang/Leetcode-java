package leetcode;

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
    public static void main(String[] args) {
        String s = "asdf";
        s = s.substring("as".length());
        System.out.println(s);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        while (s.length() > 0) {
            boolean match = false;
            for (int i = 0; i < wordDict.size(); i++) {
                if (s.startsWith(wordDict.get(i))) {
                    s = s.substring(wordDict.get(i).length());
                    match =true;
                }
            }
            if (!match) return false;
        }
        return true;

    }
}
