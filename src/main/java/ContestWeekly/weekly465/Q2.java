package ContestWeekly.weekly465;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Q2
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/1 14:55
 **/
public class Q2 {
    /*
    K 因数分解
     */

    public int[] minDifference(int n, int k) {
        int[] path = new int[k];
        dfs(0, n, Integer.MAX_VALUE, 0, path);
        return ans;
    }

    private int minDiff = Integer.MAX_VALUE;
    private int[] ans;

    private void dfs(int i, int n, int mn, int mx, int[] path) {
        if (i == path.length - 1) {
            int d = Math.max(mx, n) - Math.min(mn, n); // 最后一个数是 n
            if (d < minDiff) {
                minDiff = d;
                path[i] = n;
                ans = path.clone();
            }
            return;
        }
        for (int d = 1; d <= n; d++) { // 枚举 n 的因子 d
            if (n % d == 0) {
                path[i] = d; // 直接覆盖，无需恢复现场
                dfs(i + 1, n / d, Math.min(mn, d), Math.max(mx, d), path);
            }
        }
    }



    @Test
    public void test(){
        System.out.println(Arrays.toString(minDifference(44, 3)));
    }
}
