public class TreeDiameter {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static int diameter;

    static int longestCommunicationPath(Node root) {
        diameter = 0;
        heightAndUpdate(root);
        return diameter;
    }

    private static int heightAndUpdate(Node node) {
        if (node == null) return -1;
        int left = heightAndUpdate(node.left);
        int right = heightAndUpdate(node.right);
        diameter = Math.max(diameter, left + right + 2);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(longestCommunicationPath(root)); 
    }
}
