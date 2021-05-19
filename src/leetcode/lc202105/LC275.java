package leetcode.lc202105;

/**
 * 275. H-Index II
 * https://leetcode.com/problems/h-index-ii/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/19
 */
public class LC275 {
    public int hIndex(int[] citations) {

        int n = citations.length, left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == n - mid || (mid ==0 || citations[mid - 1] < (n - mid+1)) && citations[mid] > n - mid) {
                return n - mid;
            }
            if (citations[mid] > n - mid){
                right=mid-1;
            }else left=mid+1;
        }
        return 0;
    }

}
