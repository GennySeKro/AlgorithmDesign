package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Q2316
 * @Description: 统计无向图中无法互相到达点对数
 * Author: genny
 * Date: 2026/2/15 17:06
 **/
public class Q2316 {

    public long countPairs(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, _ -> new ArrayList<>());

        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        long ans = 0L;
        for (int i = 0, total = 0; i < n; i++) {
            if (!vis[i]) {
                int size = dfs(i, g, vis);
                ans += (long) size * total;
                total += size;
            }
        }

        return ans;
    }

    private int dfs(int x, List<Integer>[] g, boolean[] vis) {
        vis[x] = true;
        int size = 1;
        for (int y : g[x]) {
            if (!vis[y]) {
                size += dfs(y, g, vis);
            }
        }

        return size;
    }


}
