package leetcode.lc202103;

/*
17. Letter Combinations of a Phone Number
Medium

5538

501

Add to List

Share
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.





Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
solution 1 迭代
solution 2 递归
 */
public class LC0017 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null && digits.length() == 0) return result;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        char[] digitChars = digits.toCharArray();
        List<String> listSave = new ArrayList<>();
        List<String> listTmp = new ArrayList<>();
        for (int i = 0; i < digitChars.length; i++) {
            listSave.clear();
            String mapStr = map.get(digitChars[i]);
            for (int j = 0; j < mapStr.length(); j++) {
                String str = mapStr.substring(j, j + 1);
                if (listTmp.isEmpty()) {
                    listSave.add(str);
                } else {
                    for (int k = 0; k < listTmp.size(); k++) {
                        listSave.add(listTmp.get(k) + str);
                    }
                }
            }
            listTmp.clear();
            listTmp.addAll(listSave);
        }
        return listSave;
    }

}
