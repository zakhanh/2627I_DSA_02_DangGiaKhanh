package Buoi1;

import java.util.Arrays;
public class BuggyQuickFind {
    private final int[] leader;

    public BuggyQuickFind(int n){
        leader = new int[n];
        for (int i=0;i<n;i++){
            leader[i] =i;

        }
    }

    public int find(int i){
        return leader[i];
    }
    //union sai 1 cach co tinh
    public void union(int p, int q){
        for (int i=0;i<leader.length;i++){
            if (leader[i] == leader[p]){
                leader[i] = leader[q];
            }
        }
    }

    public int[] snapshot(){
        return leader;
    }
    public static void main(String[] args){
        BuggyQuickFind uf= new BuggyQuickFind(3);
        System.out.println("Initial leader: " + Arrays.toString(uf.snapshot()));
        uf.union(0,1);
        System.out.println("After union(0,1): "+ Arrays.toString(uf.snapshot()));
        uf.union(0,2);
        System.out.println("After union(0,2): " + Arrays.toString(uf.snapshot()));
        int i=0, j=1;
        System.out.println("find(i)= " + uf.find(i));
        System.out.println("find(j)= " + uf.find(j));
        System.out.println("Expected i add j should still be the same, but not -> BUG.");
    }
}
