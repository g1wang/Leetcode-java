package leetcode.lc202105;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. Fraction to Recurring Decimal
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/16
 */
public class LC166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0) return "0";
        long n = numerator;
        long d = denominator;
        StringBuffer ans = new StringBuffer();
        int flag = 1;
        if (n < 0) {
            flag *= -1;
            n *= -1;
        }
        if (d < 0) {
            flag *= -1;
            d *= -1;
        }
        if (flag==-1) ans.append("-");
        Map<Long, Integer> map = new HashMap<>();
        long intNum = n / d;
        ans.append(intNum);
        long remain = n % d;
        if (remain == 0) return ans.toString();
        ans.append(".");
        StringBuffer fracStr = new StringBuffer();
        int idx = 0;
        while (remain != 0) {
            if (map.containsKey(remain)) {
                int repeatLen = idx - map.get(remain), len = fracStr.length();
                ans.append(fracStr, 0, len - repeatLen)
                        .append("(")
                        .append(fracStr, len - repeatLen, len)
                        .append(")");
                return ans.toString();
            }
            map.put(remain, idx++);
            remain *= 10;
            fracStr.append(remain / d);
            remain %= d;
            if (idx > 10000) break;
        }
        ans.append(fracStr);
        return ans.toString();
    }

}
