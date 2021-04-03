package leetcode;

/*
Count and Say
 */
public class LC0038 {
    public String countAndSay(int n) {
        String s = "1";
        while (n > 1) {
            char c = s.charAt(0);
            int count = 0;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    count++;
                } else {
                    sb.append(count).append(c);
                    c = s.charAt(i);
                    count = 1;
                }
            }
            n--;
            sb.append(count).append(c);
            s = sb.toString();

        }
        return s;

    }
}
