package DataStructures.SegmentTree.exam;

/**
 * @ClassName: Q732
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/27 10:45
 **/
public class Q732 {
    /*
    我的日程安排表3️⃣
     */

    class MyCalendarThree {

        static class Node {
            Node left, right;
            int val, add;
        }
        private final Node root = new Node();

        public MyCalendarThree() {
        }

        public int book(int startTime, int endTime) {
            int n = 1_000_000_000;
            update(root, 0, n, startTime, endTime - 1, 1);
            return root.val;
        }

        private void update(Node node, int start, int end, int left, int right, int val) {
            if (start >= left && end <= right){
                node.val += val;
                node.add += val;
                return;
            }

            //int mid = (start + end) >> 1;
            //todo
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

            node.left.val += node.add;
            node.right.val += node.add;

            node.left.add += node.add;
            node.right.add += node.add;

            node.add = 0;
        }
    }
}
