package DataStructures.SegmentTree.exam;

import java.rmi.dgc.VMID;

/**
 * @ClassName: Q300
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/27 17:19
 **/
public class Q300 {
    /*
    最长递增子序列1️⃣
     */

    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        for (int num : nums){
            int x = query(root, -n, n, -10001, num - 1) + 1;
            update(root, -n, n, num, num, x);
            ans = Math.max(ans, x);
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

        int mid = start + ((end - start) >> 1);

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

        int mid = start + ((end - start) >> 1), ans = 0;

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

    static class Node {
        Node left, right;
        int val, add;
    }

    private final Node root = new Node();

    private static final int n = 1_000_00;


}
