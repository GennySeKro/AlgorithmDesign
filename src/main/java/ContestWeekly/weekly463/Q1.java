package ContestWeekly.weekly463;

import org.junit.Test;

public class Q1{
    /*
    按策略买卖股票的最佳时机
     */

    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] sum = new long[n + 1];
        long[] sumSell = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (long) prices[i] * strategy[i];
            sumSell[i + 1] = sumSell[i] + prices[i];
        }

        long ans = sum[n]; // 不修改
        for (int i = k; i <= n; i++) {
            long res = sum[i - k] + sum[n] - sum[i] + sumSell[i] - sumSell[i - k / 2];
            ans = Math.max(ans, res);
        }
        return ans;
    }


    @Test
    public void testMaxProfit(){
        System.out.println(maxProfit(new int[]{5,14,16,9}, new int[]{-1,0,0,-1}, 2));
    }
}
