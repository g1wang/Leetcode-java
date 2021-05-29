package leetcode.lc202105;

public class LC263 {
    public boolean isUgly(int n) {
        if (n < 1) return false;
        while (n % 5 == 0) {
            n /= 5;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 2 == 0) {
            if ((n & (n - 1)) == 0) return true;
            else break;
        }
        if (n == 1) return true;
        else return false;

    }
}
