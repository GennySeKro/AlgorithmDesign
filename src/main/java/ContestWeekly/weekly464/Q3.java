package ContestWeekly.weekly464;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q3 {
    /*
    跳跃游戏9️⃣
     */

    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] preMax = new int[n];
        preMax[0] = nums[0];
        for (int i = 1; i < n; i++){
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }

        int[] ans = new int[n];
        int sufMin = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--){
            ans[i] = preMax[i] <= sufMin ? preMax[i] : ans[i + 1];
            sufMin = Math.min(sufMin, nums[i]);
        }


        return ans;
    }


    @Test
    public void test(){
        System.out.println(Arrays.toString(maxValue(new int[]{2, 3, 1})));
    }
}
