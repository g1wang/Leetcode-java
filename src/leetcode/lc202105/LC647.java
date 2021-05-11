package leetcode.lc202105;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/11
 */
public class LC647 {
    public int countSubstrings(String s) {
        int count = s.length();
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int pivot = i, start = 0;
            while (pivot - start - 1 >= 0 && pivot + start < chars.length && chars[pivot + start] == chars[pivot - start - 1]) {
                count++;
                start++;
            }
            start=0;
            while (pivot - start - 1 >= 0 && pivot + start + 1 < chars.length && chars[pivot - 1 - start] == chars[pivot + 1 + start]) {
                count++;
                start++;
            }
        }
        return count;


    }
}
