public class BSTLCA {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static Node lowestCommonAncestor(Node root, int p, int q) {
        Node current = root;
        while (current != null) {
            if (p < current.val && q < current.val) current = current.left;
            else if (p > current.val && q > current.val) current = current.right;
            else return current;
        }
        return null;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        Node lca = lowestCommonAncestor(root, 5, 15);
        System.out.println(lca.val); // 10
    }
}
