package ContestWeekly.weekly466;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: Q3
 * @Description: 碗子数组的数目
 * Author: genny
 * Date: 2025/10/10 11:12
 **/
public class Q3 {

    public long bowlSubarrays(int[] nums) {
        long ans = 0L;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++){
            int x = nums[i];
            while (!deque.isEmpty() && nums[deque.peek()] < x){
                if (i - deque.pop() > 1){
                    ans++;
                }
            }

            if (!deque.isEmpty() && i - deque.peek() > 1){
                ans++;
            }
            deque.push(i);
        }

        return ans;
    }
}
