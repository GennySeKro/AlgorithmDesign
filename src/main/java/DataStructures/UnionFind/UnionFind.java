package DataStructures.UnionFind;

public class UnionFind {
    //父节点数组
    private final int[] parent;

    //秩 -> 树到高度上界
    private final int[] rank;

    //连通分量个数
    private int count;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.count = n;

        //初始化，每个节点到父节点都是自己
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    //查找指定节点的父节点 + 路径压缩优化
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    //合并两个集合 + 按秩合并
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[y]) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }

        count--;
    }

    //判断两个元素是否属于同一个连通分量
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    //获取当前联通分量个数
    public int getCount() {
        return count;
    }


}
