package weekly_contest_242;

/*
5763. Longer Contiguous Segments of Ones than Zeros
https://leetcode.com/contest/weekly-contest-242/problems/longer-contiguous-segments-of-ones-than-zeros/
 */
public class Pro1 {
    public boolean checkZeroOnes(String s) {

        if (s.length()==1) return s.equals("1");
        char preChar = '2';
        int max0 = 0, max1 = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == preChar) {
                if (preChar == '0') {
                    max0 = Math.max(max0, ++count);
                } else max1 = Math.max(max1, ++count);
            } else {
                count = 1;
            }
            preChar = s.charAt(i);

        }
        return max1 > max0;

    }
}
