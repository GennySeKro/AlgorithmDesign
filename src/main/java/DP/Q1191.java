package DP;

import java.util.Arrays;

public class Q1191 {
    /*
    K次串联之后最大子数组之和
     */

    public int kConcatenationMaxSum(int[] arr, int k) {
        if (k == 1){
            return maxSubArray(arr, 1);
        }

        long ans = maxSubArray(arr, 2);
        int s = Arrays.stream(arr).sum();

        ans += (long) Math.max(s, 0) * (k - 2);

        return (int) (ans % 1_000_000_007);



    }

    private int maxSubArray(int[] arr, int repeat) {
        int n = arr.length;
        int ans = 0;
        int f = 0;

        for (int i = 0; i < n * repeat; i++){
            f = Math.max(f, 0) + arr[i % n];
            ans = Math.max(ans, f);
        }

        return ans;
    }
}
