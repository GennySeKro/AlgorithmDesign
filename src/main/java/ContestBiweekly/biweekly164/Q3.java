package ContestBiweekly.biweekly164;

/**
 * @ClassName: Q3
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/1 10:15
 **/
public class Q3 {
    /*
    统计镜子反射路径数目
     */

    private static final  int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int n = grid[0].length;
        int[][] f = new int[n + 1][2];
        f[1][0] = f[1][1] = 1;
        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 0) {
                    f[j + 1][0] = (f[j][0] + f[j + 1][1]) % MOD;
                    f[j + 1][1] = f[j + 1][0];
                } else {
                    f[j + 1][0] = f[j + 1][1];
                    f[j + 1][1] = f[j][0];
                }
            }
        }

        return f[n][0];
    }
}
