package ContestBiweekly.biweekly164;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Q1
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/1 09:04
 **/
public class Q1 {
    /*
    出现频率最低的数字
     */

    public int getLeastFrequentDigit(int n) {
        // 统计每个数字的出现次数
        int[] cnt = new int[10];
        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }

        // 找出现次数最小的数字
        int minC = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            int c = cnt[i];
            if (c > 0 && c < minC) {
                minC = c;
                ans = i;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(getLeastFrequentDigit(723344511));
    }
}
