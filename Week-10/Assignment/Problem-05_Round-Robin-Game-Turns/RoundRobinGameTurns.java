import java.util.*;

// Provisional implementation: the exact assignment statement was not provided.
// Demonstrates a circular singly linked list cycling through player turns.
public class RoundRobinGameTurns {
    static class Node { String player; Node next; Node(String player) { this.player = player; } }
    static class Game {
        Node tail;
        void addPlayer(String player) {
            Node node = new Node(player);
            if (tail == null) { tail = node; node.next = node; }
            else { node.next = tail.next; tail.next = node; tail = node; }
        }
        void play(int turns) {
            if (tail == null) return;
            Node current = tail.next;
            for (int i = 0; i < turns; i++) {
                System.out.println(current.player);
                current = current.next;
            }
        }
    }
    // Input: n, n player names, then number of turns
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) game.addPlayer(sc.next());
        game.play(sc.nextInt());
    }
}