package wc.wc244;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
5777. Reduction Operations to Make the Array Elements Equal
 */
public class P2 {

    public int reductionOperations(int[] nums) {

        Map<Integer, Integer> cntMap = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> {
            return b - a;
        });
        for (int num : nums) {
            if (cntMap.containsKey(num)) {
                cntMap.put(num, cntMap.get(num) + 1);
            } else {
                queue.add(num);
                cntMap.put(num, 1);
            }
        }
        int opt = 0, curLargestCnt = 0;
        while (queue.size() > 1) {
            int largest = queue.poll();
            int cnt = cntMap.get(largest);
            curLargestCnt += cnt;
            opt += curLargestCnt;
        }
        return opt;
    }
}
