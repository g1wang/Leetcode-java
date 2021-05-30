package biweekly_contest_53;
/*
5754. Substrings of Size Three with Distinct Characters
 */

import java.util.HashMap;
import java.util.Map;

public class Pro1 {
    public int countGoodSubstrings(String s) {
        int ans=0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            if (i >= 3) {
                int count = map.get(s.charAt(i - 3));
                if (count == 1) map.remove(s.charAt(i - 3));
                else map.put(s.charAt(i - 3), count - 1);
            }
            if (map.size()==3) ans++;
        }
        return ans;

    }
}
