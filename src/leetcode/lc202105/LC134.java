package leetcode.lc202105;

/**
 * 134. Gas Station
 * https://leetcode.com/problems/gas-station/
 *
 * two pointers
 * @author CodeX
 * @version 1.0
 * @date 2021/5/15
 */
public class LC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0, cur, remain = 0,len=0;
        while (start < n && gas[start] < cost[start]) {
            start++;
        }
        if (start == n) return -1;
        cur =start;
        while (len<n) {
            if (remain + gas[cur] >= cost[cur]) {
                remain += gas[cur] - cost[cur];
                cur++;
                if (cur >= n) cur = n - cur;
            } else {
                start--;
                if (start < 0) start = n - 1;
                remain += gas[start] - cost[start];
            }
            len++;
        }
        return remain>=0?start:-1;
    }

}
