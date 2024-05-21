package Medium;

import java.util.Arrays;

/*
You are given two integer arrays nums1 and nums2.

From nums1 two elements have been removed, and all other elements have been increased (or decreased in the case of negative) by an integer, represented by the variable x.

As a result, nums1 becomes equal to nums2. Two arrays are considered equal when they contain the same integers with the same frequencies.

Return the minimum possible integer x that achieves this equivalence.



Example 1:

Input: nums1 = [4,20,16,12,8], nums2 = [14,18,10]

Output: -2

Explanation:

After removing elements at indices [0,4] and adding -2, nums1 becomes [18,14,10].
* */

public class FindTheIntegerAddedToArrayII {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int prevDiff = 0, currDiff = 0;
                boolean sameDiff = true;
                for (int k = 0, l = 0; k < m; l++) {
                    if (l != i && l != j) {
                        currDiff = nums2[k] - nums1[l];
                        if (k != 0 && prevDiff != currDiff) {
                            sameDiff = false;
                            break;
                        }
                        k++;
                        prevDiff = currDiff;
                    }
                }
                if (sameDiff)
                    min = Math.min(min, currDiff);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        new FindTheIntegerAddedToArrayII().minimumAddedInteger(new int[] {3,5,5,3}, new int[]{7,7});
    }
}
