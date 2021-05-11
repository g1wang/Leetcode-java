package leetcode.lc202105;

import java.util.Arrays;

/**
 * 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/11
 */
public class LC621 {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        int max = 0, maxCount = 0;
        for (char task : tasks) {
            int count = ++counts[task - 'A'];
            if (count == max) maxCount++;
            else if (count > max) {
                max++;
                maxCount = 1;
            }
        }
        int partCount = max - 1;
        int partLen = n - maxCount + 1;
        int emptySlots = partCount * partLen;
        int remainTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - remainTasks);
        return tasks.length + idles;
    }
}
