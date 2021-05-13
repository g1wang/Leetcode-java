package leetcode.lc202105;

import java.util.*;

/**
 * 350. Intersection of Two Arrays II
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int num : nums2) {
            if (map.containsKey(num)){
                int count = map.get(num);
                list.add(num);
                if (count==1) map.remove(num);
                else map.put(num,count-1);
            }
        }
        int[] r = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            r[i] = list.get(i);
        }
        return r;// list.stream().mapToInt(Integer::intValue).toArray();
    }
}
