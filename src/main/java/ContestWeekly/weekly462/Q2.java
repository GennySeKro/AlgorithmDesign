package ContestWeekly.weekly462;

import org.GennySeKro.Main;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Q2 {
    /*
    排序排列
     */

    public int sortPermutation(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i) res &= nums[i];
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    @Test
    public void test(){
        System.out.println(sortPermutation(new int[]{0,2,3,1}));
    }
}
