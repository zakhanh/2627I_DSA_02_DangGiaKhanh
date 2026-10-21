package Buoi7;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B3 {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        if(!scanner.hasNextInt()) return;
        int n=scanner.nextInt();
        long k=scanner.nextLong();
        PriorityQueue<Long> pq =new PriorityQueue<>(n);
        for (int i=0;i<n;i++){
            pq.add(scanner.nextLong());
        }
        int count =0;

        while (pq.size() >=2 && pq.peek()<k){
            long m1=pq.poll();
            long m2=pq.poll();

            long newVal=m1+2*m2;
            pq.add(newVal);
            count++;
        }
        if (pq.peek()<k){
            System.out.println("-1");
        }else{
            System.out.println(count);
        }
        scanner.close();
    }
}
