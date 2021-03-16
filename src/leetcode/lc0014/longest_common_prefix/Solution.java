package leetcode.lc0014.longest_common_prefix;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

 */

/*
solution
1 获取参照str
2 速度取决于最短str

 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) return "";
        boolean isEnd = false;
        for (int i = 0; i < strs[0].length(); i++) {
            char prefix = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i||prefix!=strs[j].charAt(i)) {
                    isEnd = true;
                    break;
                }
            }
            if (isEnd) return strs[0].substring(0,i);
        }
        return strs[0];


    }
}
