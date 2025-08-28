package DataStructures.SegmentTree.exam;

/**
 * @ClassName: Q715
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/27 11:58
 **/
public class Q715 {
    /*
    Range模块
     */

    class RangeModule {

        static class Node {
            Node left, right;
            boolean isCovered;
            int add;
        }

        private final Node root;

        private static final int n = 1_000_000_000;

        public RangeModule() {
            this.root = new Node();
        }

        public void addRange(int left, int right) {
            update(root, 1, n, left, right - 1, 1);
        }

        public boolean queryRange(int left, int right) {
            return query(root, 1, n, left, right - 1);
        }

        public void removeRange(int left, int right) {
            update(root, 1, n, left, right - 1, -1);
        }

        private void update(Node node, int start, int end, int left, int right, int val) {
            if (left <= start && right >= end){
                node.isCovered = val == 1;
                node.add = val;
                return;
            }

            int mid = start + (end - start) >> 1;
            pushDown(node);
            if (left <= mid){
                update(node.left, start, mid, left, right, val);
            }

            if (right > mid){
                update(node.right, mid + 1, end, left, right, val);
            }

            node.isCovered = node.left.isCovered && node.right.isCovered;
        }

        private boolean query(Node node, int start, int end, int left, int right) {
            if (left <= start && right >= end){
                return node.isCovered;
            }

            int mid = start + (end - start) >> 1;
            pushDown(node);

            boolean ans = true;

            if (left <= mid){
                ans &= query(node.left, start, mid, left, right);
            }

            if (right > mid){
                ans &= query(node.right, mid + 1, end, left, right);
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

            node.left.isCovered = node.add == 1;
            node.right.isCovered = node.add == 1;

            node.left.add = node.add;
            node.right.add = node.add;

            node.add = 0;
        }
    }
}
