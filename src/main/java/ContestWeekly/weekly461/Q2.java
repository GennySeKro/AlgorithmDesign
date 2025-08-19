package ContestWeekly.weekly461;

import org.junit.Test;

public class Q2 {
    /*
    平衡装运的最大数量
     */

    public int maxBalancedShipments(int[] weight) {
        int max = weight[0];
        int ans = 0;

        for (int i = 1; i < weight.length; i++){
            max = Math.max(max, weight[i]);
            if (weight[i] < max){
                ans++;
                max = Integer.MIN_VALUE;
            }
        }

        return ans;
    }

    @Test
    public void testMaxBalancedShipments(){
        System.out.println(maxBalancedShipments(new int[]{1, 2}));
    }
}
