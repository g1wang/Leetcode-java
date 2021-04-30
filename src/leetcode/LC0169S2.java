package leetcode;

import java.util.LinkedList;

/**
 *
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30
 */
public class LC0169S2 {
    public int majorityElement(int[] nums) {
        int major =0;
        int count = 0;
        for (int num : nums) {
            if (count==0){
                major=num;
            }
            count+=major==num?1:-1;
        }
        return major;
    }
}
