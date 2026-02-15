package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: DFS
 * @Description: 计算图中每个连通块的大小
 * Author: genny
 * Date: 2026/1/12 21:25
 **/
public class DFS {

    public List<Integer> solve(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, _ -> new ArrayList<>());

        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];

            g[x].add(y);
            g[y].add(x);//无向图
        }

        //计算每个连通块的大小
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int size = dfs(i, vis, g);
                ans.add(size);
            }
        }

        return ans;
    }

    private int dfs(int x, boolean[] vis, List<Integer>[] g) {
        vis[x] = true;

        int size = 1;
        for (int y : g[x]) {
            if (!vis[y]) {
                size += dfs(y, vis, g);
            }
        }

        return size;
    }
}
