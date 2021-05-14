package leetcode.lc202105;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * https://leetcode.com/problems/fizz-buzz/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC412 {
    public List<String> fizzBuzz(int n) {
        List<String> ans= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((i+1)%15==0) ans.add("FizzBuzz");
            else if ((i+1)%3==0) ans.add("Fizz");
            else if ((i+1)%5==0) ans.add("Buzz");
            else ans.add(String.valueOf(i+1));
        }
        return ans;

    }
}
