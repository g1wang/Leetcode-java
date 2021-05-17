package leetcode.lc202105;

import java.util.Arrays;
import java.util.Random;

/**
 * 384. Shuffle an Array
 * https://leetcode.com/problems/shuffle-an-array/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/17
 */
public class LC384 {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.nextInt(10));

    }

    class Solution {
        Random rand;
        int[] ori;
        int[] nums;

        public Solution(int[] nums) {
            rand = new Random();
            this.ori = nums.clone();
            this.nums = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            this.nums = ori.clone();
            return this.nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            for (int i = 0; i < this.nums.length; i++) {
                int randIdx = i + rand.nextInt(nums.length - i);
                swap(i,randIdx);
            }
            return this.nums;

        }

        void swap(int i, int j) {
            int tmp = this.nums[i];
            this.nums[i] = this.nums[j];
            this.nums[j] = tmp;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */