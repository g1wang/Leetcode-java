package leetcode.lc_re1_202106;

import java.util.*;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/27
 */
public class LC15S2 {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);// Sorts array into ascending numerical order.

        Set<Integer> set = new HashSet<>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        if (num == null) {
            return lists;
        }

        for (int i = 0; i < num.length - 1; i++) {
            // 去除重复
            if (set.contains(num[i])) {// map和list的数据的插入方式不一样，list:顺序，map:hashcode
                continue;
            }

            set.add(num[i]);
            int target = -num[i];
            // two pointers
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int sum = num[start] + num[end];
                if (sum == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[start]);
                    list.add(num[end]);
                    lists.add(list);
                    start++;
                    end--;
                } else if (sum < target) {
                    start++;

                } else {
                    end--;

                }
                while (start < end && start > i+1 && num[start] == num[start - 1]) {
                    start++;
                }
                while (start < end && end < num.length - 1 && num[end] == num[end + 1]  ) {
                    end--;
                }

            }

        }
        return lists;
    }
}
