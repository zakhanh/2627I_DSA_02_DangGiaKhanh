package Buoi3;

import java.io.*;
import java.util.*;

public class BalancedBracekets {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int q= sc.nextInt();
        Stack<Integer> stackIn=new Stack<>();
        Stack<Integer> stackOut = new Stack<>();
        for (int i=0; i<q;i++){
            int type =sc.nextInt();
            if (type ==1){
                int x=sc.nextInt();
                stackIn.push(x);
            }else{
                if (stackOut.isEmpty()){
                    while (!stackIn.isEmpty()){
                        stackOut.push(stackIn.pop());
                    }
                }
                if (type==2){
                    stackOut.pop();
                } else if (type ==3){
                    System.out.println(stackOut.peek());
                }
            }
        }
        sc.close();
    }
}
