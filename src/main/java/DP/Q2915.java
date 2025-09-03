package DP;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Q2915
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/3 11:00
 **/
public class Q2915 {
    /*
    和为目标值的最长子序列长度
     */

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] memo = new int[n][target + 1];

        for (int[] row : memo){
            Arrays.fill(row, -1);
        }

        int ans = dfs(n - 1, target, nums, memo);

        return ans > 0 ? ans : -1;
    }

    private int dfs(int index, int target, List<Integer> nums, int[][] memo) {
        if (index < 0){
            return target == 0 ? 0 : Integer.MIN_VALUE;
        }

        if (memo[index][target] != -1){
            return memo[index][target];
        }

        int res = dfs(index - 1, target, nums, memo);

        if (target >= nums.get(index)){
            res = Math.max(res, dfs(index - 1, target - nums.get(index), nums, memo) + 1);
        }

        return memo[index][target] = res;
    }
}
