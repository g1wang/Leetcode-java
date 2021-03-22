package leetcode;

import java.util.*;

public class LC0030 {
    public Map<String, Integer> mapmaker(String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++)
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        return map;
    }

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> list = new ArrayList<>();
        int n = words.length;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int size = words[0].length(), window = size * n;
        for (int i = 0; i < size; ++i) {
            int start = i;
            while (start + window <= s.length()) {
                String sub = s.substring(start, start + window);
                Map<String, Integer> temp = new HashMap<>();
                int j = n;
                while (j > 0) {
                    String word = sub.substring(size * (j - 1), size * j);
                    int count = temp.getOrDefault(word, 0) + 1;
                    if (count > map.getOrDefault(word, 0)) {
                        break;
                    }
                    temp.put(word, count);
                    --j;
                }
                if (j == 0) {
                    list.add(start);
                }
                start += size * Math.max(j, 1);
            }
        }
        return list;

    }
}
