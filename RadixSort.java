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
public class RadixSort {
    // Main function to implement Radix Sort
    public static void radixSort(int[] arr) {
        // Find the maximum number to determine the number of digits
        int max = Arrays.stream(arr).max().getAsInt();
        // Apply counting sort for each digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }
    //Counting sort used as a subroutine
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array to store sorted numbers
        int[] count = new int[10]; // Count array for digits 0-9
        // Count the occurrences of each digit at the current position
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }
        // Update count[i] to store the actual position of this digit in output
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        // Build the output array by placing numbers in sorted order of the current digit
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
       // Copy the sorted numbers back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }
   // Driver function to test the algorithm
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original Array: " + Arrays.toString(arr));

        radixSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
