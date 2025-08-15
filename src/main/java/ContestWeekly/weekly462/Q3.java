package ContestWeekly.weekly462;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q3 {
    /*
    最优激活顺序得到的最大总和
     */

    public long maxTotal(int[] value, int[] limit) {
        int n = value.length;
        List<Integer>[] groups = new ArrayList[n + 1];
        Arrays.setAll(groups, _ -> new ArrayList<>());
        for (int i = 0; i < n; i++){
            groups[limit[i]].add(value[i]);
        }

        long ans = 0;
        for (int lim = 1; lim <= n; lim++){
            List<Integer> temp = groups[lim];
            if (lim < temp.size()){
                temp.sort(Comparator.reverseOrder());
                temp = temp.subList(0, lim);
            }

            for (int x : temp){
                ans += x;
            }
        }

        return ans;
    }
}
