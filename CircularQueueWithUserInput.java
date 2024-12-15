package md.dsa_practicals;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author maruti
 */
import java.util.Scanner;
public class CircularQueueWithUserInput {
    private int[] queue; // Array to store the queue elements
    private int front;   // Points to the front element
    private int rear;    // Points to the next insertion position
    private int size;    // Size of the queue
    // Constructor to initialize the queue
    public CircularQueueWithUserInput(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = 0;
        this.rear = 0;
    }
    // Check if the queue is full
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == rear;
    }
    // Add an element to the queue
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + element);
            return;
        }
        queue[rear] = element;
        rear = (rear + 1) % size;
        System.out.println("Enqueued: " + element);
    }
    // Remove and return the front element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int element = queue[front];
        front = (front + 1) % size;
        System.out.println("Dequeued: " + element);
        return element;
    }
    // Peek the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        return queue[front];
    }
    // Display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        int i = front;
        while (i != rear) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println();
    }
    // Main method to test the Circular Queue with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();
        CircularQueueWithUserInput cq = new CircularQueueWithUserInput(size + 1); // +1 to differentiate full vs empty

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int element = scanner.nextInt();
                    cq.enqueue(element);
                    break;
                case 2:
                    cq.dequeue();
                    break;
                case 3:
                    int frontElement = cq.peek();
                    if (frontElement != -1) {
                        System.out.println("Front Element: " + frontElement);
                    }
                    break;
                case 4:
                    cq.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
