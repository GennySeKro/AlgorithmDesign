package ContestWeekly.weekly464;

import org.junit.Test;

import java.util.HashMap;

public class Q2 {
    /*
    数组元素分组
     */

    public boolean partitionArray(int[] nums, int k) {
        if (nums.length % k != 0){
            return false;
        }

        int maxNumTimes = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxNumTimes = Math.max(maxNumTimes, map.get(num));
        }

        return maxNumTimes <= nums.length / k;
    }

    @Test
    public void test(){
        System.out.println(partitionArray(new int[]{1,2,3,4}, 2));
    }
}
