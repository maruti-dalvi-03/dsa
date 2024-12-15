package md.dsa_practicals;

import java.util.Scanner;

// Stack class using an array
class Stack {
    private int maxSize;
    private int top;
    private int[] stack;

    // Constructor to initialize the stack with a maximum size
    public Stack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Stack size must be a positive number.");
        }
        maxSize = size;
        stack = new int[maxSize];
        top = -1;  // Stack is empty when top is -1
    }

    // Push operation
    public void push(int data) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow. Cannot push " + data);
        } else {
            stack[++top] = data;
            System.out.println(data + " pushed to stack");
        }
    }

    // Pop operation
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow. Nothing to pop.");
        } else {
            int popped = stack[top];
            stack[top--] = 0; // Clear the value after popping
            System.out.println(popped + " popped from stack");
        }
    }

    // Peek operation
    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
        } else {
            System.out.println("Top element is: " + stack[top]);
        }
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Get the size of the stack
    public void getSize() {
        System.out.println("Size of stack: " + (top + 1));
    }

    // Display all elements of the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the stack size from the user with validation
        int size;
        while (true) {
            System.out.print("Enter the maximum size of the stack: ");
            size = scanner.nextInt();
            if (size > 0) break;
            System.out.println("Invalid size. Please enter a positive number.");
        }

        Stack stack = new Stack(size);
        int choice;

        // Menu-driven program
        do {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Stack is Empty");
            System.out.println("5. Get Stack Size");
            System.out.println("6. Display Stack");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Push operation
                    System.out.print("Enter element to push: ");
                    int data = scanner.nextInt();
                    stack.push(data);
                    break;
                case 2:
                    // Pop operation
                    stack.pop();
                    break;
                case 3:
                    // Peek operation
                    stack.peek();
                    break;
                case 4:
                    // Check if stack is empty
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;
                case 5:
                    // Get size of stack
                    stack.getSize();
                    break;
                case 6:
                    // Display stack
                    stack.display();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
