package leetcode.lc202104;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30
 */
public class LC0146 {
    class LRUCache {
        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (list.size()==0||!list.contains(key)) return -1;
            list.remove(Integer.valueOf(key));
            list.add(key);
            return map.get(key);

        }

        public void put(int key, int value) {
            map.put(key, value);
            if (list.contains(key)) {
                list.remove(Integer.valueOf(key));
            } else if (list.size() == capacity) {
                map.remove(list.get(0));
                list.remove(0);
            }
            list.add(key);
        }
    }
}
