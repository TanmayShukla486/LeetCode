package Hard;

import java.util.*;

import static java.util.Arrays.compare;

public class LeastCostPermutation {
    static class Perm {
        int[] perm;
        int cost;
        public Perm(int[] perm, int cost) {
            this.perm = perm;
            this.cost = cost;
        }
        public int[] getPerm() {
            return perm;
        }
    }

    private void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    private int calculateCost(int[] nums, int[] perm) {
        int cost = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            cost += Math.abs(perm[i] - nums[perm[(i + 1) % n]]);
        }
        return cost;
    }

    private int[] createNewPerm(int[] perm) {
        int[] newPerm = new int[perm.length];
        for (int i = 0; i < perm.length; i++) newPerm[i] = perm[i];
        return newPerm;
    }

    private void helper(int[] nums, int[] perm, int stInd, int[] cost, List<Perm> perms) {
        if (stInd >= nums.length) {
            int currCost = calculateCost(nums, perm);
            cost[0] = Math.min(cost[0], currCost);
            perms.add(new Perm(createNewPerm(perm), currCost));
        }
        for (int i = stInd; i < perm.length; i++) {
            swap(perm, stInd, i);
            helper(nums, perm, stInd + 1, cost, perms);
            swap(perm, stInd, i);
        }
    }

    private int calculateLexicalIndex(int[] perm) {
        int index = 0;
        for (int i = 0; i < perm.length; i++) {
            index += perm[i] - i;
        }
        return index;
    }

    public int[] findPermutation(int[] nums) {
        int n = nums.length;
        int[] minCost = {Integer.MAX_VALUE};
        int[] perm = new int[n];
        System.arraycopy(nums, 0, perm, 0, n);
        List<Perm> perms = new ArrayList<>();
        helper(nums, perm, 0, minCost, perms);
        List<int[]> answer = new ArrayList<>();
        for (Perm permutation : perms) if (permutation.cost == minCost[0]) answer.add(permutation.perm);
        int[][] values = new int[answer.size()][n];
        int k = 0;
        for (int[] val: answer) values[k++] = val;
        Arrays.sort(values, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                // Compare each element of the arrays lexically
                for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
                    int cmp = Integer.compare(arr1[i], arr2[i]);
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                // If all elements are equal up to the length of the shorter array,
                // then the shorter array should come first
                return Integer.compare(arr1.length, arr2.length);
            }
        });
        return values[0];
    }

        public static void main(String[] args) {
        new LeastCostPermutation().findPermutation(new int[] {1, 0, 2});
    }
}
