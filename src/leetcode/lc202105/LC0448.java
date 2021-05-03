package leetcode.lc202105;

import java.util.ArrayList;
import java.util.List;

/*
448. Find All Numbers Disappeared in an Array
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class LC0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=i+1&&nums[nums[i]-1]!=nums[i]){
                swap(nums,nums[i]-1,i);
                i--;
            }
        }
        List<Integer> list  =new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=i+1) list.add(i+1);
        }
        return list;

    }
    
    void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
