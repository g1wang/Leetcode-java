package leetcode.lc202105;

import java.util.*;

/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * queue+Array
 * @author CodeX
 * @version 1.0
 * @date 2021/5/11
 */
public class LC438 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        int[] seen = new int[26];
        int[] parr = new int[26];
        Deque<Character> queue = new LinkedList<>();
        for (char c : p.toCharArray()) parr[c-'a']++;
        int pLen = p.length();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            char c = ss[i];
            if (parr[c-'a'] != 0) {
                queue.push(c);
                seen[c-'a']++;
                if (seen[c-'a'] > parr[c-'a']) {
                    while (!queue.isEmpty()) {
                        char qc = queue.pollLast();
                        seen[qc-'a']--;
                        if (qc == c) break;
                    }
                } else if (queue.size() == pLen) {
                    ans.add(i - pLen + 1);
                    char qc = queue.pollLast();
                    seen[qc-'a']--;
                }
            } else if (!queue.isEmpty()) {
                queue.clear();
                seen = new int[26];
            }
        }
        return ans;

    }
}
