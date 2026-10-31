import java.util.*;

public class CancelledOrdersCleanup {
    static class Node { int data; Node next; Node(int data) { this.data = data; } }
    // O(n) time, O(1) additional space
    static Node removeAll(Node head, int code) {
        while (head != null && head.data == code) head = head.next;
        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.data == code) current.next = current.next.next;
            else current = current.next;
        }
        return head;
    }
    static void print(Node head) {
        for (Node p = head; p != null; p = p.next) System.out.print(p.data + " -> ");
        System.out.println("null");
    }
    // Input: n, n order codes, codeToRemove
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.nextInt());
            if (head == null) head = node; else tail.next = node;
            tail = node;
        }
        int code = sc.nextInt();
        print(removeAll(head, code));
    }
}