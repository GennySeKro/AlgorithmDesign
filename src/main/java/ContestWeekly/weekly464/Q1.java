package ContestWeekly.weekly464;

public class Q1 {
    /*
    奇数和与偶数和点最大公约数
     */

    public int gcdOfOddEvenSums(int n) {
        int oddSum = n * n, evenSum = n * (n + 1);

        int res = 1;
        for (int i = 1; i < oddSum / 2 + 1; i++){
            if (oddSum % i == 0 && evenSum % i == 0){
                res = i;
            }
        }

        return res;
    }
}
