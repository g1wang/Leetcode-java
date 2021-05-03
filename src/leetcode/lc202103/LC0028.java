package leetcode.lc202103;

/*
28. Implement strStr()
Easy

2219

2292

Add to List

Share
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().



Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0


Constraints:

0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.
Accepted
 */
public class LC0028 {
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < needle.length()) return -1;
            int index = 0;
            while (haystack.charAt(index + i) == needle.charAt(index)) {
                index++;
                if (index == needle.length()) {
                    return i;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi",
                "issip"));
        ;
    }
}
