package ContestBiweekly.biweekly162;

import java.util.Arrays;

public class Q2 {
    /*
    使数组平衡的最少移除项目
     */

    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int maxSave = 0, left = 0;
        for (int i = 0;i < nums.length; i++){
            while ((long) nums[left] * k < nums[i]){
                left++;
            }
            maxSave = Math.max(maxSave, i - left + 1);
        }

        return nums.length - maxSave;
    }
}
