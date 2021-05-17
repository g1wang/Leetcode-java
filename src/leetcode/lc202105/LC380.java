package leetcode.lc202105;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1)
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/17
 */
public class LC380 {
    class RandomizedSet {
        Random rand;
        Map<Integer, Integer> map;
        List<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            rand = new Random();
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                list.add(val);
                map.put(val, list.size() - 1);
                return true;
            } else return false;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int rmIdx = map.get(val);
                int lastVal = list.get(list.size() - 1);
                list.set(rmIdx, lastVal);
                map.put(lastVal, rmIdx);
                map.remove(val);
                list.remove(list.size() - 1);
                return true;
            } else return false;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
