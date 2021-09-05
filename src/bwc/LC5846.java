package bwc;

/*
https://leetcode.com/contest/biweekly-contest-60/problems/find-the-middle-index-in-array/
 */
public class LC5846 {
    public int findMiddleIndex(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum=0;
        for (int i = 0; i < nums.length; i++) {
            if (sum-nums[i]-leftSum==leftSum)
                return i;
            leftSum+=nums[i];
        }
        return -1;

    }

    public static void main(String[] args) {
        LC5846 bwc5846 = new LC5846();
        System.out.println(bwc5846.findMiddleIndex(new int[]{1,-1,4}));
    }
}
