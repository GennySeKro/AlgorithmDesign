package Enumeration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Q3371
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/28 17:15
 **/
public class Q3371 {
    /*
    识别数组中的最大异常值
     */

    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int total = 0;
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum); // cnt[x]++
            total += x;
        }

        int ans = Integer.MIN_VALUE;
        for (int y : nums) {
            int t = total - y * 2;
            if (cnt.containsKey(t) && (t != y || cnt.get(t) > 1)) {
                ans = Math.max(ans, t);
            }
        }
        return ans;
    }
}
