package DFS;

/**
 * @ClassName: Q547
 * @Description: 省份数量
 * Author: genny
 * Date: 2026/1/15 21:41
 **/
public class Q547 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int res = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                dfs(i, used, isConnected);
                res++;
            }
        }

        return res;
    }

    private void dfs(int index, boolean[] used, int[][] isConnected) {
        used[index] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[index][i] == 1 && !used[i]) {
                dfs(i, used, isConnected);
            }
        }
    }
}
