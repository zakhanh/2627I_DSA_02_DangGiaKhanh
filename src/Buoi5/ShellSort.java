package Buoi5;

// Shell sort in Java programming

import java.util.Arrays;

// Shell sort
public class ShellSort {
    private static void printArray(int[] arr, String label) {
        System.out.println(label + ": " + Arrays.toString(arr));
    }

    // Rearrange elements at each n/2, n/4, n/8, ... intervals
    void shellSort(int array[], int n) {
        System.out.println("Bat dau Shell Sort");
        printArray(array, "Mang ban dau");

        for (int interval = n / 2; interval > 0; interval /= 2) {
            System.out.println("\nInterval = " + interval);
            for (int i = interval; i < n; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
                    array[j] = array[j - interval];
                    printArray(array, "Dich trai tai vi tri " + j + " voi temp = " + temp);
                }
                array[j] = temp;
                printArray(array, "Gan temp vao vi tri " + j);
            }
        }

        printArray(array, "Ket qua sau khi sap xep (Shell Sort)");
    }

    // Driver code
    public static void main(String args[]) {
        int[] data = { 9, 8, 3, 7, 5, 6, 4, 1 };
        int size = data.length;
        ShellSort ss = new ShellSort();
        ss.shellSort(data, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
