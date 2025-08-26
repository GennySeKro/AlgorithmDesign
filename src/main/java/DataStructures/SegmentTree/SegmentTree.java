package DataStructures.SegmentTree;

/**
 * @ClassName: SegmentTree
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/26 09:30
 **/
public class SegmentTree {
    /*
    已知数组构建线段树
     */

    /*
    原始数组，便于单点更新
     */
    private final int[] originalArray;

    /*
    线段树数组
     */
    private final long[] segmentTree;

    private final int arrayLen;

    public SegmentTree(int[] input){
        if (input == null || input.length == 0){
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        this.originalArray = input.clone();
        this.arrayLen = input.length;

        this.segmentTree = new long[4 * arrayLen];

        buildTree(1, 0, arrayLen - 1);
    }

    /**
     * 从数组构建线段树
     * @param node 当前节点
     * @param start 当前区间左端点
     * @param end 当前区间右端点
     */
    private void buildTree(int node, int start, int end) {
        //构建叶子节点
        if (start == end){
            segmentTree[node] = originalArray[start];
            return;
        }

        int mid = start + (end - start) >> 1;

        //递归构造左右子树
        buildTree(2 * node, start, mid);
        buildTree(2 * node + 1, mid + 1, end);

        //合并左右子树的区间和
        segmentTree[node] = segmentTree[2 * node] + segmentTree[2 * node + 1];
    }

    /**
     * 查询区间和
     * @param left 查询区间左端点
     * @param right 查询区间右端点
     * @return 查询结果
     */
    public long query(int left, int right){
        if (left < 0 || right > arrayLen || left > right){
            throw new IllegalArgumentException("Invalid query range");
        }

        return queryRange(1, 0, arrayLen - 1, left, right);
    }

    /**
     * 辅助查询函数
     * @param node 当前节点
     * @param start 当前区间左端点
     * @param end 当前区间右端点
     * @param left 查询区间左端点
     * @param right 查询区间右端点
     * @return 查询区间和
     */
    private long queryRange(int node, int start, int end, int left, int right) {
        //当前区间不包括查询区间
        if (left > end || right < start){
            return 0L;
        }

        //当前区间处于查询区间内
        if (left <= start && right >= end){
            return segmentTree[node];
        }

        //查询区间与当前区间重合
        int mid = start + (end - start) >> 1;

        //递归查询区间和
        long leftSum = queryRange(2 * node, start, mid, left, right);
        long rightSum = queryRange(2 * node + 1, mid + 1, end, left, right);

        return leftSum + rightSum;
    }

    /**
     * 单点更新
     * @param index 待更新节点索引
     * @param value 更新值
     */
    public void updatePoint(int index, int value){
        if (index < 0 || index >= arrayLen){
            throw new IllegalArgumentException("Index out of bounds");
        }

        originalArray[index] = value;

        updatePointInTree(1, 0, arrayLen - 1, index, value);
    }

    /**
     * 单点更新辅助函数
     * @param node 当前节点
     * @param start 当前区间左端点
     * @param end 当前区间右端点
     * @param index 待更新节点索引
     * @param value 待更新值
     */
    private void updatePointInTree(int node, int start, int end, int index, int value) {
        if (start == end){
            //递归找到目标节点
            segmentTree[node] = value;
        }else {
            int mid = start + (end - start) >> 1;

            //根据区间判断待更新节点在左子树还是右子树
            if (index <= mid){
                updatePointInTree(2 * node, start, mid, index, value);
            }else {
                updatePointInTree(2 * node + 1, mid + 1, end, index, value);
            }

            //更新父节点的区间和
            segmentTree[node] = segmentTree[2 * node] + segmentTree[2 * node + 1];
        }
    }


}
