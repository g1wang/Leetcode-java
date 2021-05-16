package leetcode.lc202105;

/**
 * 227. Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/16
 */
public class LC227 {

    public int calculate(String s) {
        return split(s, "\\+");
    }

    int split(String s, String opt) {
        int res = 0;
        String[] ss = s.split(opt);
        if (opt.equals("\\+")) {
            res = 0;
            for (int i = 0; i < ss.length; i++) {
                res += split(ss[i], "\\-");
            }
        } else if (opt.equals("\\-")) {
            res = calculatePart(ss[0]);
            for (int i = 1; i < ss.length; i++) {
                res -= calculatePart(ss[i]);
            }
        }
        return res;
    }

    private int calculatePart(String s) {
        int idx = 0, start = idx;
        char preOpt = 0;
        while (idx < s.length() && s.charAt(idx) != '*' && s.charAt(idx) != '/') {
            idx++;
        }
        int res = Integer.parseInt(s.substring(start, idx).trim());
        idx++;
        start = idx;
        while (idx < s.length()) {
            preOpt = s.charAt(idx - 1);
            while (idx < s.length() && s.charAt(idx) != '*' && s.charAt(idx) != '/') {
                idx++;
            }
            if (preOpt == '*') {
                res *= Integer.parseInt(s.substring(start, idx).trim());
            } else if (preOpt == '/') {
                res /= Integer.parseInt(s.substring(start, idx).trim());
            }
            idx++;
            start = idx;
        }
        return res;
    }

}
