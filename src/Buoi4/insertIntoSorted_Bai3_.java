package Buoi4;

import java.util.Scanner;

public class insertIntoSorted_Bai3_ {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : " "));
        }
        System.out.println();
    }
    static void insertionSort(int[] arr){
        for (int i=1; i<=arr.length-1 ;i++){
            int key=arr[i];
            int j=i - 1;
            while (j>=0 && arr[j] > key ){
                arr[j+1]=arr[j];
                j-=1;
            }
            arr[j+1] =key;
            printArray(arr);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số phần tử n: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Nhập " + n + " số nguyên: ");
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Các bước xếp:");
        insertionSort(arr);

        System.out.println("Mảng sau khi đã sắp xếp:");
        printArray(arr);
        sc.close();
    }
}
