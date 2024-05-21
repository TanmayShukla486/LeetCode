package Medium;

import java.util.ArrayList;

public class MinStack {
    // Helper class to store both the element value and the minimum value seen so far
    static class Pair {
        int val;
        int min;
        Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    // ArrayList to store Pair objects representing elements and their minimums
    ArrayList<Pair> values = new ArrayList<>();
    // Index of the top element in the stack (points to the last element in values)
    int end = 0;
    // Stores the overall minimum value seen in the stack
    int min = Integer.MAX_VALUE;

    // Constructor - initializes the stack
    public MinStack() {
    }

    // Pushes a new element onto the stack
    public void push(int val) {
        // Update the minimum if the new element is smaller
        min = Math.min(min, val);
        // Create a new Pair with the value and current minimum
        values.add(new Pair(val, min));
        // Update the top index
        end++;
    }

    // Removes the top element from the stack
    public void pop() {
        // Remove the last element from the list
        values.remove(end - 1);
        // Decrement the top index
        end--;
        // Reset minimum to positive infinity if the stack becomes empty
        if (end == 0) {
            min = Integer.MAX_VALUE;
        } else if (min != values.get(end - 1).min) {
            // Update minimum if the popped element held the previous minimum
            min = values.get(end - 1).min;
        }
    }

    // Returns the value of the top element
    public int top() {
        // Return the value from the top Pair
        return values.get(end - 1).val;
    }

    // Returns the current minimum element in the stack
    public int getMin() {
        // Return the minimum value stored in the top Pair
        return values.get(end - 1).min;
    }

}
