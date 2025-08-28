package DataStructures.SegmentTree.exam;

/**
 * @ClassName: Q933
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/27 14:47
 **/
public class Q933 {
    /*
    最近的请求次数
     */

    static class Node {
        Node left, right;
        int val, add;
    }

    private final Node root = new Node();

    private static final int n = 1_000_000_000;

    public int ping(int t) {
        update(root, 0, n, t, t, 1);
        return query(root, 0, n, Math.max(t - 3000, 0), t);
    }

    private int query(Node node, int start, int end, int left, int right) {
        if (left <= start && right >= end){
            return node.val;
        }

        int mid = (start + end) >> 1, ans = 0;
        pushDown(node);

        if (left <= mid){
            ans += query(node.left, start, mid, left, right);
        }

        if (right > mid){
            ans += query(node.right, mid + 1, end, left, right);
        }

        return ans;

    }

    private void update(Node node, int start, int end, int left, int right, int val) {
        if (left <= start && right >= end){
            node.val += val;
            node.add += val;
            return ;
        }

        int mid = (start + end) >> 1, ans = 0;
        pushDown(node);

        if (left <= mid){
            update(node.left, start, mid, left, right, val);
        }

        if (right > mid){
            update(node.right, mid + 1, end, left, right, val);
        }

        node.val = node.left.val + node.right.val;
    }

    private void pushDown(Node node) {
        if (node.left == null){
            node.left = new Node();
        }

        if (node.right == null){
            node.right = new Node();
        }

        if (node.add == 0){
            return;
        }

        node.left.val += node.add;
        node.right.val += node.add;

        node.left.add += node.add;;
        node.right.add += node.add;

        node.add = 0;
    }
}
