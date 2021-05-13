package leetcode.lc202105;

/**
 * 1217. Minimum Cost to Move Chips to The Same Position
 * https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/13
 */
public class LC1217 {
    public int minCostToMoveChips(int[] position) {
        int cost=0,even=0,odd=0;
        for (int i = 0; i < position.length; i++) {

            if (position[i]%2==0){
                even++;
            }else odd++;
        }
        return Math.min(even,odd);

    }
}
