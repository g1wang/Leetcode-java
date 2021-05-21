package leetcode.lc202105;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/22
 */
public class LC605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) n--;
            if (n <= 0) return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    i++;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    n--;
                }
            } else if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                i++;
                n--;
            }
            if (n <= 0) return true;
        }
        return false;

    }
}
