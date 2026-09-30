package Buoi4;

import java.util.Scanner;

public class W4_25020212 {
    public static void selectionSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int maxIdx =i;
            for (int j=i+1;j<n;j++){
                if (arr[j] > arr[maxIdx]){
                    maxIdx=j;
                }
            }
            int temp=arr[maxIdx];
            arr[maxIdx]=arr[i];
            arr[i] =temp;
        }
    }
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        if(scanner.hasNextInt()){
            int n=scanner.nextInt();
            int [] citations =new int[n];
            for (int i=0; i<n;i++){
                citations[i]=scanner.nextInt();
            }
            selectionSort(citations);
            int hIndex=0;
            for (int i=0;i<n;i++){
                if (citations[i]>=i+1){
                    hIndex=i+1;
                }else{
                    break;
                }
            }
            System.out.println(hIndex);
        }
        scanner.close();
    }
}
