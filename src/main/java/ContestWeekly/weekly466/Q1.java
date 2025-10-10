package ContestWeekly.weekly466;

/**
  *@ClassName: Q1
  *@Description: TODO
  *Author: genny
  *Date: 2025/10/10 10:57
  **/
public class Q1 {
    /*
    数组元素相等的最小操作次数
     */

    public int minOperations(int[] nums) {
        if (nums.length == 1){
            return 0;
        }

        int res = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] != nums[i + 1]){
                res = 1;
                break;
            }
        }

        return res;
    }
}
