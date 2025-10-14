package ContestBiweekly.biweekly166;

/**
 * @ClassName: q2
 * @Description: 爬楼梯2️⃣
 * Author: genny
 * Date: 2025/10/14 14:03
 **/
public class Q2 {

    public int climbStairs(int n, int[] costs) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = Math.max(i - 3, 0); j < i; j++) {
                res = Math.min(res, f[j] + (i - j) * (i - j));
            }
            f[i] = res + costs[i - 1];
        }
        return f[n];
    }
}
