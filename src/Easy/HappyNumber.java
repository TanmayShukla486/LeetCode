package Easy;

public class HappyNumber {
    // Function to calculate the sum of squares of digits in a number
    private int sumDigits(int n) {
        int answer = 0;  // Initialize a variable to store the sum of squares
        while (n > 0) {
            int digit = n % 10;  // Extract the last digit using modulo operator
            answer += digit * digit;  // Square the digit and add it to the sum
            n /= 10;  // Remove the last digit by integer division
        }
        return answer;  // Return the sum of squares
    }

    // Function to check if a number is happy
    public boolean isHappy(int n) {
        int slow = n;  // Initialize slow pointer to the original number
        int fast = n;  // Initialize fast pointer to the original number
        do {
            slow = sumDigits(slow);  // Update slow by summing squares of its digits
            fast = sumDigits(sumDigits(fast));  // Update fast by summing squares twice
        } while (slow != fast);  // Continue looping as long as slow and fast differ

        return slow == 1;  // Happy number if slow reaches 1, otherwise not
    }

}
