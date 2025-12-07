package ContestWeekly.weekly470;

/**
 * @ClassName: Q1
 * @Description: 计算交替和
 * Author: genny
 * Date: 2025/12/7 18:55
 **/
public class Q1 {

    public int alternatingSum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res += nums[i];
            } else {
                res -= nums[i];
            }
        }

        return res;
    }
}
