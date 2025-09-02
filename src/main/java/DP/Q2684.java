package DP;

/**
 * @ClassName: Q2684
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/2 11:55
 **/
public class Q2684 {
    /*
    矩阵中移动的最大次数
     */


    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] f = new int[n][m];
        int max = -1;
        for (int j = 1; j < m; j++)
        {
            for (int i = 0; i < n; i++)
            {
                if (grid[i][j] > grid[i][j - 1] && f[i][j - 1] == j - 1)
                    f[i][j] = f[i][j - 1] + 1;
                if (i - 1 >= 0 && grid[i][j] > grid[i - 1][j - 1] && f[i - 1][j - 1] == j - 1)
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                if (i + 1 < n && grid[i][j] > grid[i + 1][j - 1] && f[i + 1][j - 1] == j - 1)
                    f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 1);
                max = Math.max(max, f[i][j]);
            }
        }
        return max;
    }
}
