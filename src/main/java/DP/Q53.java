package DP;

public class Q53 {
    /*
    最大子数组和
     */

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++){
            dp[i + 1] = Math.max(nums[i], dp[i] + nums[i]);
            res = Math.max(res, dp[i + 1]);
        }

        return res;
    }
}
