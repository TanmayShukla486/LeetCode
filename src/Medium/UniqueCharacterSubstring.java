package Medium;

public class UniqueCharacterSubstring {
    public int lengthOfLongestSubstring(String s) {
        // Create a hash array to store the occurrence count of characters (ASCII range)
        char[] hash = new char[65535];

        // Initialize variables for tracking the start index and the length of the longest substring
        int start = 0;
        int len = 0;

        // Initialize the loop counter
        int i = 0;

        // Iterate through the characters of the string
        while (i < s.length()) {
            // Get the current character
            char c = s.charAt(i);

            // Increment the count of occurrences of the current character
            hash[c]++;

            // If the current character has occurred more than once in the substring
            if (hash[c] > 1) {
                // Update the length of the longest substring
                len = Math.max(len, i - start);

                // Move the start index until the duplicate character is no longer in the substring
                while (start < s.length() && s.charAt(start) != c) {
                    // Reset the occurrence count of characters encountered during this movement
                    hash[s.charAt(start)] = 0;
                    start++;
                }

                // Set the occurrence count of the new start character to 1
                hash[start] = 1;
                // Move the start index to the next character
                start++;
            }

            // Move to the next character in the string
            i++;
        }

        // Update the length of the longest substring if needed (in case the end of the string is reached)
        len = Math.max(len, i - start);

        // Return the length of the longest substring without repeating characters
        return len;
    }


    public static void main(String[] args) {
        new UniqueCharacterSubstring().lengthOfLongestSubstring("ggububgvfk");
    }
}
