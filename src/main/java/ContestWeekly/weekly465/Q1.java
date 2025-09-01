package ContestWeekly.weekly465;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName: Q1
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/1 14:48
 **/
public class Q1 {
    /*
    重排完成任务
     */

    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : friends){
            set.add(x);
        }
        int[] ans = new int[friends.length];
        int index = 0;
        for (int i = 0; i < order.length; i++){
            if (set.contains(order[i])){
                ans[index++] = order[i];
            }
        }

        return ans;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(recoverOrder(new int[]{3, 1, 2, 5, 4}, new int[]{1, 3, 4})));
    }
}
