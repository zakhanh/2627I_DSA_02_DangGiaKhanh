package Buoi2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class bai148 {
    public static long countEqualPairsFromFile(String path) throws FileNotFoundException{
        List<Integer> list =new ArrayList<>();
        Scanner sc=new Scanner(new File(path));
        while (sc.hasNextInt()) list.add(sc.nextInt());
        sc.close();

        int[] a= new int[list.size()];
        for (int i=0; i<list.size();i++) a[i]=list.get(i);

        Arrays.sort(a); //NlogN

        long pairs =0;
        int i=0;
        while (i < a.length){
            int j=i+1;
            while (j<a.length && a[j]==a[i]) j++;
            long k =j-i; //số lần lặp của a[i].
            pairs+= k*(k-1)/2; //số cặp, ví dụ 222 thì có 3 cặp.
            i=j;
        }
        return pairs;
    }

    public static void main(String[] args) throws Exception{
        String filePath ="src/Buoi2/number.txt";
        System.out.println(countEqualPairsFromFile(filePath));
    }
}
