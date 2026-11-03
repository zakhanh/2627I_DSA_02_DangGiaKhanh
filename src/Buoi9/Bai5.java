package Buoi9;

public class Bai5 {
    class Node {
        int data;
        Node left;
        Node right;
    }
    boolean checkBST(Node root){
        return checkNode(root,-1,100001);
    }
    boolean checkNode(Node node, int min,int max){
        if (node==null){
            return true;
        }
        if (node.data<=min || node.data>=max){
            return false;
        }
        return checkNode(node.left,min,node.data)&&
                checkNode(node.right,node.data,max);
    }
}
