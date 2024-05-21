package Medium;

import java.util.Arrays;

public class PartitionToKEqualSubsets {
    private boolean helper(int[] nums, int i, int[] parts, int target, int[][] dp) {
        if (i == -1) {
            for (int k = 1; k < parts.length; k++)
                if (parts[k] != parts[k - 1]) return false;
            return true;
        }
        for (int k = 0; k < parts.length; k++) {
            parts[k] += nums[i];
            if (parts[k] <= target) {
                if (dp[k][parts[k]] == 0) {
                    parts[k] -= nums[i];
                    continue;
                }
                dp[k][parts[k]] = helper(nums, i - 1, parts, target, dp) ? 1 : 0;
                if (dp[k][parts[k]] == 1) return true;
            }
            parts[k] -= nums[i];
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int val: nums) sum += val;
        if (sum % k != 0) return false;
        int[][] dp = new int[k][sum / k + 1];
        for (int i = 0; i < k; i++) Arrays.fill(dp[i], -1);
        return helper(nums, nums.length - 1, new int[k], sum/k, dp);
    }

    public static void main(String[] args) {
        new PartitionToKEqualSubsets().canPartitionKSubsets(new int[]
                {3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269}, 5);
    }
}
