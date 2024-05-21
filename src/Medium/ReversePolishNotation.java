package Medium;

import java.util.Stack;

public class ReversePolishNotation {
    // Helper function to check if a string is an arithmetic operator
    private boolean isOperator(String s) {
        return s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-");
    }

    // Helper function to perform the calculation based on the operator
    private int getValue(String operator, int first, int second) {
        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" ->  first * second;
            case "/" ->  first / second;
            default ->  0; // Handle invalid operators (optional)
        };
    }

    // Function to evaluate a Reverse Polish Notation expression
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); // Stack to store operands

        for (String token : tokens) {
            if (!isOperator(token)) { // If it's not an operator
                stack.add(Integer.parseInt(token)); // Convert token to integer and push onto the stack
            } else { // If it's an operator
                int first = stack.pop(); // Pop the second operand (following RPN)
                int second = stack.pop(); // Pop the first operand
                stack.push(getValue(token, second, first)); // Perform calculation and push the result
            }
        }

        return stack.peek(); // Return the final result from the top of the stack
    }
}
