package DataStructures.SegmentTree.exam;

public class Q307 {
    /*
    区域和检索-数组可修改
     */

    class NumArray {

        //定义树形节点
        class Node{

            Node left, right;

            //[left,right]区间和
            int val;

            /*
            lazy load mode
            [left,right]区间增加add，
             */
            int add;
        }

        private int n;
        private Node root = new Node();

        /*
        初始化线段树
         */
        public NumArray(int[] nums) {
            n = nums.length - 1;
            for (int i = 0; i <= n; i++){
                update(root, 0, n, i, i, nums[i]);
            }
        }

        /*
        索引index的节点增加val
         */
        public void update(int index, int val) {
                update(root, 0, n, index, index, val);
        }

        /*
        查询[left,right]的区间和
         */
        public int sumRange(int left, int right) {
            return query(root, 0, n, left, right);
        }

        /*
        在[start,end]区间内给[left,right]区间增加val
         */
        private void update(Node node, int start, int end, int left, int right, int val){
            if (left <= start && right >= end){
                node.val = (end - start + 1) * val;
                node.add = val;
                return;
            }

            int mid = (start + end) >> 1;
            pushDown(node, mid - start + 1, end - mid);
            if (left <= mid){
                update(node.left, start, mid, left, right, val);
            }

            if (right > mid){
                update(node.right, mid + 1, end, left, right, val);
            }

            pushUp(node);
        }

        private int query(Node node, int start, int end, int left, int right){
            if (left <= start && right >= end){
                return node.val;
            }

            int mid = (start + end) >> 1;
            int ans = 0;

            pushDown(node, mid - start + 1, end - mid);

            if (left <= mid){
                ans += query(node.left, start, mid, left, right);
            }

            if (right > mid){
                ans += query(node.right, mid + 1, end, left, right);
            }

            return ans;
        }

        private void pushUp(Node node){
            node.val = node.left.val + node.right.val;
        }

        private void pushDown(Node node, int leftNum, int rightNum){
            //动态开节点
            if (node.left == null){
                node.left = new Node();
            }

            if (node.right == null){
                node.right = new Node();
            }

            if (node.add == 0){
                return;
            }

            node.left.val = node.add * leftNum;
            node.right.val = node.add * rightNum;

            node.left.add = node.add;;
            node.right.add = node.add;

            node.add = 0;
        }
    }
}
