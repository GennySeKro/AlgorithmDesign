package DataStructures.SegmentTree.exam;

/**
 * @ClassName: Q729
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/26 15:33
 **/
public class Q729 {
    /*
    我的日程安排1️⃣
     */

    class MyCalendar {

        private Node root;

        private final int n = 1_000_000_000;

        public MyCalendar() {
            this.root = new Node();
        }

        public boolean book(int startTime, int endTime) {
            if (query(root, 0, n, startTime, endTime - 1) != 0){
                return false;
            }

            update(root, 0, n, startTime, endTime - 1, 1);
            return true;
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

        private void update(Node node, int start, int end, int left, int right, int val) {
            if (left <= start && right >= end){
                node.val += val;
                node.add += val;
                return;
            }

            pushDown(node);

            int mid = (start + end) >> 1;

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

            node.left.val += node.add;
            node.right.val += node.add;

            node.left.add += node.add;
            node.right.add += node.add;

            node.add = 0;
        }

        static class Node {

            Node left, right;

            int val, add;
        }
    }
}
