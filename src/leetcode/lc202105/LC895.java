package leetcode.lc202105;

import java.util.*;

/**
 * 895. Maximum Frequency Stack
 * https://leetcode.com/problems/maximum-frequency-stack/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/28
 */
public class LC895 {
    class FreqStack {

        Map<Integer, Integer> map;
        List<Deque<Integer>> freqList;

        public FreqStack() {
            map = new HashMap<>();
            freqList = new ArrayList<>();
        }

        public void push(int val) {
            int count = map.getOrDefault(val, 0) + 1;
            if (freqList.size() < count) {
                Deque<Integer> stack = new LinkedList<>();
                stack.push(val);
                freqList.add(stack);
            } else {
                Deque<Integer> stack = freqList.get(count - 1);
                stack.push(val);
            }
            map.put(val, count);
        }

        public int pop() {
            Deque<Integer> stack = freqList.get(freqList.size() - 1);
            int val = stack.pop();
            int count = map.getOrDefault(val, 0) - 1;
            if (count == 0) map.remove(val);
            else map.put(val, count);
            if (stack.isEmpty()) freqList.remove(freqList.size() - 1);
            return val;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}
