package leetcode.lc_re1_202106;

/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/25
 */
public class LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int mid = (len1 + len2 + 1) / 2;
        if (len1 <= len2) {
            int idx = findMid(nums1, nums2, mid);
            return getMedian(nums1, nums2, idx,mid);
        } else {
            int idx = findMid(nums2, nums1, mid);
            return getMedian(nums2, nums1, idx,mid);
        }

    }

    private double getMedian(int[] nums1, int[] nums2,  int idx,int mid) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        double median = 0;
        int tmpIdx = mid - idx;

        int num1 = 0, num2 = 0;
        if (idx <= 0) {
            num1 = nums2[tmpIdx - 1];
        } else if (tmpIdx <= 0) {
            num1 = nums1[idx - 1];
        } else {
            num1 = Math.max(nums2[tmpIdx - 1], nums1[idx - 1]);
        }

        if (len % 2 == 0) {
            if (idx >= len1) {
                num2 = nums2[tmpIdx];
            } else if (tmpIdx >= len2) {
                num2 = nums1[idx];
            } else {
                num2 = Math.min(nums2[tmpIdx], nums1[idx]);
            }
        }

        if (len % 2 == 1) {
            median = num1;
        } else {
            median = (num1 + num2) / 2.0;
        }
        return median;
    }


    int findMid(int[] nums1, int[] nums2, int mid) {
        int len1 = nums1.length, len2 = nums2.length;
        int start = 0, end = len1 - 1;
        while (start<=end) {
            // i is the number of items in the left part of Array nums1
            int i = start + (end - start) / 2 + 1;
            // j is the number of items in the right part of Array B
            int j = mid - i;

            if (j > 0 && j <= len2 && i >= 0 && i <= len1 - 1
                    && nums2[j - 1] > nums1[i]) {
                // Move to the right side
                start = i;
            } else if (i > 0 && i <= len1 && j >= 0 && j <= len2 - 1
                    && nums1[i - 1] > nums2[j]) {
                // Move to the left side
                end = i - 2;
            } else {
                return i;
            }
        }
        return start;
    }
}
