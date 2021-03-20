package leetcode;

public class LC0029 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        int sumResult = 0;
        int absDivisor = -Math.abs(divisor);
        int absDividend = -Math.abs(dividend);
        int sign = 1;
        sign = dividend < 0 ? -sign : sign;
        sign = divisor < 0 ? -sign : sign;
        while (absDividend <= absDivisor) {
            long sum = absDivisor;
            int result = 1;
            while (absDividend - sum <= sum) {
                result += result;
                sum += sum;
                if (sum < Integer.MIN_VALUE) break;
            }
            sumResult += result;
            absDividend -= sum;
        }
        sumResult = sign > 0 ? sumResult : -sumResult;
        return sumResult;
    }
}
