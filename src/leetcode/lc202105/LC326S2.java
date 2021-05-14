package leetcode.lc202105;

/**
 * 326. Power of Three
 * https://leetcode.com/problems/power-of-three/
 *
 * 换底公式
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC326S2 {

    public static void main(String[] args) {
        int i=1;
        while (true){
            if (Math.pow(3,i)>Integer.MAX_VALUE){
                System.out.println(Math.pow(3,i-1));
                break;
            }
            i++;
        }
        //1162261467
    }
    public boolean isPowerOfThree(int n) {
        return n>0&&1162261467%n==0;
    }
}
