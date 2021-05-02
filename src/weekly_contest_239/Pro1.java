package weekly_contest_239;

/*
1848. Minimum Distance to the Target Element
https://leetcode.com/problems/minimum-distance-to-the-target-element/
 */
public class Pro1 {
    public int getMinDistance(int[] nums, int target, int start) {
        int count=0;
        while (true){
            if (start-count>=0&&nums[start-count]==target) return count;
            if (start+count<nums.length&&nums[start+count]==target) return count;
            count++;
        }

    }
}
