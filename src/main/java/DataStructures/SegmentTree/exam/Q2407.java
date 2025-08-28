package DataStructures.SegmentTree.exam;

/**
 * @ClassName: Q2407
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/27 16:41
 **/
public class Q2407 {
    /*
    最长递增子序列2️⃣
     */

    static class Node {
        Node left, right;
        int val, add;
    }

    private static final int n = 1_000_00;

    private final Node root = new Node();

    public int lengthOfLIS(int[] nums, int k) {
        int ans = 0;

        for (int num : nums){
            int cnt = query(root, 0, n, Math.max(0, num - k), num - 1) + 1;

            update(root, 0, n, num, num, cnt);

            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    private void update(Node node, int start, int end, int left, int right, int val) {
        if (left <= start && right >= end){
            node.val = val;
            node.add = val;
            return;
        }

        pushDown(node);

        int mid = (start + end) >> 1, ans = 0;

        if (left <= mid){
            update(node.left, start, mid, left, right, val);
        }

        if (right > mid){
          update(node.right, mid + 1, end, left, right, val);
        }

        node.val = Math.max(node.left.val, node.right.val);
    }

    private int query(Node node, int start, int end, int left, int right) {
        if (left <= start && right >= end){
            return node.val;
        }

        pushDown(node);

        int mid = (start + end) >> 1, ans = 0;

        if (left <= mid){
            ans = query(node.left, start, mid, left, right);
        }

        if (right > mid){
            ans = Math.max(ans, query(node.right, mid + 1, end, left, right));
        }

        return ans;
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

        node.left.val = node.add;
        node.right.val = node.add;

        node.left.add = node.add;
        node.right.add = node.add;

        node.add = 0;
    }
}
