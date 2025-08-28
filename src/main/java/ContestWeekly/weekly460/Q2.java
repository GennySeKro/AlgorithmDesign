package ContestWeekly.weekly460;

import org.junit.Test;

/**
 * @ClassName: Q2
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/28 09:52
 **/
public class Q2 {
    /*
    插入一个字母的最大子序列数
     */

    public long numOfSubsequences(String s) {
        long[] numL = new long[s.length() + 1];
        long[] numC = new long[s.length() + 1];
        long[] numT = new long[s.length() + 1];

        for (int i = 0; i < s.length(); i++){
            numL[i + 1] = numL[i] + (s.charAt(i) == 'L' ? 1 : 0);
            numC[i + 1] = numC[i] + (s.charAt(i) == 'C' ? 1 : 0);
        }

        for (int i = s.length() - 1; i >= 0; i--){
            numT[i] = numT[i + 1] + (s.charAt(i) == 'T' ? 1 : 0);
        }

        long res = 0L, resC = 0L, resL = 0L, resT = 0L;

        //遍历插入 C 带来的增量
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'C'){
                res += numL[i + 1] * numT[i];
            }
            resC = Math.max(resC, numL[i + 1] * numT[i]);
        }

        //计算 LC 子序列，即在最后一个位置插入 T
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'C'){
                resT += numL[i + 1];
            }
        }

        //计算 CT 子序列，即在开头插入 L
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'C'){
                resL += numT[i];
            }
        }

        return res + Math.max(resC, Math.max(resL, resT));
    }

    @Test
    public void test(){
        System.out.println(numOfSubsequences("LMCT"));
    }
}
