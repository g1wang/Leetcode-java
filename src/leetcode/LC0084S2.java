package leetcode;

/**
 * Largest Rectangle in Histogram
 * <p>
 * S2
 * l数组存储左起点
 * r数组存储右起点
 * 双向循环
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/25
 */
public class LC0084S2 {


    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] l = new int[len];
        int[] r = new int[len];
        l[0] = -1;
        r[len - 1] = len;
        int maxArea = 0;
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j = l[j];
            }
            l[i] = j;
        }

        for (int i = len - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < len && heights[j] >= heights[i]) {
                j = r[j];
            }
            r[i] = j;

        }
        for (int i = 0; i < len; i++) {
            maxArea = Math.max(maxArea, heights[i] * (r[i] - l[i] - 1));
        }
        return maxArea;


    }
}
