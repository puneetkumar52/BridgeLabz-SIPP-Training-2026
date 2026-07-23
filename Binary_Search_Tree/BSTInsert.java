public class BSTInsert {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static Node insert(Node node, int id) {
        if (node == null) return new Node(id);
        if (id < node.val) node.left = insert(node.left, id);
        else if (id > node.val) node.right = insert(node.right, id);
        return node;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 60);
        System.out.println(root.right.left.val); 
    }
}
