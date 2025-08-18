package ContestWeekly.weekly461;

import org.junit.Test;

public class Q3 {
    /*
    变为活跃时间的最小时间
     */

    public int minTime(String s, int[] order, int k) {
        int n = s.length();
        if ((long) n * (n + 1) / 2 < k) {
            return -1;
        }
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isActive(order, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isActive(int[] order, int k, int t) {
        int n = order.length;
        boolean[] asterisk = new boolean[n];
        for (int i = 0; i <= t; i++) {
            asterisk[order[i]] = true;
        }
        long validCount = 0;
        int lastAsterisk = -1;
        for (int i = 0; i < n; i++) {
            if (asterisk[i]) {
                lastAsterisk = i;
            }
            validCount += lastAsterisk + 1;
            if (validCount >= k) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(minTime("ct1", new int[]{2, 1, 0}, 6));
    }
}
