package Buoi9;

public class Bai3 {
    static class Node{
        int key;
        Node left, right;

        public Node(int item){
            key=item;
            left=right=null;
        }
    }
    Node root;
    Bai3(){
        root=null;
    }
    void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (key < current.key) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else if (key > current.key) {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
}
