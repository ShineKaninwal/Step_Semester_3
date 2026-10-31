import java.util.*;

public class ReverseTheQueue {
    static class Node { int data; Node next; Node(int data) { this.data = data; } }
    // O(n) time, O(1) additional space; reverses links without allocating nodes
    static Node reverse(Node head) {
        Node previous = null, current = head;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    static void print(Node head) {
        for (Node p = head; p != null; p = p.next) System.out.print(p.data + " -> ");
        System.out.println("null");
    }
    // Input: n, then n queue values
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.nextInt());
            if (head == null) head = node; else tail.next = node;
            tail = node;
        }
        print(reverse(head));
    }
}