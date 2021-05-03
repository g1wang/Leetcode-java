package leetcode.lc202103;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
solution 2 递归
 */
public class LC0017S2 {
    HashMap<Integer, String> map;
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        dfs(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(String digits, int i, StringBuilder sb, List<String> ans){
        if(i == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(i) - 48);
        for(int j = 0; j < letters.length(); j++){
            sb.append(letters.charAt(j));
            dfs(digits, i+1, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
