package leetcode.lc100;

/**
 * Search Insert Position
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/2 16:25
 */
public class LC0035 {
    public  int searchInsert(int[] nums, int target) {
        int s = 0, e = nums.length - 1, m = -1;
        while (s < nums.length && e >= 0 && s <= e) {
            m = (s + e) / 2;
            if (target == nums[m]) return m;
            if (target > nums[m]) s = m + 1;
            else e = m - 1;
        }
        while (m < nums.length && nums[m] < target) m++;
        return m;

    }


}
