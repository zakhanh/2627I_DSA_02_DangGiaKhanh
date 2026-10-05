package Buoi5;

// Counting sort in Java programming

import java.util.Arrays;

public class CountingSort {
    private static void printArray(int[] arr, String label) {
        System.out.println(label + ": " + Arrays.toString(arr));
    }

    private static void printCount(int[] count, String label) {
        System.out.println(label + ": " + Arrays.toString(count));
    }

    void countSort(int array[], int size) {
        int[] output = new int[size + 1];

        printArray(array, "Ban dau");

        // Find the largest element of the array
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        // Initialize count array with all zeros.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            count[array[i]]++;
        }
        printCount(count, "Sau khi dem so luong");

        // Store the cummulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        printCount(count, "Sau khi tinh tong luan luon");

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
            printArray(output, "Cap nhat output sau khi xep phan tu " + array[i]);
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
        printArray(array, "Ket qua sau khi sap xep (Counting Sort)");
    }

    // Driver code
    public static void main(String args[]) {
        int[] data = { 4, 2, 2, 8, 3, 3, 1 };
        int size = data.length;
        CountingSort cs = new CountingSort();
        cs.countSort(data, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
