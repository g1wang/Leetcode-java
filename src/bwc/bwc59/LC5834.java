package bwc.bwc59;

public class LC5834 {

    public static void main(String[] args) {
        LC5834 lc5834 = new LC5834();
        System.out.println(lc5834.minTimeToType("zjpc"));
    }
    public int minTimeToType(String word) {
        char preChar = 'a';
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            int abs = Math.abs(word.charAt(i)-preChar);
            count+=Math.min(abs,26-abs);
            preChar = word.charAt(i);
        }
        count+=word.length();

        return count;
    }
}
