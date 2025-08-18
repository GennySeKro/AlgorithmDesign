package ContestBiweekly.biweekly162;

public class Q1 {
    /*
    最早完成陆地和水上游乐的时间1️⃣
     */

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(minTime(landStartTime, landDuration, waterStartTime, waterDuration),
                minTime(waterStartTime, waterDuration, landStartTime, landDuration));
    }

    private int minTime(int[] firstStartTime, int[] firstDuration, int[] secondStartTime, int[] secondDuration) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < firstStartTime.length; i++){
            for (int j = 0; j < secondStartTime.length; j++){
                if (firstStartTime[i] + firstDuration[i] >= secondStartTime[j]){
                    res = Math.min(res, firstStartTime[i] + firstDuration[i] + secondDuration[j]);
                }else {
                    res = Math.min(res, secondStartTime[j] + secondDuration[j]);
                }
            }
        }

        return res;
    }

}
