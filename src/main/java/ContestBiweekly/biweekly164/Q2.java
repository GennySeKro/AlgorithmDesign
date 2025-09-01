package ContestBiweekly.biweekly164;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Q2
 * @Description: TODO
 * Author: genny
 * Date: 2025/9/1 09:34
 **/
public class Q2 {
    /*
    两个字母卡牌游戏
     */

    public int score(String[] cards, char x) {
        int sameCount = 0, firstCount = 0, secondCount = 0;
        Map<Character, Integer> counts1 = new HashMap<Character, Integer>();
        Map<Character, Integer> counts2 = new HashMap<Character, Integer>();
        for (String card : cards) {
            char c0 = card.charAt(0), c1 = card.charAt(1);
            if (c0 == x && c1 == x) {
                sameCount++;
            } else if (c0 == x) {
                firstCount++;
                counts1.put(c1, counts1.getOrDefault(c1, 0) + 1);
            } else if (c1 == x) {
                secondCount++;
                counts2.put(c0, counts2.getOrDefault(c0, 0) + 1);
            }
        }
        int maxFirstCount = 0, maxSecondCount = 0;
        Set<Map.Entry<Character, Integer>> entries1 = counts1.entrySet();
        for (Map.Entry<Character, Integer> entry : entries1) {
            maxFirstCount = Math.max(maxFirstCount, entry.getValue());
        }
        Set<Map.Entry<Character, Integer>> entries2 = counts2.entrySet();
        for (Map.Entry<Character, Integer> entry : entries2) {
            maxSecondCount = Math.max(maxSecondCount, entry.getValue());
        }
        int maxScore = 0;
        for (int firstIncrement = 0, secondIncrement = sameCount; firstIncrement <= sameCount; firstIncrement++, secondIncrement--) {
            int firstScore = getScore(firstCount + firstIncrement, Math.max(maxFirstCount, firstIncrement));
            int secondScore = getScore(secondCount + secondIncrement, Math.max(maxSecondCount, secondIncrement));
            maxScore = Math.max(maxScore, firstScore + secondScore);
        }
        return maxScore;
    }

    public int getScore(int totalCount, int maxCount) {
        return Math.min(totalCount / 2, totalCount - maxCount);
    }

    @Test
    public void test(){
        System.out.println(score(new String[]{"bb","bb"}, 'b'));
    }
}
