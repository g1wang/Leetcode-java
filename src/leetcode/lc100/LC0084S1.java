package leetcode.lc100;

import java.util.Stack;

/**
 * Largest Rectangle in Histogram
 * S1： 波峰围城的面积
 * @author CodeX
 * @version 1.0
 * @date 2021/4/24
 */
public class LC0084S1 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length ? 0 : heights[i]);
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int index = stack.pop();
                int w = stack.isEmpty() ? i : (i - 1 - stack.peek());
                maxArea = Math.max(maxArea, w * heights[index]);
            }
            stack.push(i);
        }
        return maxArea;
    }

}
