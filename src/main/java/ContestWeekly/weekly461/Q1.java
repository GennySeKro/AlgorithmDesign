package ContestWeekly.weekly461;

import org.junit.Test;

public class Q1 {
    /*
    三段式数组1️⃣
     */

    public boolean isTrionic(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length - 1 && nums[i] < nums[i + 1]; i++){
            left++;
        }
        if (left == 0){
            return false;
        }
        right = left;
        for (int i = left; i < nums.length - 1 && nums[i] > nums[i + 1]; i++){
            right++;
        }
        if (right == left || right == nums.length - 1){
            return false;
        }
        int i = right;
        while (i < nums.length - 1 && nums[i] < nums[i + 1]){
            i++;
        }
        return i == nums.length - 1;

    }

    @Test
    public void test(){
        System.out.println(isTrionic(new int[]{3,7,1}));
    }
}
