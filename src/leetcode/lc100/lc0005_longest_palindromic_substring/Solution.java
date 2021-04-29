package leetcode.lc100.lc0005_longest_palindromic_substring;

/*
5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcba"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        if (s.length() == 1) return s;
        String ps = "";
        char[] sc = s.toCharArray();
        int scLen = sc.length;
        int j;
        for (int i = 0; i < scLen - 1; i++) {
            //"baab"
            j = 0;
            while (i - j >= 0 && i + j + 1 < scLen && sc[i - j] == sc[i + j + 1]) {
                j++;
            }
            if (2 * j > ps.length()) ps = s.substring(i - j + 1, i + j + 1);
            j = 0;
            while (i - j - 1 >= 0 && i + j + 1 < scLen && sc[i - j - 1] == sc[i + j + 1]) {
                j++;
            }
            if (2 * j + 1 > ps.length()) ps = s.substring(i - j, i + j + 1);
        }
        return ps;
    }
}
