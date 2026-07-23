public class PostOrderDeletion {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static void deleteFolderTree(Node node) {
        if (node == null) return;
        deleteFolderTree(node.left);
        deleteFolderTree(node.right);
        deleteNode(node);
    }

    static void deleteNode(Node node) {
        System.out.println("Deleting folder: " + node.val);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        deleteFolderTree(root);
    }
}
