package leetcode.lc0004_median_of_two_sorted_arrays;


/*
4. Median of Two Sorted Arrays
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

 */
public class Solution4 {

    public double findMedianSortedArrays(int A[], int B[]) {


        int lenA = A.length;
        int lenB = B.length;
        int k = (lenA + lenB + 1) / 2;
        int index = 0;
        double median = 0;
        if (lenA <= lenB) {
            index = findKSmallest(A, B, k);
            median = getMedian(A, B, k, index);
        } else {
            index = findKSmallest(B, A, k);
            median = getMedian(B, A, k, index);
        }

        return median;
    }

    // To get the median number of the two arrays based on the index found
    public double getMedian(int A[], int B[], int k, int index) {
        //System.out.println(index);
        int lenA = A.length;
        int lenB = B.length;
        int len = lenA + lenB;
        double median = 0;
        int tmpIdx = k - index;

        int num1 = 0, num2 = 0;
        if (index <= 0) {
            num1 = B[tmpIdx - 1];
        } else if (tmpIdx <= 0) {
            num1 = A[index - 1];
        } else {
            num1 = Math.max(B[tmpIdx - 1], A[index - 1]);
        }

        if (len % 2 == 0) {
            if (index >= lenA) {
                num2 = B[tmpIdx];
            } else if (tmpIdx >= lenB) {
                num2 = A[index];
            } else {
                num2 = Math.min(B[tmpIdx], A[index]);
            }
        }

        if (len % 2 == 1) {
            median = num1;
        } else {
            median = (num1 + num2) / 2.0;
        }

        return median;
    }

    // Get the k smallest item int sorted arrays A and B
    // i+j = k
    public int findKSmallest(int A[], int B[], int k) {
        int lenA = A.length;
        int lenB = B.length;
        int start = 0;
        int end = k > lenA ? lenA - 1 : k - 1;

        while (start <= end) {
            // i is the number of items in the left part of Array A
            int i = start + (end - start) / 2 + 1;
            // j is the number of items in the right part of Array B
            int j = k - i;

            if (j > 0 && j <= lenB && i >= 0 && i <= lenA - 1
                    && B[j - 1] > A[i]) {
                // Move to the right side
                start = i;
            } else if (i > 0 && i <= lenA && j >= 0 && j <= lenB - 1
                    && A[i - 1] > B[j]) {
                // Move to the left side
                end = i - 2;
            } else {
                return i;
            }
        }

        return start;
    }


}
