package DataStructures.SegmentTree;

import org.junit.Test;

/**
 * @ClassName: DynamicSegmentTreeTest
 * @Description: TODO
 * Author: genny
 * Date: 2025/8/25 16:20
 **/
public class DynamicSegmentTreeTest {

    @Test
    public void test(){
        // 假设我们关心的区间很大，比如 [1, 1_000_000_000]
        DynamicSegmentTree dst = new DynamicSegmentTree(1, 1_000_000_000);

        // 但实际操作很少
        dst.updateRange(100, 200, 5);     // [100, 200] 区间加 5
        dst.updateRange(150, 300, 10);    // [150, 300] 区间加 10
        dst.updatePoint(250, 15);         // 位置 250 加 15

        System.out.println("查询 [100, 150] 的和: " + dst.queryRange(100, 150)); // 5 * 51 = 255
        System.out.println("查询 [150, 200] 的和: " + dst.queryRange(150, 200)); // (5+10) * 51 = 765
        System.out.println("查询 [250, 250] 的和: " + dst.queryPoint(250));       // 10 + 15 = 25
        System.out.println("查询 [400, 500] 的和: " + dst.queryRange(400, 500)); // 0 (未操作过)
    }
}
