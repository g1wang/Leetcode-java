package leetcode;

public class LC0215S2 {

    public int findKthLargest(int[] nums, int k) {
        return bfprt(nums,0,nums.length-1,k);
    }


    private int bfprt(int[] nums, int s, int e, int k) {
        int mid = findMid(nums, s, e);
        int p = partion(nums, s, e, mid);
        //TOP m
        int m = e - p + 1;
        if (m == k) return nums[p];
        if (m > k) {
            return bfprt(nums, p + 1, e, k);
        } else return bfprt(nums, s, p - 1, k - m);


    }


    //插入排序
    private void insertSort(int[] nums, int s, int e) {
        for (int i = s + 1; i <= e; i++) {
            if (nums[i - 1] > nums[i]) {
                int k = i;
                int tmp = nums[k];
                while (k > s && nums[k - 1] > tmp) {
                    nums[k] = nums[k - 1];
                    k--;
                }
                nums[k] = tmp;
            }
        }
    }


    //找中位数
    private int findMid(int[] nums, int s, int e) {
        if (s == e) return s;
        int i = s;//原数组
        int j = s;//新中位数数组
        for (; i < e - 5; i += 5, j++) {
            insertSort(nums, i, i + 4);
            swap(nums, j, i + 2);
        }
        int remain = e - i + 1;
        if (remain > 0) {
            insertSort(nums, i, e);
            swap(nums, j, i + remain / 2);
        }
        return findMid(nums, s, j);
    }


    //二分
    private int partion(int[] nums, int s, int e, int p) {
        swap(nums, s, p);
        int pivot = nums[s];
        while (s < e) {
            while (pivot <= nums[e] && s < e) {
                e--;
            }
            nums[s] = nums[e];
            while (pivot >= nums[s] && s < e) {
                s++;
            }
            nums[e] = nums[s];
        }
        nums[s] = pivot;
        return s;
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
