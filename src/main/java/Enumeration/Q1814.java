package Enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Q1814
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/2 11:03
 **/
public class Q1814 {
    /*
    统计一个数组中好对子的数目
     */

    private static final int MOD = 1_000_000_007; // 1e9+7

    public int countNicePairs(int[] nums) {
        Map<Long, Integer> hash = new HashMap<>();
        int ans = 0;

        for (int num : nums) {
            int reverseNum = reverse(num);
            long key = (long) num - reverseNum;

            if (hash.containsKey(key)) {
                ans = (ans + hash.get(key)) % MOD;
            }

            hash.put(key, hash.getOrDefault(key, 0) + 1);
        }

        return ans;
    }

    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
