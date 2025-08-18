package ContestBiweekly.biweekly162;

public class Q3 {
    /*
    最早完成陆地和水上游乐设施的时间2️⃣
     */

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(minTime(landStartTime, landDuration, waterStartTime, waterDuration),
                minTime(waterStartTime, waterDuration, landStartTime, landDuration));
    }

    private int minTime(int[] firstStartTime, int[] firstDuration, int[] secondStartTime, int[] secondDuration) {
       int res = Integer.MAX_VALUE;
       int firstFinishTime = Integer.MAX_VALUE;
       for (int i = 0; i < firstStartTime.length; i++){
           firstFinishTime = Math.min(firstFinishTime, firstStartTime[i] + firstDuration[i]);
       }

       for (int i = 0; i < secondStartTime.length; i++){
           res = Math.min(res, Math.max(secondStartTime[i], firstFinishTime) + secondDuration[i]);
       }

       return res;
    }
}
