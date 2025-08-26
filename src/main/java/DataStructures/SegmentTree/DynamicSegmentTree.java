package DataStructures.SegmentTree;

/*
链表实现线段树，即动态开点
 */
public class DynamicSegmentTree {

    private static class Node {
        /*
        该节点区间和
         */
        long sum;

        /*
        懒加载标记
         */
        long lazyVal;

        /*
        左子树
         */
        Node left;

        /*
        右子树
         */
        Node right;

        public Node() {
            this.sum = 0L;
            this.lazyVal = 0L;
            this.left = null;
            this.right = null;
        }
    }

    /*
    根节点
     */
    private final Node root;

    /*
    区间左边界（包含）
     */
    private final int start;

    /*
    区间右边界（包含）
     */
    private final int end;

    public DynamicSegmentTree(int start, int end) {
        this.root = new Node();
        this.start = start;
        this.end = end;
    }

    /**
     * 下放懒惰标记
     * @param node 当前节点
     * @param start 当前节点左端点
     * @param end 当前节点右端点
     */
    private void pushDown(Node node, int start, int end){
        if (node.lazyVal != 0){
            int mid = (start + end) >> 1;

            if (node.left == null){
                node.left = new Node();
            }

            if (node.right == null){
                node.right = new Node();
            }

            node.left.sum += node.lazyVal * (mid - start + 1);
            node.right.sum += node.lazyVal * (end - mid);

            node.left.lazyVal += node.lazyVal;
            node.right.lazyVal += node.lazyVal;

            node.lazyVal = 0;

        }
    }

    /**
     *  更新区间
     * @param left 更新区间左端点
     * @param right 更新区间右端点
     * @param val 增加点值
     */
    public void updateRange(int left, int right, long val){
        updateRange(root, start, end, left, right, val);
    }

    /**
     * 辅助更新区间
     * @param node 当前节点
     * @param start 当前节点左端点
     * @param end 当前节点右端点
     * @param left 查询更新左端点
     * @param right 查询更新右端点
     * @param val 更新值
     */
    private void updateRange(Node node, int start, int end, int left, int right, long val) {
        if (left > end || right < start){
            return;
        }

        if (left <= start && right >= end){
            node.sum += val * (end - start + 1);
            node.lazyVal += val;
            return;
        }

        pushDown(node, start, end);
        int mid = (start + end) >> 1;

        if (node.left == null){
            node.left = new Node();
        }

        if (node.right == null){
            node.right = new Node();
        }

        updateRange(node.left, start, mid, left, right, val);
        updateRange(node.right, mid + 1, end, left, right, val);

        node.sum = node.left.sum + node.right.sum;
    }

    /**
     *  查询区间和
     * @param left 查询区间左端点
     * @param right 查询区间右端点
     * @return 区间和
     */
    public long queryRange(int left, int right){
        return queryRange(root, start, end, left, right);
    }

    /**
     * 辅助区间查询
     * @param node 当前节点
     * @param start 当前节点左端点
     * @param end 当前节点右端点
     * @param left 查询区间左端点
     * @param right 查询区间右端点
     * @return 查询区间和
     */
    private long queryRange(Node node, int start, int end, int left, int right){
        if (node == null || left > end || right < start){
            return 0;
        }

        if (left <= start && right >= end){
            return node.sum;
        }

        pushDown(node, start, end);
        int mid = (start + end) >> 1;

        long leftSum = queryRange(node.left, start, mid, left, right);
        long rightSum = queryRange(node.right, mid + 1, end, left, right);

        return leftSum + rightSum;
    }

    /**
     * 单点值更新
     * @param index 目标节点
     * @param val 增加值
     */
    public void updatePoint(int index, long val){
        updateRange(index, index, val);
    }

    /**
     * 单点值查询
     * @param index 目标节点
     * @return 查询值
     */
    public long queryPoint(int index){
        return queryRange(index, index);
    }

}
