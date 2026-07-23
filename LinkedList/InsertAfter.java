public class InsertAfter {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    static void insertAfter(Node current, int trackId) {
        Node newNode = new Node(trackId);
        newNode.next = current.next;
        current.next = newNode;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        insertAfter(head, 99);
        System.out.println(head.val + " -> " + head.next.val + " -> " + head.next.next.val);
    }
}
