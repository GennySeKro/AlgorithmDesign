package Enumeration;

import org.junit.Test;

/**
 * @ClassName: Q1014
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/2 09:51
 **/
public class Q1014 {
    /*
    最佳观光组合
     */

    public int maxScoreSightseeingPair(int[] values) {
        int preMax = values[0], ans = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++){
            ans = Math.max(ans, preMax + values[i] - i);
            preMax = Math.max(preMax, values[i] + i);
        }

        return ans;
    }

    @Test
    public void test(){
        System.out.println(maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }
}
