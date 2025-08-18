package ContestBiweekly.biweekly163;

import java.util.Arrays;

public class Q2 {
    /*
    完美对的数目
     */

    public long perfectPairs(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);
        long res = 0L;
        int left = 0;
        for (int j = 0; j < nums.length; j++){
            int b = nums[j];
            while (nums[left] * 2 < b){
                left++;
            }
            res += j - left;
        }

        return res;
    }
}
