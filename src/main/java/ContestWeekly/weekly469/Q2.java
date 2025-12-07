package ContestWeekly.weekly469;

import org.junit.Test;

/**
 * @ClassName: Q2
 * @Description: 分割数组得到最小绝对差
 * Author: genny
 * Date: 2025/11/17 22:56
 **/
public class Q2 {

    public long splitArray(int[] nums) {
       int n = nums.length;
       long pre = nums[0];
       int i = 1;
       while (i < n && nums[i] > nums[i - 1]){
           pre += nums[i];
           i++;
       }

       long suf = nums[n - 1];
       int j = n - 2;
       while (j >= 0 && nums[j] > nums[j + 1]){
           suf += nums[j];
           j--;
       }

       if (i <= j){
           return -1;
       }

       long d = pre - suf;
       if (i - 1 == j){
           return Math.abs(d);
       }

       return Math.min(Math.abs(d + nums[i - 1]), Math.abs(d - nums[i - 1]));
    }


    @Test
    public void test(){
        System.out.println(splitArray(new int[]{2,2}));
    }
}
