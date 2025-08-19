package ContestWeekly.weekly463;

public class Q2 {
    /*
    区间乘法查询后的异或1️⃣
     */

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int i = 0 ; i < queries.length; i++){
            int idx = queries[i][0];
            while (idx <= queries[i][1]){
                long temp = (long) nums[idx] * queries[i][3];
                nums[idx] = Math.toIntExact(temp % 1000000007);
                idx += queries[i][2];
            }
        }

        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            res ^= nums[i];
        }

        return res;
    }
}
