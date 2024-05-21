package Medium;

public class MaxEnergy {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] ansEnergy = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i + k < n) {
                ansEnergy[i] = ansEnergy[i + k] + energy[i];
            } else ansEnergy[i] = energy[i];
        }
        int max = Integer.MIN_VALUE;
        for (int val: ansEnergy) max = Math.max(max, val);
        // for (int i = n - 1; i >= n - k; i--)
        //     max = Math.max(max, energy[i]);
        return max;
    }

    public static void main(String[] args) {
        new MaxEnergy().maximumEnergy(new int[]{-2,-3,-1}, 2);
    }
}
