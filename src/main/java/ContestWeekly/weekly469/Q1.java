package ContestWeekly.weekly469;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: Q1
 * @Description: 计算十进制表示
 * Author: genny
 * Date: 2025/11/17 22:24
 **/
public class Q1 {

    public int[] decimalRepresentation(int n) {
        List<Integer> a = new ArrayList<>();
        int pow10 = 1;
        for (; n > 0; n /= 10) {
            int d = n % 10;
            if (d > 0) {
                a.add(d * pow10);
            }
            pow10 *= 10;
        }
        Collections.reverse(a);

        int[] ans = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            ans[i] = a.get(i);
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(decimalRepresentation(6));
    }
}
