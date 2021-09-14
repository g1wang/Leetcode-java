package leetcode.lc2109;

public class LC877 {
    public boolean stoneGame(int[] piles) {
        int start = 0, end = piles.length - 1;
        int a = 0, b = 0;
        while (start < end) {
            if (piles[start] <= piles[end]) {
                a += piles[end--];
            } else a += piles[start++];
            if (piles[start] <= piles[end]) {
                a += piles[end--];
            } else a += piles[start++];
        }
        return a > b;

    }
}
