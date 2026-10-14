package Buoi6;

import java.util.Arrays;
import java.util.Random;

public class B3_QuickSortExperiment {
    private static int partition(int[] arr, int low, int high){
        int pivot =arr[high];
        int i= low-1;
        for (int j=low; j<high;j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i +1,high);
        return i+1;
    }

    private static void quickSort(int[] arr,int low, int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    private static void shuffleArray(int[] arr){
        Random rnd=new Random();
        for (int i=arr.length-1;i>0;i--){
            int index=rnd.nextInt(i+1);
            swap(arr,i,index);
        }
    }

    public static void sortWithoutShuffle(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    public static void sortWithShuffle(int[] arr){
        shuffleArray(arr);
        quickSort(arr,0,arr.length -1);
    }

    private static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]= temp;
    }

    public static void main(String[] args){
        int N=10000;
        int[] originalArray=new int[N];
        for (int i=0;i<N;i++){
            originalArray[i]=i;
        }
        // Tạo 2 bản sao của dữ liệu cho 2 bài test
        int[] arr1 = Arrays.copyOf(originalArray, originalArray.length);
        int[] arr2 = Arrays.copyOf(originalArray, originalArray.length);
        System.out.println("--- KHẢO SÁT QUICKSORT (N = " + N + ") ---");
        System.out.println("Dữ liệu đầu vào: Mảng đã được sắp xếp tăng dần.\n");
        // Test 1: Không có Shuffle
        long startTime1 = System.nanoTime();
        sortWithoutShuffle(arr1);
        long endTime1 = System.nanoTime();
        double time1 = (endTime1 - startTime1) / 1_000_000.0;
        System.out.println("(1) QuickSort KHÔNG Shuffle: " + time1 + " ms");

        // Test 2: Có Shuffle
        long startTime2 = System.nanoTime();
        sortWithShuffle(arr2);
        long endTime2 = System.nanoTime();
        double time2 = (endTime2 - startTime2) / 1_000_000.0;
        System.out.println("(2) QuickSort CÓ Shuffle: " + time2 + " ms");
    }
}
