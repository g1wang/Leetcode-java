package leetcode.lc202105;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. Partition Labels
 * https://leetcode.com/problems/partition-labels/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/6
 */
public class LC763 {
    public List<Integer> partitionLabels(String S) {
        int[] right = new int[26];
        for (int i = 0; i <S.length(); i++)
            right[S.charAt(i) - 'a'] = i;
        List<Integer> ans = new ArrayList<>();
        int rmax = 0, start = 0;
        for (int i = 0; i < S.length(); i++) {
            rmax = Math.max(rmax, right[S.charAt(i) - 'a']);
            if (i == rmax) {
                ans.add(rmax - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
