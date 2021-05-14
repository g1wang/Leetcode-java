package leetcode.lc202105;

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC242 {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        int[] counts = new int[128];
        for (int i = 0; i < t.length(); i++) {
            counts[s.charAt(i)]++;
            counts[t.charAt(i)]--;
        }
        for (int i = 0; i < 128; i++) {
            if (counts[i]!=0) return false;
        }
        return true;
    }
}
