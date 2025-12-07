package ContestWeekly.weekly469;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: Q3
 * @Description: 锯齿形数组的总数1️⃣
 * Author: genny
 * Date: 2025/11/30 18:47
 **/
public class Q3 {

    private static ArrayList<Integer> list;

    private static final int mod = 1_000_000_007;

    private static int res = 0;

    public int zigZagArrays(int n, int l, int r) {
        list = new ArrayList<>();
        dfs(l, r, n);

        return res;
    }

    private void dfs(int l, int r, int n) {
        if (list.size() == n) {
            System.out.println(list);
            res++;
            res %= mod;
            return;
        }


        for (int i = l; i <= r; i++) {
            if (isNotSame(list, i) && isNotUpOrDown(list, i)) {
                list.add(i);
                dfs(l, r, n);
                list.removeLast();
            }
        }
    }

    private boolean isNotSame(ArrayList<Integer> list, int i) {
        if (list.isEmpty()) {
            return true;
        }

        if (list.getLast() != i) {
            return true;
        }

        return false;
    }

    private boolean isNotUpOrDown(ArrayList<Integer> list, int i) {
        if (list.size() < 2) {
            return true;
        }

        int n = list.size();

        if (list.get(n - 2) < list.get(n - 1) && list.get(n - 1) < i) {
            return false;
        }

        return list.get(n - 2) <= list.get(n - 1) || list.get(n - 1) <= i;
    }


    public int zigZagArrays0(int n, int l, int r) {
        final int MOD = 1_000_000_007;
        int k = r - l + 1;

        int[] f0 = new int[k]; // 后两个数递增
        int[] f1 = new int[k]; // 后两个数递减
        Arrays.fill(f0, 1);
        Arrays.fill(f1, 1);
        long[] s0 = new long[k + 1];
        long[] s1 = new long[k + 1];

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                s0[j + 1] = s0[j] + f0[j];
                s1[j + 1] = s1[j] + f1[j];
            }
            for (int j = 0; j < k; j++) {
                f0[j] = (int) (s1[j] % MOD);
                f1[j] = (int) ((s0[k] - s0[j + 1]) % MOD);
            }
        }

        long ans = 0;
        for (int j = 0; j < k; j++) {
            ans += f0[j] + f1[j];
        }
        return (int) (ans % MOD);
    }

    @Test
    public void test() {
        System.out.println(zigZagArrays(3, 1, 3));
    }
}
