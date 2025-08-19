package ContestWeekly.weekly463;

import java.util.Arrays;

public class Q3 {
    /*
    删除可整除和后的最小数组和
     */

    public long minArraySum(int[] nums, int k) {
        long[] minF = new long[k];
        Arrays.fill(minF, Long.MAX_VALUE);
        minF[0] = 0;
        long f = 0;
        int sum = 0;
        for (int x : nums){
            sum = (sum + x) % k;
            f = Math.min(f + x, minF[sum]);
            minF[sum] = f;
        }

        return f;
    }
}
