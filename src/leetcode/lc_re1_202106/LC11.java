package leetcode.lc_re1_202106;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/26
 */
public class LC11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, area, maxArea = 0;
        while (left < right) {
            area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;

    }
}
