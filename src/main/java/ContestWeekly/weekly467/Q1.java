package ContestWeekly.weekly467;

/**
 * @ClassName: Q1
 * @Description: 完成一个任务的最早时间
 * Author: genny
 * Date: 2025/10/11 10:01
 **/
public class Q1 {

    public int earliestTime(int[][] tasks) {
        int res = Integer.MAX_VALUE;

        for (int[] task : tasks){
            res = Math.min(res, task[0] + task[1]);
        }

        return res;
    }
}
