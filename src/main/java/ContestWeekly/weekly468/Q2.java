package ContestWeekly.weekly468;

/**
 * @ClassName: Q2
 * @Description: 最大子数组总️值1️⃣
 * Author: genny
 * Date: 2025/10/13 14:54
 **/
public class Q2 {

    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return  ((long) (max - min) * k);
    }
}
