package Enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Q2364
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/2 09:36
 **/
public class Q2364 {
    /*
    统计坏数对的数目
     */

    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long ans = (long) n * (n - 1) / 2;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i] - i;
            int c = cnt.getOrDefault(x, 0);
            ans -= c;
            cnt.put(x, c + 1);
        }
        return ans;
    }
}
