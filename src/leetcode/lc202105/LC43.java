package leetcode.lc202105;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 43. Multiply Strings
 * https://leetcode.com/problems/multiply-strings/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/26
 */
public class LC43 {

    public static void main(String[] args) {
        LC43 lc43 = new LC43();
        lc43.multiply("9", "99");
    }

    public String multiply(String num1, String num2) {
        List<Integer> result = new ArrayList<>();
        int[] nums1 = new int[num1.length()];
        int[] nums2 = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            nums1[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < num2.length(); i++) {
            nums2[i] = num2.charAt(i) - '0';
        }
        for (int i = nums1.length - 1; i >= 0; i--) {
            List<Integer> list = multiOne(nums1[i], nums1.length - 1 - i, nums2);
            result = add(result, list);
        }
        Collections.reverse(result);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    private List<Integer> add(List<Integer> list, List<Integer> list2) {
        int carry = 0;
        for (int i = 0; i < list2.size(); i++) {
            int num1 = 0;
            if (i < list.size()) num1 = list.get(i);
            int sum = carry + num1 + list2.get(i);
            list2.set(i, sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) list2.add(carry);
        return list2;
    }


    private List<Integer> multiOne(int num, int idx, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < idx; i++) {
            list.add(0);
        }
        int carry = 0, product = 0;
        for (int i = nums2.length - 1; i >= 0; i--) {
            product = carry + num * nums2[i];
            carry = product / 10;
            list.add(product % 10);
        }
        if (carry > 0) list.add(carry);
        return list;
    }
}
