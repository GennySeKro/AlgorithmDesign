package DFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName: Q841
 * @Description: 钥匙和房间
 * Author: genny
 * Date: 2026/2/15 16:47
 **/
public class Q841 {

    private void dfs(int key, List<List<Integer>> rooms, List<Boolean> visited) {
        if (visited.get(key)) {
            return;
        }
        visited.set(key, true);
        for (int k : rooms.get(key)) {
            // 深度优先搜索遍历
            dfs(k, rooms, visited);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Boolean> visited = new ArrayList<Boolean>() {{
            for (int i = 0; i < rooms.size(); i++) {
                add(false);
            }
        }};
        dfs(0, rooms, visited);
        //检查是否都访问到了
        for (boolean flag : visited) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        // 示例1: [[1],[2],[3],[]]
        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(List.of(1, 3));      // 房间0有钥匙1
        rooms1.add(List.of(3, 0, 1));      // 房间1有钥匙2
        rooms1.add(List.of(2));      // 房间2有钥匙3
        rooms1.add(List.of(0));// 房间3没有钥匙

        System.out.println("示例1结果: " + canVisitAllRooms(rooms1)); // 应该返回true
    }
}
