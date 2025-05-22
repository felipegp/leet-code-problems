
public class MyQueue {

    public static void main(String[] args) {
        Queue<Integer> myQueue = new Queue<>();
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.printQueue();
        System.out.println(myQueue.peek());
        myQueue.enqueue(30);
        myQueue.printQueue();
        System.out.println(myQueue.dequeue());
        myQueue.printQueue();
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.printQueue();
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.printQueue();

    }
    public static class Queue<T> {
        private Node<T> head;
        private Node<T> tail;
        private int length = 0;

        Queue() {}

        T peek() {
            return tail != null ? tail.val : null;
        }

        void enqueue(T value) {
            Node<T> newNode = new Node<>(value);

            if (length == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }

            length++;
        }

        T dequeue() {
            if (length == 0) {
                return null;
            }

            T temp = tail.val;

            if (length == 1) {
                head = null;
                tail = null;
            } else {
                Node<T> prev = tail.prev;
                prev.next = null;
                tail = prev;
            }

            length--;
            return temp;
        }

        void printQueue() {
            StringBuilder sb = new StringBuilder();
            Node<T> pointer = head;

            sb.append("[ ");

            while (pointer != null) {
                sb.append(pointer.val).append(" ");
                pointer = pointer.next;
            }

            sb.append(" ]");

            System.out.println(sb);
        }


    }

}

