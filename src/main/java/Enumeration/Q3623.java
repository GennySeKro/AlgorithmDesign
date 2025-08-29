package Enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Q3623
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/28 15:15
 **/
public class Q3623 {
    /*
    统计梯形的数目1️⃣
     */

    private static final int MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point : points){
            map.merge(point[1], 1, Integer::sum);
        }

        long ans = 0, s = 0;
        for (int c : map.values()){
            long k = (long) c * (c - 1) / 2;
            ans += s * k;
            s += k;
        }

        return (int)(ans % MOD);
    }
}
