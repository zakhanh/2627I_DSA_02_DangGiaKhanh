package Buoi9;

// Lớp đại diện cho một nút trong cây
class Node {
    int data;
    Node firstChild;
    Node nextSibling;

    public Node(int data) {
        this.data = data;
        this.firstChild = null;
        this.nextSibling = null;
    }
}

// Lớp quản lý Cây tổng quát
class GeneralTree {
    Node root;

    public GeneralTree() {
        this.root = null;
    }

    public void addChild(Node parent, int val) {
        if (parent == null) return;

        Node newNode = new Node(val);

        if (parent.firstChild == null) {
            parent.firstChild = newNode;
        } else {
            Node sibling = parent.firstChild;
            while (sibling.nextSibling != null) {
                sibling = sibling.nextSibling;
            }
            sibling.nextSibling = newNode;
        }
    }

    public void traverse(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        traverse(node.firstChild);
        traverse(node.nextSibling);
    }
}

public class btw9 {
    public static void main(String[] args) {
        GeneralTree tree = new GeneralTree();

        // Tạo nút gốc
        tree.root = new Node(1);

        // Thêm các con cho nút gốc
        tree.addChild(tree.root, 2);
        tree.addChild(tree.root, 3);
        tree.addChild(tree.root, 4);

        // Thêm các con cho nút 2
        tree.addChild(tree.root.firstChild, 5);
        tree.addChild(tree.root.firstChild, 6);

        // In ra kết quả duyệt cây
        System.out.print("Duyet cay (Pre-order): ");
        tree.traverse(tree.root);
    }
}
