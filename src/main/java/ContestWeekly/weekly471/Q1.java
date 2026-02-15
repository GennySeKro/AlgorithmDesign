package ContestWeekly.weekly471;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Q1
 * @Description: 出现次数能被 K 整除的元素总和
 * Author: genny
 * Date: 2026/1/12 20:59
 **/
public class Q1 {

    public int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % k == 0) {
                res += entry.getKey() * entry.getValue();
            }
        }

        return res;
    }

    @Test
    public void test() {
        System.out.println(sumDivisibleByK(new int[]{1, 2, 2, 3, 3, 3, 3, 4}, 2));
    }
}
