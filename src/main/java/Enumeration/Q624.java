package Enumeration;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: Q624
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/2 09:04
 **/
public class Q624 {
    /*
    数组列表中的最大距离
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        int mn = Integer.MAX_VALUE / 2; // 防止减法溢出
        int mx = Integer.MIN_VALUE / 2;
        for (List<Integer> a : arrays) {
            int x = a.get(0);
            int y = a.get(a.size() - 1);
            ans = Math.max(ans, Math.max(y - mn, mx - x));
            mn = Math.min(mn, x);
            mx = Math.max(mx, y);
        }
        return ans;
    }
}
