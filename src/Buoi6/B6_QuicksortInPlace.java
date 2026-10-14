package Buoi6;

import java.util.Scanner;

public class B6_QuicksortInPlace {
    private static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " " + (i == arr.length - 1 ? "" : ""));
        }
        System.out.println();
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] arr,int low, int high){
        int pivot =arr[high];
        int i=low;
        for(int j=low;j<high;j++){
            if(arr[j] <= pivot) {
                swap(arr,i,j);
                i=i+1;
            }
        }
        swap(arr,i,high);
        printArray(arr);
        return i;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc số lượng phần tử của mảng
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            // Đọc các phần tử vào mảng
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Bắt đầu gọi QuickSort cho toàn bộ mảng
            quickSort(arr, 0, n - 1);
        }

        scanner.close();
    }
}
