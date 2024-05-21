package Easy;

public class NumberOfSpecialCharsI {
    public int numberOfSpecialChars(String word) {
        // Arrays to count occurrences of lowercase and uppercase letters (26 letters in English alphabet)
        int[] countLower = new int[26];
        int[] countUpper = new int[26];

        // Iterate through each character in the word
        for (char c : word.toCharArray()) {
            // If the character is lowercase, increment the corresponding count in countLower array
            if (c >= 'a' && c <= 'z') {
                countLower[c - 'a']++;
            }
            // If the character is uppercase, increment the corresponding count in countUpper array
            else if (c >= 'A' && c <= 'Z') {
                countUpper[c - 'A']++;
            }
        }

        // Initialize count of special characters (occur in both lowercase and uppercase forms)
        int count = 0;

        // Iterate through each letter of the alphabet (26 letters)
        for (int i = 0; i < 26; i++) {
            // If the letter occurs in both lowercase and uppercase forms
            if (countLower[i] > 0 && countUpper[i] > 0) {
                count++; // Increment the count of special characters
            }
        }

        // Return the count of special characters
        return count;
    }

}
