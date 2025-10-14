package ContestWeekly.weekly468;

/**
 * @ClassName: Q1
 * @Description: 偶数的按位或运算
 * Author: genny
 * Date: 2025/10/13 14:52
 **/
public class Q1 {

    public int evenNumberBitwiseORs(int[] nums) {
        int res = 0;
        for (int num : nums){
            if (num % 2 == 0){
                res |= num;
            }
        }

        return res;
    }
}
