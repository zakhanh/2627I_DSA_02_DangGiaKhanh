package Buoi3;

import java.util.*;
public class SimpleTextEditor {
    static class Command{
        int type;
        String data;
        Command(int type, String data){
            this.type=type;
            this.data=data;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int q= sc.nextInt();
        StringBuilder s = new StringBuilder();
        Stack<Command> stack =new Stack<>();
        for (int i=0;i<q;i++){
            int type =sc.nextInt();
            if(type ==1){
                String w=sc.next();
                stack.push(new Command(1,String.valueOf(w.length())));
                s.append(w);
            } else if(type ==2){
                int k=sc.nextInt();
                String deletedPart =s.substring(s.length()-k);
                stack.push(new Command(2, deletedPart));
                s.delete(s.length() - k, s.length());
            } else if (type == 3) {
                int k = sc.nextInt();
                System.out.println(s.charAt(k - 1));
            } else if(type==4){
                Command cmd=stack.pop();
                if(cmd.type==1){
                    int len=Integer.parseInt(cmd.data);
                    s.delete(s.length() - len, s.length());
                }else if(cmd.type ==2){
                    s.append(cmd.data);
                }
            }
        }
        sc.close();
    }
}
