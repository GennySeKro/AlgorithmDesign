package DP;

import java.util.Arrays;

/**
 * @ClassName: Q416
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/3 08:30
 **/
public class Q416 {
    /*
    分割等和子集
     */

    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int num : nums){
            s += num;
        }

        if (s % 2 == 1){
            return false;
        }

        int n = nums.length;
        int[][] memo = new int[n][s / 2 + 1];
        for (int[] row : memo){
            Arrays.fill(row, -1);
        }

        return dfs(n - 1, s / 2, nums, memo);
    }

    private boolean dfs(int i, int j, int[] nums, int[][] memo) {
        if (i < 0){
            return j == 0;
        }
        if (memo[i][j] != -1){
            return memo[i][j] == 1;
        }
        boolean res;
        if (j < nums[i]){
            res = dfs(i - 1, j, nums, memo);
        }else {
            res = dfs(i - 1, j - nums[i], nums, memo) || dfs(i - 1, j, nums, memo);
        }

        memo[i][j] = res ? 1 : 0;
        return res;
    }
}
