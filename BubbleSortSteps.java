package md.dsa_practicals;

import java.util.Scanner;
public class BubbleSortSteps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input the size of the array
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
        // Perform Bubble Sort with steps
        bubbleSortWithSteps(arr);
        System.out.println("Sorted array:");
        printArray(arr);
        scanner.close();
    }
    // Bubble sort with step-by-step output
    public static void bubbleSortWithSteps(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            System.out.println("\nPass " + (i + 1) + ":");
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                // Print array after each comparison
                printArray(arr);
            }
            // If no swaps occurred, array is sorted
            if (!swapped) {
                System.out.println("No swaps needed. Array is sorted.");
                break;
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
