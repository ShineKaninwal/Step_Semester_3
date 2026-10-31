import java.util.*;

public class PriorityTokenInsertion {
    static class Node { int data; Node next; Node(int data) { this.data = data; } }
    private Node head;
    private int size;
    // O(1) time
    void addFirst(int token) { Node node = new Node(token); node.next = head; head = node; size++; }
    // O(n) time
    void addLast(int token) { insertAt(size, token); }
    // O(n) time, O(1) additional space
    void insertAt(int index, int token) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) { addFirst(token); return; }
        Node prev = head;
        for (int i = 1; i < index; i++) prev = prev.next;
        Node node = new Node(token);
        node.next = prev.next;
        prev.next = node;
        size++;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node p = head; p != null; p = p.next) sb.append(p.data).append(" -> ");
        return sb.append("null").toString();
    }
    // Input: n, n starting tokens, operationCount, then lines: addFirst x / addLast x / insertAt index x
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityTokenInsertion list = new PriorityTokenInsertion();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) list.addLast(sc.nextInt());
        int operations = sc.nextInt();
        for (int i = 0; i < operations; i++) {
            String op = sc.next();
            switch (op) {
                case "addFirst": list.addFirst(sc.nextInt()); break;
                case "addLast": list.addLast(sc.nextInt()); break;
                case "insertAt": list.insertAt(sc.nextInt(), sc.nextInt()); break;
                default: throw new IllegalArgumentException("Unknown operation: " + op);
            }
        }
        System.out.println(list);
    }
}