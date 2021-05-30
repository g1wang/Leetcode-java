package wc243;

public class Pro1 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int idx = 0,carry=0;
        while (idx < firstWord.length() || idx < secondWord.length()||idx < targetWord.length()) {
            int num1 = 0, num2 = 0;
            if (idx < firstWord.length()) {
                num1 = firstWord.charAt(firstWord.length() - 1 - idx) - 'a';
            }
            if (idx < secondWord.length()) {
                num2 = secondWord.charAt(secondWord.length() - 1 - idx) - 'a';
            }
            if (idx < targetWord.length()) {
                if (targetWord.charAt(targetWord.length() - 1 - idx) - 'a' != (num1 + num2+carry)%10) return false;
                carry = (num1 + num2+carry)/10;
            }else if (num1+num2+carry>0) return false;
            idx++;
        }
        return true;
    }
}
