package ContestBiweekly.biweekly163;

import org.junit.Test;

public class Q1 {
    /*
    覆盖网络的最少传感器数目
     */

    public int minSensors(int n, int m, int k) {
        int size = k * 2 + 1;
        return ((n - 1) / size + 1) * ((m - 1) / size + 1);
    }


    @Test
    public void test(){
        System.out.println(minSensors(5, 5, 1));
    }

}
