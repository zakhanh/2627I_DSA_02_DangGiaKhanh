package Buoi5;

import java.util.Arrays;

public class Bai1 {
    public static int introTutorial(int V, int[] arr){
        int left = 0;
        int right = arr.length -1;
        while (left<=right){
            int mid =(left+right)/2;
            if(arr[mid] == V){
                return mid;
            }else if(arr[mid]<V){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int V =4;
        int[] arr= {1,4,5,7,9,12};

        System.out.println("===== INPUT =====");
        System.out.println("V = " + V);
        System.out.println("arr = " + Arrays.toString(arr));

        int result=introTutorial(V,arr);

        System.out.println("\n===== OUTPUT =====");
        System.out.println(result);
    }
}
