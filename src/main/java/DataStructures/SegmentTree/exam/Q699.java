package DataStructures.SegmentTree.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Q699
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/27 15:04
 **/
public class Q699 {
    /*
    掉落的方块
     */

    class Solution {

        static class Node {
            Node left, right;
            int val, add;
        }

        private final Node root = new Node();

        private static final int n = 1_000_000_000;


        public List<Integer> fallingSquares(int[][] positions) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int[] position : positions){
                int x = query(root, 0, n, position[0], position[0] + position[1] - 1);
                update(root, 0, n, position[0], position[0] + position[1] - 1, x + position[1]);
                ans.add(root.val);
            }

            return ans;
        }

        private void update(Node node, int start, int end, int left, int right, int val) {
            if (left <= start && right >= end){
                node.val = val;
                node.add = val;
                return;
            }

            int mid = (start + end) >> 1;

            pushDown(node);

            if (left <= mid){
                update(node.left, start, mid, left, right, val);
            }

            if (right > mid){
                update(node.right, mid + 1, end, left, right, val);
            }

            node.val = Math.max(node.left.val, node.right.val);
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

        private int query(Node node, int start, int end, int left, int right){
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
    }
}
