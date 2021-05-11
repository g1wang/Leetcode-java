package leetcode.lc202105;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC394 {

    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuffer string = new StringBuffer();
        StringBuffer num = new StringBuffer();
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') num.append(c);
            if (c == '[') {
                stack.push(string.toString());
                string = new StringBuffer();
                stack.push(num.toString());
                num = new StringBuffer();
            } else if (c >= 'a' && c <= 'z') {
                string.append(c);
            } else if (c == ']') {
                StringBuffer popBuffer = new StringBuffer();
                int repeat = Integer.valueOf(stack.pop());
                for (int i = 0; i < repeat; i++) popBuffer.append(string);
                popBuffer.insert(0, stack.pop());
                string = popBuffer;
            }
        }
        return string.toString();
    }
}
