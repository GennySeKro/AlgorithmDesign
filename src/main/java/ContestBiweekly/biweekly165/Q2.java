package ContestBiweekly.biweekly165;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName: Q2
 * @Description: 使库存平衡的最小丢弃次数
 * Author: genny
 * Date: 2025/10/11 09:03
 **/
public class Q2 {

    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrivals.length; i++){

            if (map.getOrDefault(arrivals[i], 0) == m){
                arrivals[i] = 0;
                ans++;
            }else {
                map.put(arrivals[i], map.getOrDefault(arrivals[i], 0) + 1);
            }

            if (i - w + 1 >= 0){
                if (arrivals[i - w + 1] != 0){
                    map.put(arrivals[i - w + 1], map.get(arrivals[i - w + 1]) - 1);
                }
            }
        }

        return ans;
    }

    @Test
    public void test(){
        System.out.println(minArrivalsToDiscard(new int[]{7,3,9,9,7,3,5,9,7,2,6,10,9,7,9,1,3,6,2,4,6,2,6,8,4,8,2,7,5,6}, 10, 1));
    }
}
