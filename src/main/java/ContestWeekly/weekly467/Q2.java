package ContestWeekly.weekly467;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: Q2
 * @Description: 至多 K 个不同元素的最大和
 * Author: genny
 * Date: 2025/10/11 10:06
 **/
public class Q2 {

    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);

        ArrayList<Integer> res = new ArrayList<>();
        int index = 1;
        res.add(nums[nums.length - 1]);

        for (int i = nums.length - 1; i >= 0 && index < k; i--){
            if (nums[i] != res.get(index - 1)){
                res.add(nums[i]);
                index++;
            }
        }
        int[] ans = new int[Math.min(res.size(), k)];

        for (int i = 0; i < ans.length; i++){
            ans[i] = res.get(i);
        }

        return ans;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(maxKDistinct(new int[]{84, 93, 100, 77, 90}, 3)));
    }
}
