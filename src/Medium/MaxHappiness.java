package Medium;

import java.util.Arrays;

public class MaxHappiness {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0L;
        int curr = 0;
        for (int i = happiness.length - 1; i >= 0 && curr < k; i--, curr++) {

            sum += Math.max((long)happiness[i] - curr, 0L);
        }
        return sum;
    }

    public static void main(String[] args) {
        new MaxHappiness().maximumHappinessSum(new int[]{12,1,42}, 3);
    }
}
