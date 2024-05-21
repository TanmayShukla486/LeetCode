package Medium;

public class CountAlternatingSubarrays {
    public long countAlternatingSubarrays(int[] nums) {
        int i = 0, j = 1;
        long count = 0;
        while (j < nums.length) {
            if (nums[j] != nums[j - 1]) count += (j - i);
            else {
                i = j; j++;
            }
            j++;
        }
        return count + (long)nums.length;
    }

    public static void main(String[] args) {
        new CountAlternatingSubarrays().countAlternatingSubarrays(
                new int[] {1,0,1,0,1,0,1,0,1,0,0,1,0,1,0,1}
        );
    }
}
