package leetcode.lc202105;

/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC50 {
    public double myPow(double x, int n) {
        boolean pos = n > 0;
        double res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res *= x;
            }
            x *= x;
            n = n / 2;
        }
        return pos ? res : 1 / res;
    }

    /*public double myPow(double x, int n) {
        //if (Math.abs(x) == 1) return x;
        if (n == 0) return 1;
        int mod = n % 2;
        int q = n / 2;
        double ans = product(x, Math.abs(q));
        ans *= ans;
        ans = mod == 0 ? ans : ans * x;
        return n > 0 ? ans : 1 / ans;

    }

    double product(double x, int n) {
        if (n==0) return 1;
        if (n == 1) return x;
        int mod = n % 2;
        int q = n / 2;
        double ans = product(x, q);
        ans *= ans;
        return mod == 0 ? ans : ans * x;
    }*/
}
