package leetcode.lc202105;

import java.util.Arrays;

/**
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC387 {
    public int firstUniqChar(String s) {
        int[] counts = new int[26];
        int[] starts = new int[26];
        Arrays.fill(starts,s.length());
        int ans=s.length();
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i)-'a';
            if (counts[idx]==0) {
                starts[idx]=i;
                counts[idx]++;
            }else if (counts[idx]==1){
                counts[idx]++;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i]==1) ans= Math.min(ans,starts[i]);
        }
        return ans==s.length()?-1:ans;
    }
}
