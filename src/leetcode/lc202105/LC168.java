package leetcode.lc202105;

/**
 * 168. Excel Sheet Column Title
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC168 {

    public String convertToTitle(int columnNumber) {
        StringBuffer stringBuffer = new StringBuffer();
        while (columnNumber>0){
            columnNumber--;
            char c = (char) ('A'+columnNumber%26);
            stringBuffer.insert(0,c);
            columnNumber/=26;
        }
        return stringBuffer.toString();
    }
}
