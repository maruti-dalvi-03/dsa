package md.dsa_practicals;

import java.util.Scanner;
public class SelectionSortSteps {
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

        // Perform Selection Sort with steps
        selectionSortWithSteps(arr);

        System.out.println("Sorted array:");
        printArray(arr);
        scanner.close();
    }

    // Selection sort with step-by-step output
    public static void selectionSortWithSteps(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Index of the smallest element
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the smallest element with the first element of the unsorted portion
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            // Print the array after each pass
            System.out.println("\nAfter pass " + (i + 1) + ":");
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
