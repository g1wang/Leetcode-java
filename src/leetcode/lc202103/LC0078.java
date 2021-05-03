package leetcode.lc202103;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsets
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/18 15:03
 */
public class LC0078 {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        dfs(nums,new ArrayList<Integer>(),0,0,lists);
        return lists;

    }
    private void dfs(int[] nums ,List<Integer> list,int start, int size,List<List<Integer>> lists){
        lists.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums,list,i+1,size+1,lists);
            list.remove(list.size()-1);
        }

    }

}
