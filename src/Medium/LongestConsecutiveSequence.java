package Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // Function to find the length of the longest consecutive sequence
    public int longestConsecutive(int[] nums) {
        // Create a set to store unique elements from the array
        Set<Integer> values = new HashSet<>();
        for (int num : nums) {
            values.add(num);
        }

        int count = 0;  // Initialize variable to store the longest sequence length
        int tempCount = 0;  // Temporary counter for current sequence

        for (int i = 0; i < nums.length; i++) {
            tempCount = 0;  // Reset temporary counter for each element

            // Check for consecutive sequence to the left (decreasing)
            int keyLeft = nums[i];
            while (values.contains(keyLeft)) {
                tempCount++;
                values.remove(keyLeft);
                keyLeft--;
            }

            // Check for consecutive sequence to the right (increasing)
            int keyRight = nums[i] + 1;
            while (values.contains(keyRight)) {
                tempCount++;
                values.remove(keyRight);
                keyRight++;
            }

            // Update the longest sequence count
            count = Math.max(count, tempCount);
        }

        return count;  // Return the length of the longest consecutive sequence
    }

}
