public class BSTSearch {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static boolean search(Node root, int target) {
        Node current = root;
        while (current != null) {
            if (target == current.val) return true;
            current = (target < current.val) ? current.left : current.right;
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        System.out.println(search(root, 30)); 
        System.out.println(search(root, 90)); 
    }
}
