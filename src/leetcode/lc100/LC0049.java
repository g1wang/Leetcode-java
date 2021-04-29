package leetcode.lc100;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Group Anagrams
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/8 17:24
 */
public class LC0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String skey = String.valueOf(chars);
            if (map.containsKey(skey)){
                map.get(skey).add(s);
            }else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(skey,list);
            }
        }
        return  new ArrayList<>(map.values());
    }


}
