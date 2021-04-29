package leetcode.lc100;

/**
 * Trapping Rain Water
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/6 15:04
 */
public class LC0042 {
    public int trap(int[] height) {
        int area = 0;
        int s = 0, e = height.length - 1;
        int lMax = 0, rMax = 0;
        while (s < e) {
            if (height[s] < height[e]) {
                if (height[s] > lMax) lMax = height[s];
                area += lMax - height[s];
                s++;
            } else {
                if (height[e] > rMax) rMax = height[e];
                area+=rMax-height[e];
                e--;
            }
        }
        return area;
    }
}
