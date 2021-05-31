package leetcode.lc202105;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/27
 */
public class LC17 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        combinate(digits, 0, map, new StringBuffer(), ans);
        return ans;

    }

    private void combinate(String digits, int idx, Map<Character, char[]> map, StringBuffer sb, List<String> ans) {
        if (idx == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        char c = digits.charAt(idx);
        char[] chars = map.get(c);
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            combinate(digits, idx + 1, map, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
