package leetcode.lc202105;

/**
 * 134. Gas Station
 * https://leetcode.com/problems/gas-station/
 * <p>
 * 寻找拐点
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/15
 */
public class LC134S2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minSum = Integer.MAX_VALUE, start = -1, curSum = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            if (minSum > curSum) {
                start = i + 1;
                minSum = curSum;
            }
        }
        return curSum >= 0 ? start % gas.length : -1;
    }

}
