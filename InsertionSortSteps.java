/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package md.dsa_practicals;

import java.util.Scanner;
public class InsertionSortSteps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input the size of the arrayy
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Original array:");
        printArray(arr);
        // Perform Insertion Sort with steps
        insertionSortWithSteps(arr);
        System.out.println("Sorted array:");
        printArray(arr);
        scanner.close();
    }
    // Insertion sort with step-by-step output
    public static void insertionSortWithSteps(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Current element to be inserted
            int j = i - 1;
            // Move elements of the sorted portion that are greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Insert the current element at the correct position
            arr[j + 1] = key;
            // Print the array after each insertion
            System.out.println("\nAfter inserting element " + key + ":");
            printArray(arr);
        }
    }
 // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
