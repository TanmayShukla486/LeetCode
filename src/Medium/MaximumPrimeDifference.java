package Medium;

import java.util.HashSet;
import java.util.Set;

public class MaximumPrimeDifference {

    // Taking sets to reduce complexity of calculating prime for repeated values
    private Set<Integer> primeNums = new HashSet<>();
    private Set<Integer> notPrime = new HashSet<>();

    /**Function to check if the current number is prime or not*/
    private boolean isPrime(int n) {
        if (n == 1) return false;
        if (primeNums.contains(n)) return true;
        else if (notPrime.contains(n)) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                notPrime.add(n);
                return false;
            }
        }
        primeNums.add(n);
        return true;
    }

    /**Function to calculate the maximum difference between the maxPrimeIndex and minPrime Index*/
    public int maximumPrimeDifference(int[] nums) {
        int lowestInd = -1, highestInd = -1;
        for (int i = 0; i < nums.length; i++) {
            // checking if the current number is prime
            if (isPrime(nums[i])) {
                // if yes then we check if lowest and highest is assigned
                if (lowestInd == -1) lowestInd = i;
                // if already assigned we find min value for minIndex
                else lowestInd = Math.min(i, lowestInd);
                if (highestInd == -1) highestInd = i;
                // if assigned we find max value for highestIndex
                else highestInd = Math.max(highestInd, i);
            }
        }
        return Math.abs(highestInd - lowestInd);
    }
}
