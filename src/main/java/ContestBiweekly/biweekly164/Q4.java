package ContestBiweekly.biweekly164;

/**
 * @ClassName: Q4
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/1 10:59
 **/
public class Q4 {
    /*
    使二进制字符串全为 1 的最少操作次数
     */

    public int minOperations(String s, int k) {
        int n = s.length();
        int zeroNum = 0;
        for (int i = 0; i < n; i++){
            if (s.charAt(i) == '0'){
                zeroNum++;
            }
        }

        if (zeroNum == 0){
            return 0;
        }

        if (n == k){
            return zeroNum == n ? 1 : -1;
        }

        int ans = Integer.MAX_VALUE;

        if (zeroNum % 2 == 0){
            int m = Math.max((zeroNum + k - 1) / k, (zeroNum + n - k - 1) / (n - k));
            ans = m + m % 2;
        }

        if (zeroNum % 2 == k % 2){
            int m = Math.max((zeroNum + k - 1) / k, (n - zeroNum + n - k - 1) / (n - k));
            ans = Math.min(ans, m | 1);
        }

        return ans < Integer.MAX_VALUE ? ans : -1;
    }
}
