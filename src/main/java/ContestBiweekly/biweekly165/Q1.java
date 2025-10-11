package ContestBiweekly.biweekly165;

import org.junit.Test;

import java.util.HashSet;

/**
 * @ClassName: Q1
 * @Description: 大于平均值的最小未出现整数
 * Author: genny
 * Date: 2025/10/11 08:53
 **/
public class Q1 {

    public int smallestAbsent(int[] nums) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums){
            sum += num;
            set.add(num);
        }

        int average = sum / nums.length + 1;

        for (int i = Math.max(average, 1);;i++){
            if (!set.contains(i)){
                return i;
            }
        }
    }

    @Test
    public void test(){
        System.out.println(smallestAbsent(new int[]{3, 5}));
    }
}
