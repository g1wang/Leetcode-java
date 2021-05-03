package leetcode.lc202104;

/**
 * 152. Maximum Product Subarray
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/1
 */
public class LC0152S2 {

    public static int maxProduct(int[] nums) {
        int max= Integer.MIN_VALUE;
        int p =1;
        for (int num : nums) {
            p= p*num;
            max = Math.max(p,max);
            p=num==0?1:p;
        }

        p=1;
        for (int i = nums.length-1; i >=0 ; i--) {
            p= p*nums[i];
            max = Math.max(p,max);
            p=nums[i]==0?1:p;
        }

        return max;

    }




}
