package DP;

import java.util.Arrays;

/**
 * @ClassName: Q3418
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/2 14:09
 **/
public class Q3418 {
    /*
    机器人可以获得的最大金币数
     */

    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;

        //第三维度表示感化次数
        int[][][] dp = new int[m + 1][n + 1][3];
       for (int[] row : dp[0]){
           Arrays.fill(row, Integer.MIN_VALUE);
       }

       Arrays.fill(dp[0][1], 0);
       for (int i = 0; i < m; i++){
           Arrays.fill(dp[i + 1][0], Integer.MIN_VALUE);
           for (int j = 0; j < n; j++){
               int x = coins[i][j];
               dp[i + 1][j + 1][0] = Math.max(dp[i + 1][j][0], dp[i][j + 1][0]) + x;
               dp[i + 1][j + 1][1] = Math.max(
                       Math.max(dp[i + 1][j][1], dp[i][j + 1][1]) + x,
                       Math.max(dp[i + 1][j][0], dp[i][j + 1][0])
               );
               dp[i + 1][j + 1][2] = Math.max(
                       Math.max(dp[i + 1][j][2], dp[i][j + 1][2]) + x,
                       Math.max(dp[i + 1][j][1], dp[i][j + 1][1])
               );
           }
       }

       return dp[m][n][2];
    }
}
