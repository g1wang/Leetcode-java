package leetcode;

import java.util.*;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30
 */
public class LC0155 {

    class MinStack {

        List<Integer> list;
        int size;
        int min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            list = new ArrayList<>();
            size = 0;

        }

        public void push(int val) {
            if (size==0) min = val;
            min = Math.min(min, val);
            list.add(val);
            size++;
        }

        public void pop() {
            if (size == 0) return;
            int rm = list.remove(size - 1);
            size--;
            if (size==0){
                min = Integer.MIN_VALUE;
                return;
            }
            if (min==rm){
                min  = list.get(0);
                for (int i = 1; i < size; i++) {
                    min = Math.min(min, list.get(i));
                }
            }
        }

        public int top() {
            if (size == 0) return 0;
            return list.get(size - 1);
        }

        public int getMin() {
            if (size == 0) return 0;
            return min;
        }
    }
}
