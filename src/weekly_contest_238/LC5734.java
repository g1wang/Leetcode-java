package weekly_contest_238;

/*
Check if the Sentence Is Pangram
 */
public class LC5734 {
    public boolean checkIfPangram(String sentence) {
        int count = 0;
        int[] dict = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (dict[c-'a'] == 0) {
                count++;
                dict[c-'a'] = 1;
            }
            if (count == 26) {
                return true;
            }
        }
        return false;

    }

}
