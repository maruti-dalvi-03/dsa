/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package md.dsa_practicals;

/**
 *
 * @author maruti
 */
import java.util.Arrays;
public class QuickSort {
    // Function to perform Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);
            // Recursively sort elements before and after the pivot
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    // Partition function
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot element
        int i = low - 1; // Index of smaller element
        for (int j = low; j < high; j++) {
            // If the current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i+1] and arr[high] (the pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1; // Return the pivot index
    }
    // Main method to test the Quick Sort
    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("Original Array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
