/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package md.dsa_practicals;

import java.util.Scanner;
public class ShellSortSteps {
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
        // Perform Shell Sort with steps
        shellSortWithSteps(arr);
        System.out.println("Sorted array:");
        printArray(arr);
        scanner.close();
    }
    // Shell Sort with step-by-step output
    public static void shellSortWithSteps(int[] arr) {
        int n = arr.length;
        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.println("\nGap = " + gap + ":");
                        // Perform a gapped insertion sort
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
            // Shift earlier gap-sorted elements up until the correct location is found
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                // Put temp (the original arr[i]) in its correct location
                arr[j] = temp;
                // Print the array after each insertion
                printArray(arr);
            }
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

