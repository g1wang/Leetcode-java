package leetcode.lc202105;

import java.util.*;

/**
 * 127. Word Ladder
 * https://leetcode.com/problems/word-ladder/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/17
 */
public class LC127 {
    public static void main(String[] args) {
        LC127 lc127 = new LC127();
        int ans = lc127.ladderLength("hit"
                , "cog"
                , Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(ans);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String s : wordList) {
            wordSet.add(s);
        }
        if (!wordSet.contains(endWord)) return 0;
        wordSet.remove(beginWord);
        int count = 1;
        Deque<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.pop();
                for (int j = 0; j < s.length(); j++) {
                    char[] sc = s.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        sc[j] = c;
                        String tmpStr = String.valueOf(sc);
                        if (wordSet.contains(tmpStr)) {
                            if (tmpStr.equals(endWord)) return count + 1;
                            queue.offer(tmpStr);
                            wordSet.remove(tmpStr);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
