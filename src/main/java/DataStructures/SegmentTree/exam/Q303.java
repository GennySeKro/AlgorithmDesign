package DataStructures.SegmentTree.exam;

/**
 * @ClassName: Q303
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/26 08:34
 **/
public class Q303 {
    /*
    区域和检索-数组不可变
     */

    class NumArray {

        private int[] tree;

        private int n;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0){
                this.tree = new int[0];
                this.n = 0;
                return;
            }

            this.n = nums.length;;
            this.tree = new int[4 * n];
            buildTree(nums, 1, 0, n - 1);
        }

        private void buildTree(int[] nums, int node, int start, int end) {
            if (start == end){
                tree[node] = nums[start];
                return;
            }

            int mid = start + (end - start) / 2;

            buildTree(nums, 2 * node, start, mid);
            buildTree(nums, 2 * node + 1, mid + 1, end);

            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

        public int sumRange(int left, int right) {
            return queryRange(1, 0, n - 1, left, right);
        }

        private int queryRange(int node, int start, int end, int left, int right) {
            if (right < start || left > end){
                return 0;
            }

            if (right >= end && left <= start){
                return tree[node];
            }

            int mid = start + (end - start) / 2;

            int leftSum = queryRange(2 * node, start, mid, left, right);
            int rightSum = queryRange(2 * node + 1, mid + 1, end, left, right);

            return leftSum + rightSum;
        }
    }
}
