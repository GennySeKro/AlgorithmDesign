package DataStructures.Dijkstra;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    /*
    在有向图中，计算某一个节点到其他节点到最短距离
     */

    static class Edge{
        //目标节点
        int to;

        //边的权重
        int weight;

        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node>{
        //当前顶点编号
        int vertax;

        //从起点到当前节点到最短距离
        int distance;

        Node(int vertax, int distance){
            this.vertax = vertax;
            this.distance = distance;
        }

        // 为了让优先队列能按 distance 升序排列（小根堆）
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public static int[] dijkstra(List<List<Edge>> graph, int start){
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        //优先队列（最小堆），自动按 distance 排序，优先处理距离最小的节点
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(start, 0));

        boolean[] visited = new boolean[n];
        while (!priorityQueue.isEmpty()){
            Node curNode = priorityQueue.poll();
            int u = curNode.vertax;

            if (visited[u]){
                continue;
            }

            visited[u] = true;

            for (Edge edge: graph.get(u)){
                int v = edge.to;
                int weight = edge.weight;

                if (!visited[v] && dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                    priorityQueue.offer(new Node(v, dist[v]));
                }
            }
        }

        //返回最终的最短距离数组
        return dist;
    }
}
