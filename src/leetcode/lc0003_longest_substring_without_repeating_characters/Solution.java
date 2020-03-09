package leetcode.lc0003_longest_substring_without_repeating_characters;

import java.util.*;

/*
 3.Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {

        char[] arrc = s.toCharArray();
        int longest = 0;// 最长的长度
        int start = 0;// 起始点位置
        int cur = 0;// 当前长度
        int len = 0;// len表示两重复点之间的长度
        Integer index = 0; //当前字符出现过的位置
        Map<Character, Integer> map = new HashMap<>();
        char c ;
        for (int i = 0; i < s.length(); i++) {
            c = arrc[i];
            index = map.get(c);
            if (index != null && index >= start) {
                len = i - index;
                cur = len;//
                start = index + 1;
            } else {
                cur++;
            }
            longest = cur > longest ? cur : longest;
            map.put(c, i);
        }
        return longest;
    }
}
