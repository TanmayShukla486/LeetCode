package Hard;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int secondVal = Integer.MAX_VALUE;
        Set<Integer> values = new HashSet<>();
        for (int val: nums){
            values.add(val);
            if (val >= 0) {
                if (minVal > val) {
                    secondVal = minVal;
                    minVal = val;
                } else if (val != minVal && val < secondVal) {
                    secondVal = val;
                }
            }
        }
        if (minVal >= 2) return 1;
        if (minVal + 1 != secondVal) return minVal + 1;
        int key = secondVal + 1;
        while (values.contains(key)) key++;
        return key;
    }

    public static void main(String[] args) {
        new FirstMissingPositive().firstMissingPositive(new int[] {1,2,2,1,3,1,0,4,0});
    }
}
