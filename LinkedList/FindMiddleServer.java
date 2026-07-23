public class FindMiddleServer {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    static Node findMiddleServer(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        System.out.println("Middle: " + findMiddleServer(head).val);
    }
}
