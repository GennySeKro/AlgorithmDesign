package ContestWeekly.weekly462;

import org.junit.Test;

import java.util.Arrays;

public class Q1 {
    /*
    垂直翻转子矩阵
     */

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++){
            for (int j = 0; j < k; j++){
                int temp = grid[x + i][y + j];
                grid[x + i][y + j] = grid[x + k - i - 1][y + j];
                grid[x + k - i - 1][y + j] = temp;
            }
        }

        return grid;
    }

    @Test
    public void test(){
        System.out.println(Arrays.deepToString(reverseSubmatrix(new int[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}, 1, 0, 3)));
    }
}
