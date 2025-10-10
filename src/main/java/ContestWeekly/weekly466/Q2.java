package ContestWeekly.weekly466;

/**
 * @ClassName: Q2
 * @Description: 转换字符串的最小操作次数
 * Author: genny
 * Date: 2025/10/10 11:03
 **/
public class Q2 {

    public int minOperations(String s) {
        int[] charCount = new int[27];
        for (int i = 0; i < s.length(); i++){
            charCount[s.charAt(i) - 'a']++;
        }

        int res = 0;
        for (int i = 1; i < charCount.length - 1; i++){
            if (charCount[i] != 0){
                res++;
            }

            charCount[i + 1] += charCount[i];
        }

        return res;
    }
}
