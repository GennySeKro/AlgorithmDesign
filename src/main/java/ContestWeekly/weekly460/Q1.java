package ContestWeekly.weekly460;

import java.util.Arrays;

/**
 * @ClassName: Q1
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/28 09:40
 **/
public class Q1 {
    /*
    中位数之和的最大值
     */

    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        long res = 0L;
        int left = 0, right = nums.length - 1;
        while (left < right){
            res += nums[right - 1];
            left++;
            right--;
            right--;
        }

        return res;
    }
}
