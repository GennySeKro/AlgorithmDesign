package ContestWeekly.weekly470;

import org.junit.Test;

/**
 * @ClassName: Q2
 * @Description: 按位异或非零的最长子序列
 * Author: genny
 * Date: 2025/12/7 18:57
 **/
public class Q2 {

    public int longestSubsequence(int[] nums) {
        boolean hasNonZero = false;
        int xor = 0;
        for (int x : nums) {
            hasNonZero = hasNonZero || x != 0;
            xor ^= x;
        }
        if (!hasNonZero) {
            return 0; // nums 全为 0，无解
        }

        int ans = nums.length;
        if (xor == 0) {
            ans--; // 去掉 nums 的一个非零元素，就可以使 xor 不为 0
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(longestSubsequence(new int[]{1, 2, 3}));
    }


}
