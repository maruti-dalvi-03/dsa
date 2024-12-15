/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package md.dsa_practicals;


import java.util.PriorityQueue;
import java.util.Scanner;
class Element implements Comparable<Element> {
    int value;
    int priority;
    // Constructor
    public Element(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }
    // Compare elements based on priority (higher priority comes first)
    @Override
    public int compareTo(Element other) {
        return Integer.compare(other.priority, this.priority); // Max-Heap style
    }
    @Override
    public String toString() {
        return "Value: " + value + ", Priority: " + priority;
    }
}
public class UserInputPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue (Add Element)");
            System.out.println("2. Dequeue (Remove Highest Priority)");
            System.out.println("3. Peek (View Highest Priority)");
            System.out.println("4. Display All Elements");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    System.out.print("Enter priority: ");
                    int priority = scanner.nextInt();
                    priorityQueue.add(new Element(value, priority));
                    System.out.println("Enqueued: " + value + " with priority " + priority);
                    break;
                case 2:
                    if (priorityQueue.isEmpty()) {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    } else {
                        Element removed = priorityQueue.poll();
                        System.out.println("Dequeued: " + removed);
                    }
                    break;
                case 3:
                    if (priorityQueue.isEmpty()) {
                        System.out.println("Queue is empty. Cannot peek.");
                    } else {
                        System.out.println("Highest Priority Element: " + priorityQueue.peek());
                    }
                    break;
                case 4:
                    if (priorityQueue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("All Elements in Priority Queue:");
                        for (Element e : priorityQueue) {
                            System.out.println(e);
                        }
                    }
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
