package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 * Hard
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/18 0:13
 */
public class LC0076 {
    public String minWindow(String s, String t) {

        int start = 0, index = 0;
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = tmap.getOrDefault(c, 0) + 1;
            tmap.put(t.charAt(i), count);
        }
        Map<Character, Integer> smap = new HashMap<>();
        int matchSize = tmap.size();
        int match = 0;
        int[] ans = {-1, 0, 0};
        while (index < s.length()) {
            char c = s.charAt(index);
            if (tmap.containsKey(c)) {
                int count = smap.getOrDefault(c, 0) + 1;
                smap.put(c, count);
                if (tmap.get(c) == count) match++;
                //all t chars is match
                while (start < index && matchSize == match) {
                    char sc = s.charAt(start);
                    if (tmap.containsKey(sc)) {
                        if (ans[0] == -1 || index - start + 1 < ans[0]) {
                            ans[0] = index - start + 1;
                            ans[1] = start;
                            ans[2] = index;

                        }
                        //
                        smap.put(sc,smap.get(sc)-1);
                        if (smap.get(sc)<tmap.get(sc)){
                            match--;
                        }
                    }
                    start++;
                }
            }
            index++;

        }

        return ans[0]==-1?"":s.substring(ans[1],ans[2]+1);

    }
}
