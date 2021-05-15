package leetcode.lc202105;

/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC344 {
    public void reverseString(char[] s) {
        int start=0,end=s.length-1;
        while (start<end){
            if (s[start]!=s[end]){
                char tmp = s[start];
                s[start] = s[end];
                s[end] = tmp;
            }
            start++;
            end--;
        }
    }
}
