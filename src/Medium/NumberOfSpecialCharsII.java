package Medium;

import java.util.Arrays;

public class NumberOfSpecialCharsII {
    public int numberOfSpecialChars(String word) {
        // Arrays to store the index of the last occurrence of each lowercase and
        // first occurrence of each uppercase letter
        int[] finalIndexLower = new int[26];
        int[] finalIndexUpper = new int[26];

        // Initialize arrays with -1 to indicate that no occurrence has been found yet
        Arrays.fill(finalIndexLower, -1);
        Arrays.fill(finalIndexUpper, -1);

        // Convert the word to a character array for easier manipulation
        char[] letters = word.toCharArray();

        // Iterate through each character in the word
        for (int i = 0; i < letters.length; i++) {
            char c = letters[i];
            // If the character is lowercase, update the last occurrence index in finalIndexLower
            if (c >= 'a' && c <= 'z') {
                finalIndexLower[c - 'a'] = i;
            }
            // If the character is uppercase, take its first occurrence
            else if (c >= 'A' && c <= 'Z') {
                // Only update if no occurrence has been found yet
                if (finalIndexUpper[c - 'A'] == -1)
                    finalIndexUpper[c - 'A'] = i;
            }
        }

        // Initialize count of special characters (occur in both lowercase and uppercase forms)
        int count = 0;

        // Iterate through each letter of the alphabet (26 letters)
        for (int i = 0; i < 26; i++) {
            // If the letter occurs in both lowercase and uppercase forms, consider the last occurrence
            // of the lowercase alphabet and the first occurrence of the uppercase alphabet
            if (finalIndexLower[i] >= 0 && finalIndexUpper[i] > finalIndexLower[i]) {
                count++; // Increment the count of special characters
            }
        }

        // Return the count of special characters
        return count;
    }

}
