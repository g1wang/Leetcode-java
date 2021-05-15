package leetcode.lc202105;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 179. Largest Number
 * https://leetcode.com/problems/largest-number/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/16
 */
public class LC179 {
    public String largestNumber(int[] nums) {
        StringBuffer stringBuffer = new StringBuffer();
        Queue<String> pq = new PriorityQueue<String>((s1, s2) -> compare(s1, s2));
        for (int num : nums) {
            if (num > 0)
                pq.offer(String.valueOf(num));
        }
        while (!pq.isEmpty())
            stringBuffer.append(pq.poll());
        while (stringBuffer.length() > 1 && stringBuffer.charAt(0) == '0') stringBuffer.deleteCharAt(0);
        return stringBuffer.toString();
    }

    int compare(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int start = 0;
        while (start < len) {
            if (s1.charAt(start) > s2.charAt(start)) return -1;
            else if (s1.charAt(start) < s2.charAt(start)) return 1;
            start++;
        }
        if (s1.length() == s2.length()) return -1;
        return s1.length() > s2.length() ? compare(s1.substring(start), s2) : compare(s1, s2.substring(start));
    }
}
