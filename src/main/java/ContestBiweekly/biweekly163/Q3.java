package ContestBiweekly.biweekly163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q3 {
    /*
    边反转的最小路径总成本
     */

    public int minCost(int n, int[][] edges) {
        List<int[]>[] adjacentArr = new List[n];
        for (int i = 0; i < n; i++) {
            adjacentArr[i] = new ArrayList<int[]>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adjacentArr[u].add(new int[]{v, w});
            adjacentArr[v].add(new int[]{u, 2 * w});
        }
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int curr = pair[0], distance = pair[1];
            if (distances[curr] < distance) {
                continue;
            }
            for (int[] adjacent : adjacentArr[curr]) {
                int next = adjacent[0], weight = adjacent[1];
                if (distances[next] > distance + weight) {
                    distances[next] = distance + weight;
                    pq.offer(new int[]{next, distances[next]});
                }
            }
        }
        return distances[n - 1] != Integer.MAX_VALUE ? distances[n - 1] : -1;
    }
}
