package leetcode.lc202103;

/**
 * Edit Distance
 * https://leetcode.com/problems/edit-distance/
 * hard
 * recursive
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/17 17:23
 */
public class LC0072S1 {
    public  int minDistance(String word1, String word2) {
        return re(word1,word2);
    }

    private int re(String w1,String w2){
        int l1 = w1.length(),l2=w2.length();
        if (l1==0) return l2;
        if (l2==0) return l1;
        if (w1.charAt(l1-1)==w2.charAt(l2-1)){
            return re(w1.substring(0,l1-1),w2.substring(0,l2-1));
        }
        int min = Math.min(re(w1.substring(0,l1-1),w2.substring(0,l2-1)),Math.min(re(w1,w2.substring(0,l2-1)),re(w1.substring(0,l1-1),w2)));
        return 1+min;
    }

}
