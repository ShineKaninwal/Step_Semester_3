import java.util.*;

// Provisional implementation: the exact assignment statement was not provided.
// Demonstrates a doubly linked list traversed in both directions.
public class TrainCoachesBothWays {
    static class Node {
        int data; Node prev, next;
        Node(int data) { this.data = data; }
    }
    static class Train {
        Node head, tail;
        void addLast(int coach) {
            Node node = new Node(coach);
            if (tail == null) head = node;
            else { tail.next = node; node.prev = tail; }
            tail = node;
        }
        void printForward() {
            for (Node p = head; p != null; p = p.next) System.out.print(p.data + " -> ");
            System.out.println("null");
        }
        void printBackward() {
            for (Node p = tail; p != null; p = p.prev) System.out.print(p.data + " -> ");
            System.out.println("null");
        }
    }
    // Input: n, then n coach numbers
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Train train = new Train();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) train.addLast(sc.nextInt());
        train.printForward();
        train.printBackward();
    }
}