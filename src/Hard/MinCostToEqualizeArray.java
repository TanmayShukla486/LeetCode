package Hard;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;

public class MinCostToEqualizeArray {
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        int modulo = (int)1e9 + 7;
        int maxElement = 0;
        int n = nums.length;
        int minElement = Integer.MAX_VALUE;
        int sum = 0;
        for (int num: nums){
            sum += num;
            maxElement = Math.max(num, maxElement);
            minElement = Math.min(minElement, num);
        }
        if (cost1 * 2 <= cost2) {
            return (((maxElement * nums.length) - sum) * cost1) % modulo;
        }
        int maxGap = maxElement - minElement;
        int totalGaps = maxElement * n - sum;
        int otherGaps = totalGaps - maxGap;
        int op1 = Math.max(0, maxGap - otherGaps);
        int op2 = totalGaps - op1;
        return ((op1 + op2 % 2) * cost1 + (op2/2) * cost2) % modulo;
    }

    public static void main(String[] args) {
        System.out.println(new MinCostToEqualizeArray().minCostToEqualizeArray(new int[]{1,14,14,15}, 2, 1));
    }
}
