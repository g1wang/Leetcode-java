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
public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(-nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(nums[i] + nums[j])) {
                    int idx = map.get(nums[i] + nums[j]);
                    if (idx > j) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[idx]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}

    /*public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);// Sorts array into ascending numerical order.

        List<Integer> list1 = new ArrayList<Integer>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        if (num == null) {
            return lists;
        }

        for (int i = 0; i < num.length - 1; i++) {
            // 去除重复
            if (list1.contains(num[i])) {// map和list的数据的插入方式不一样，list:顺序，map:hashcode
                continue;
            }

            list1.add(num[i]);
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
    }*/