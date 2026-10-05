package Buoi5;

import java.util.*;

public class Bai2 {
    public static void insertionSort(int[] arr){
        int n =arr.length;
        for (int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j-=1;
            }
            arr[j+1] =key;
        }
    }
    public static void mergeSort(int[] arr, int left, int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }
    private static void merge(int[] arr,int left, int mid, int right){
        int n1=mid-left+1;
        int n2=right -mid;
        int[] L =new int[n1];
        int[] R=new int[n2];
        for (int i=0;i<n1;i++) L[i]=arr[left+1];
        for (int j=0;j<n2;j++) R[j]=arr[mid+1+j];
        int i=0,j=0;
        int k=left;
        while (i<n1 && j<n2){
            if (L[i] < R[j]){
                arr[k] =L[i];
                i++;
            }else{
                arr[k] =R[j];
                j++;
            }
            k++;
        }
        while (i<n1){
            arr[k] =L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }
        return arr;
    }

    public static void main(String[]args){
        int[] testSizes = {1000, 10000, 50000}; // Các kích thước khảo sát

        System.out.println("================= KẾT QUẢ KHẢO SÁT THỜI GIAN CHẠY =================");
        System.out.printf("%-15s | %-20s | %-20s%n", "Kích thước (N)", "Insertion Sort (ms)", "Merge Sort (ms)");
        System.out.println("-------------------------------------------------------------------");
        for (int size : testSizes) {
            // Tạo mảng gốc ngẫu nhiên
            int[] originalArr = generateRandomArray(size);

            // Copy mảng để cả 2 thuật toán chạy trên cùng dữ liệu đầu vào
            int[] arrForInsertion = Arrays.copyOf(originalArr, originalArr.length);
            int[] arrForMerge = Arrays.copyOf(originalArr, originalArr.length);

            // Đo thời gian Insertion Sort
            long start1 = System.nanoTime();
            insertionSort(arrForInsertion);
            long end1 = System.nanoTime();
            double timeInsertion = (end1 - start1) / 1_000_000.0;

            // Đo thời gian Merge Sort
            long start2 = System.nanoTime();
            mergeSort(arrForMerge, 0, arrForMerge.length - 1);
            long end2 = System.nanoTime();
            double timeMerge = (end2 - start2) / 1_000_000.0;

            // In dòng kết quả
            System.out.printf("%-15d | %-20.4f | %-20.4f%n", size, timeInsertion, timeMerge);
        }
        System.out.println("===================================================================");
    }

}
