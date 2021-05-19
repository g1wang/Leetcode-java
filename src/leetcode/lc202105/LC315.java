package leetcode.lc202105;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * Time Limit Exceeded
 * @author CodeX
 * @version 1.0
 * @date 2021/5/18
 */
public class LC315 {
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count=0;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]>nums[j]) count++;
            }
            ansList.add(count);
        }
        return ansList;

    }
}
