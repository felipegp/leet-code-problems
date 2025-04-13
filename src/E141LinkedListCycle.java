import java.util.HashSet;
import java.util.Set;

public class E141LinkedListCycle {

    public static void main(String[] args) {

        ListNode node5 = new ListNode(6);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        node5.next = head;

        boolean result = hasCycle(head);

        System.out.println(result);
    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        boolean foundCycle = false;

        while (!foundCycle) {
            if (head == null || head.next == null) {
                break;
            } else {
                if (visited.contains(head.next)) {
                    foundCycle = true;
                } else {
                    visited.add(head);
                    head = head.next;
                }
            }
        }

        return foundCycle;
    }
}



