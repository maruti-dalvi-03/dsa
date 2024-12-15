package md.dsa_practicals;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation {
    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        // Traverse the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the character is a digit, push it to the stack
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert character to integer
            } 
            // If the character is an operator, pop two elements, apply the operator, and push the result
            else {
                // Error check: Ensure there are at least two operands in the stack
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Malformed postfix expression: Insufficient operands.");
                }

                int operand2 = stack.pop(); // Second operand
                int operand1 = stack.pop(); // First operand

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero.");
                        }
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }
            }
        }

        // After traversal, the stack should contain exactly one element
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Malformed postfix expression: Excess operands.");
        }

        // The result is the only element left in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a postfix expression (e.g., 235*4+): ");
        String expression = scanner.nextLine();

        try {
            int result = evaluatePostfix(expression);
            System.out.println("The result of the postfix expression is: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
