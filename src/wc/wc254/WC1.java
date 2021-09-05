package wc.wc254;
/*
5843. Number of Strings That Appear as Substrings in Word
 */
public class WC1 {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String pattern : patterns) {
            if (word.indexOf(pattern)!=-1) ans++;
        }
        return ans;

    }
}
