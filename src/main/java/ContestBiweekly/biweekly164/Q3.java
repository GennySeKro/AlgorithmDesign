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
    private static final int[] failed = {-1, -1};

    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][][] jumps = new int[2][m][n][];
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = 1;
                } else if (grid[i][j] == 0) {
                    //从左侧跳转而来
                    int[] left = getJumps(grid, i, j - 1, 0, jumps);

                    //从上方跳转而来
                    int[] up = getJumps(grid, i - 1, j, 1, jumps);

                    if (left != failed){
                        dp[i][j] = (dp[i][j] + dp[left[0]][left[1]]) % MOD;
                    }
                    if (up != failed){
                        dp[i][j] = (dp[i][j] + dp[up[0]][up[1]]) % MOD;
                    }
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    private int[] getJumps(int[][] grid, int i, int j, int dir, int[][][][] jumps) {
        if (i >= 0 && j >= 0){
            //未被计算过
            if (jumps[dir][i][j] == null){
                if (grid[i][j] == 0){
                    jumps[dir][i][j] = new int[]{i, j};
                }else if (dir == 1) {  //当前方向为下，反射向右
                    jumps[dir][i][j] = getJumps(grid, i, j - 1, dir ^ 1, jumps);
                }else { //dor = 0，反射向上
                    jumps[dir][i][j] = getJumps(grid, i - 1, j, dir ^ 1, jumps);
                }
            }
            return jumps[dir][i][j];
        }
        return failed;
    }
}
