package DP;

import java.util.Arrays;

/**
 * @ClassName: Q494
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/3 10:50
 **/
public class Q494 {
    /*
    目标和
     */

    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int num : nums){
            s += num;
        }

        s -= Math.abs(target);
        if (s < 0 || s % 2 == 1){
            return 0;
        }

        int m = s / 2, n = nums.length;;
        int[][] memo = new int[n][m + 1];

        for (int[] row : memo){
            Arrays.fill(row, -1);
        }

        return dfs(n - 1, m, nums, memo);
    }

    private int dfs(int i, int c, int[] nums, int[][] memo) {
        if (i < 0){
            return c == 0 ? 1 : 0;
        }

        if (memo[i][c] != -1){
            return memo[i][c];
        }

        int ans = dfs(i - 1, c, nums, memo);//不选

        if (c >= nums[i]){
            ans += dfs(i - 1, c - nums[i], nums, memo);
        }

        return memo[i][c] = ans;
    }
}
