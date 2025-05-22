public class Node<T> {
    T val;
    Node<T> next;
    Node<T> prev;

    Node() {}

    Node(T val) {
        this.val = val;
    }

    Node(T val, Node<T> next) {
        this.val = val;
        this.next = next;
    }
}
