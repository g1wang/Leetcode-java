package weekly_contest_238;

import java.util.Arrays;

/*
Maximum Ice Cream Bars
 */
public class LC5735 {

    public int maxIceCream(int[] costs, int coins) {

        Arrays.sort(costs);
        int cost = 0;
        int i = 0;
        while (cost <= coins && i < costs.length) {
            cost += costs[i];
            i++;
        }
        return i-1;

    }
}
