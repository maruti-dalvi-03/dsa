/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package md.dsa_practicals;

import java.util.Stack;
public class ParenthesisBalancing {
    // Function to check if parentheses are balanced
    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        // Traverse the string
        for (char ch : expr.toCharArray()) {
            // Push open brackets onto the stack
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // Check for closing brackets
            else if (ch == ')' || ch == ']' || ch == '}') {
                // If stack is empty, it's unbalanced
                if (stack.isEmpty()) {
                    return false;
                }
                // Pop the top element and check if it matches
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        // If the stack is not empty, it's unbalanced
        return stack.isEmpty();
    }
    // Helper function to check if two brackets are matching pairs
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
    // Main method to test the function
    public static void main(String[] args) {
        String expr = "{[()]}";
        if (isBalanced(expr)) {
            System.out.println("The expression is balanced.");
        } else {
            System.out.println("The expression is not balanced.");
        }
    }
}
