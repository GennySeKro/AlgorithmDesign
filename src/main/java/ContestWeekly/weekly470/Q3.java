package ContestWeekly.weekly470;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Q3
 * @Description: 移除K-平衡子字符串
 * Author: genny
 * Date: 2025/12/7 19:41
 **/
public class Q3 {

    public String removeSubstring(String s, int k) {
        List<int[]> st = new ArrayList<>();
        for (char b : s.toCharArray()) {
            if (!st.isEmpty() && st.getLast()[0] == b) {
                st.getLast()[1]++;
            } else {
                st.add(new int[]{b, 1});
            }

            if (b == ')' && st.size() > 1 && st.getLast()[1] == k && st.get(st.size() - 2)[1] >= k) {
                st.removeLast();
                st.getLast()[1] -= k;
                if (st.getLast()[1] == 0) {
                    st.removeLast();
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int[] p : st) {
            ans.repeat(p[0], p[1]);
        }

        return ans.toString();

    }
}
