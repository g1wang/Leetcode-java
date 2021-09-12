package wc.wc258;

public class LC5867 {
    public String reversePrefix(String word, char ch) {

        int index = word.indexOf(ch);
        if (index <= 0) return word;
        int start = 0;
        char[] words = word.toCharArray();
        while (start < index) {
            char a = words[start];
            words[start] = words[index];
            words[index] = a;
            start++;
            index--;
        }
        return String.valueOf(words);

    }
}
