package leetcode.lc202105;

/**
 * 135. Candy
 * https://leetcode.com/problems/candy/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/21
 */
public class LC135 {
    public int candy(int[] ratings) {
        int left = 0, count = 1, base = 1, descBase = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i - 1]) {
                if (descBase > 1) {
                    base = 1;
                    descBase--;
                    count += (i - left);
                } else
                    count += (i - left) + 1;
            } else if (ratings[i] > ratings[i - 1]) {
                base++;
                count += base;
                left = i;
                descBase = base;
            } else {
                count++;
                base = 1;
                left = i;
                descBase = 1;
            }
        }
        return count;

    }
}
